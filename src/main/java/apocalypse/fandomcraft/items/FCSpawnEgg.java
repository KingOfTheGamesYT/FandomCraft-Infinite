package apocalypse.fandomcraft.items;

import apocalypse.fandomcraft.events.RegistryHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FCSpawnEgg extends Item
{
    private static final Map<String, Class<? extends Entity>> CLASS_MAP = new HashMap();
    private static final Map<String, int[]> COLOR_MAP = new HashMap();
    private static final String TAG_ENTITY = "FC_Entity";

    public FCSpawnEgg()
    {
        setHasSubtypes(true);
        setMaxStackSize(64);
        setCreativeTab(RegistryHandler.tabFandomCraftMisc);
        setUnlocalizedName("fc_spawn_egg");
    }

    public static void registerEntity(Class<? extends Entity> entityClass, String name, int primary, int secondary)
    {
        CLASS_MAP.put(name, entityClass);
        COLOR_MAP.put(name, new int[]{primary, secondary});
    }

    public static Class<? extends Entity> getEntity(String name)
    {
        return CLASS_MAP.get(name);
    }

    private String getNameFromStack(ItemStack stack)
    {
        if (stack == null || !stack.hasTagCompound())
        {
            return null;
        }
        return stack.getTagCompound().getString(TAG_ENTITY);
    }

    public static ItemStack createEgg(String name)
    {
        ItemStack stack = new ItemStack(RegistryHandler.fcSpawnEgg);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString(TAG_ENTITY, name);
        stack.setTagCompound(tag);

        return stack;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (String name : COLOR_MAP.keySet())
        {
            list.add(createEgg(name));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        String name = getNameFromStack(stack);

        if (name == null)
        {
            return "item.null";
        }

        return "item." + name.toLowerCase() + "_spawn_egg";
    }

    @SideOnly(Side.CLIENT)
    private IIcon baseIcon;

    @SideOnly(Side.CLIENT)
    private IIcon overlayIcon;

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister reg)
    {
        this.baseIcon = reg.registerIcon("minecraft:spawn_egg");
        this.overlayIcon = reg.registerIcon("minecraft:spawn_egg_overlay");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamageForRenderPass(int meta, int pass)
    {
        return pass == 0 ? baseIcon : overlayIcon;
    }

    @Override
    public int getColorFromItemStack(ItemStack stack, int pass)
    {
        String name = getNameFromStack(stack);

        if (name == null)
        {
            return 0xFFFFFF;
        }

        int[] colors = COLOR_MAP.get(name);

        if (colors == null)
        {
            return 0xFFFFFF;
        }
        return pass == 0 ? colors[0] : colors[1];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            spawnEntity(world, getNameFromStack(stack), player.posX, player.posY + 1, player.posZ);
        }
        return stack;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(x, y, z);

        if (block == Blocks.mob_spawner)
        {
            if (!world.isRemote)
            {
                TileEntity tile = world.getTileEntity(x, y, z);

                if (tile instanceof TileEntityMobSpawner)
                {
                    String name = getNameFromStack(stack);

                    if (name != null)
                    {
                        TileEntityMobSpawner spawner = (TileEntityMobSpawner) tile;
                        spawner.func_145881_a().setEntityName(name);
                        world.markBlockForUpdate(x, y, z);

                        if (!player.capabilities.isCreativeMode)
                        {
                            stack.stackSize--;
                        }
                    }
                }
            }
            return true;
        }

        if (!world.isRemote)
        {
            spawnEntity(world, getNameFromStack(stack),x + 0.5,y + 1,z + 0.5);
        }
        return true;
    }

    private void spawnEntity(World world, String name, double x, double y, double z)
    {
        if (name == null) return;
        Class<? extends Entity> clazz = CLASS_MAP.get(name);
        if (clazz == null) return;

        try
        {
            Entity entity = clazz.getConstructor(World.class).newInstance(world);
            entity.setLocationAndAngles(x, y, z,world.rand.nextFloat() * 360F,0F);

            world.spawnEntityInWorld(entity);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed spawning entity: " + name, e);
        }
    }

    public static void spawnFromDispenser(ItemStack stack, World world, double x, double y, double z)
    {
        if (stack == null)
        {
            return;
        }

        if (!stack.hasTagCompound())
        {
            return;
        }

        String name = stack.getTagCompound().getString("FC_Entity");
        Class<? extends Entity> clazz = CLASS_MAP.get(name);

        if (clazz == null)
        {
            return;
        }

        try
        {
            Entity entity = clazz.getConstructor(World.class).newInstance(world);
            entity.setLocationAndAngles(x, y, z,world.rand.nextFloat() * 360F,0F);
            world.spawnEntityInWorld(entity);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Dispenser spawn failed: " + name, e);
        }
    }
}