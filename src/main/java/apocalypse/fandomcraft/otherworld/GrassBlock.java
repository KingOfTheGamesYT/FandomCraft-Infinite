package apocalypse.fandomcraft.otherworld;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.common.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.item.*;
import apocalypse.fandomcraft.horror.*;

public class GrassBlock extends Block
{
    String blockName;
    String blockTexture;
    Block.SoundType blockSound;
    
    protected GrassBlock(final Material materialIn) {
        super(materialIn);
        this.setStepSound(GrassBlock.soundTypeGrass);
    }
    
    public boolean canSustainPlant(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection direction, final IPlantable plantable) {
        return true;
    }
    
    public void onPlantGrow(final World world, final int x, final int y, final int z, final int sourceX, final int sourceY, final int sourceZ) {
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("tutorial:" + this.blockTexture);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return this.blockIcon;
    }
    
    public boolean isOpaqueCube() {
        return true;
    }
    
    public Item getItemDropped(final int metadata, final Random random, final int fortune) {
        return Item.getItemFromBlock(HorrorReg.bloodGrass);
    }
    
    public int quantityDropped(final Random random) {
        return 1;
    }
}
