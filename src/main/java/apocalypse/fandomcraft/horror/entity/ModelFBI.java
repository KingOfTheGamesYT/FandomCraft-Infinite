package apocalypse.fandomcraft.horror.entity;

import net.minecraft.client.model.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.entity.*;

@SideOnly(Side.CLIENT)
public class ModelFBI extends ModelBiped
{
    public void setLivingAnimations(final EntityLivingBase p_78086_1_, final float p_78086_2_, final float p_78086_3_, final float p_78086_4_) {
        this.aimedBow = (((EntityFBI)p_78086_1_).getSkeletonType() == 1);
        super.setLivingAnimations(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
    }
    
    public void setRotationAngles(final float p_78087_1_, final float p_78087_2_, final float p_78087_3_, final float p_78087_4_, final float p_78087_5_, final float p_78087_6_, final Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
    }
}
