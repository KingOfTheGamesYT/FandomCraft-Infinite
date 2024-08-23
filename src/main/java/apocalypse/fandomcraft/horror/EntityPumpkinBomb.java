package apocalypse.fandomcraft.horror;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPumpkinBomb extends EntityThrowable {
    public EntityPumpkinBomb(World world) {
        super(world);
    }

    public EntityPumpkinBomb(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    public EntityPumpkinBomb(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    protected void onImpact(MovingObjectPosition mop) {
        if (mop.entityHit != null) {
            float damageCount = 7.0F;
            mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damageCount);
        }

        if (!this.worldObj.isRemote) {
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2.0F, true);
            this.setDead();
        }

    }
}
