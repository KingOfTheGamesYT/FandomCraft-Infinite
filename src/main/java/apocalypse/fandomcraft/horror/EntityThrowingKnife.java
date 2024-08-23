package apocalypse.fandomcraft.horror;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityThrowingKnife extends EntityThrowable {
    float power = 5.0F;

    public EntityThrowingKnife(World world) {
        super(world);
    }

    public EntityThrowingKnife(World world, EntityLivingBase entity, float f) {
        super(world, entity);
        this.power = f;
    }

    public EntityThrowingKnife(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    protected void onImpact(MovingObjectPosition mop) {
        if (mop.entityHit != null) {
            mop.entityHit.hurtResistantTime = 0;
            mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.power);
            if (mop.entityHit instanceof EntityLiving) {
                EntityLiving living = (EntityLiving)mop.entityHit;
                if (mop.entityHit != null) {
                    float damage = 3.0F;
                    mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage);
                }

                for(int l = 0; l < 5; ++l) {
                    this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
                }

                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
            }
        } else if (!this.worldObj.isRemote) {
            this.setDead();
        }

    }
}
