package apocalypse.fandomcraft.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCharger extends RenderLiving {

    public RenderCharger(ModelBase modelBase, float shadowSize) {
        super(modelBase, shadowSize);
    }

    public void doRender(final Entity entity, final double var2, final double var4, final double var6, final float var8, final float var9) {
        super.doRender(entity, var2, var4, var6, var8, var9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation("fandomcraft", "textures/models/entity/charger.png");
    }
}