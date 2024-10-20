package apocalypse.fandomcraft.blocks;

import apocalypse.fandomcraft.main.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BarbedWire extends Block {
    public BarbedWire() {
        super(Material.iron);
        this.setCreativeTab(Main.tabFandomCraftBlocks);
    }


    public boolean isOpaqueCube() {
        return false;
    }

    // Damage entities that step on the block
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof EntityLiving) {
            entity.attackEntityFrom(DamageSource.generic, 4.0F); // Deal 4 damage to players
        }
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType() {
        return 1;
    }


    public boolean renderAsNormalBlock() {
        return false;
    }


    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest() {
        return true;
    }
}
