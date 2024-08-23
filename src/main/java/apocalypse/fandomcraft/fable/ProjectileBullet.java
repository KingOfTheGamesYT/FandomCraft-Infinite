package apocalypse.fandomcraft.fable;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ProjectileBullet extends EntityThrowable {
    public float power;
    int fadeTimer = 0;

    public ProjectileBullet(World par1World) {
        super(par1World);
    }

    public ProjectileBullet(World world, EntityLivingBase living, float f) {
        super(world, living);
        this.power = f;
    }

    public ProjectileBullet(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    protected float getGravityVelocity() {
        return 0.001F;
    }

    protected float func_70182_d() {
        return 5.0F;
    }

    public void onUpdate(World world, EntityLivingBase living, EntityLivingBase livingbase, float f1_, float f2_) {
        this.rotationPitch = 90.0F;
        this.posY = living.posY + (double)living.getEyeHeight() - 0.10000000149011612D;
        double d0 = livingbase.posX - living.posX;
        double d1 = livingbase.boundingBox.minY + (double)(livingbase.height / 3.0F) - this.posY;
        double d2 = livingbase.posZ - living.posZ;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);
        if (d3 >= 1.0E-7D) {
            float f2 = (float)(Math.atan2(d2, d0) * 180.0D / 3.141592653589793D) - 90.0F;
            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / 3.141592653589793D));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(living.posX + d4, this.posY, living.posZ + d5, f2, f3);
            this.yOffset = 0.0F;
            float f4 = (float)d3 * 0.2F;
            this.setThrowableHeading(d0, d1 + (double)f4, d2, f1_, f2_);
        }

        ++this.fadeTimer;
        if (this.fadeTimer >= 100) {
            this.setDead();
            this.fadeTimer = 0;
        }

    }

    protected void onImpact(MovingObjectPosition mop) {
        if (mop.entityHit != null) {
            mop.entityHit.hurtResistantTime = 0;
            mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.power);
            if (mop.entityHit instanceof EntityLiving) {
                EntityLiving living = (EntityLiving)mop.entityHit;
                if (mop.entityHit != null) {
                    mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.power);
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

    public void setDamage(double p_70239_1_) {
        this.power = (float)p_70239_1_;
    }

    public void setIsCritical(boolean b) {
        this.power = 10.0F;
    }
}
