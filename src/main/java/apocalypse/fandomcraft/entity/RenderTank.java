package apocalypse.fandomcraft.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;

import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.util.ResourceLocation;

public class RenderTank extends RenderLiving {

    public RenderTank(ModelBase modelBase, float shadowSize) {
        super(modelBase, shadowSize);
    }

    public void doRender(final Entity entity, final double var2, final double var4, final double var6, final float var8, final float var9) {
        BossStatus.setBossStatus((IBossDisplayData)entity, true);
        super.doRender(entity, var2, var4, var6, var8, var9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation("fandomcraft", "textures/models/entity/tank.png");
    }
}