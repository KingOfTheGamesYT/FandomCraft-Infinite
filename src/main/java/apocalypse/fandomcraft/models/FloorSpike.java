package apocalypse.fandomcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FloorSpike extends ModelBase {
	private final ModelRenderer base;
	private final ModelRenderer spikes;

	public FloorSpike() {
		textureWidth = 64;
		textureHeight = 64;

		base = new ModelRenderer(this);
		base.setRotationPoint(0.0F, 0.0F, 0.0F);
		base.cubeList.add(new ModelBox(base, 0, 31, -8.0F, 20.0F, -8.0F, 16, 4, 16, 0.0F));

		spikes = new ModelRenderer(this);
		spikes.setRotationPoint(0.1F, -5.1F, 0.0F);
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, -8.1F, 19.1F, -8.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, 6.0F, 19.1F, -8.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, -8.1F, 19.1F, -4.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, 5.9F, 19.1F, 1.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, 0.9F, 19.1F, -4.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, -3.6F, 19.1F, 1.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, 0.9F, 19.1F, 1.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, -8.1F, 19.1F, 1.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, 0.9F, 19.1F, -8.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, 6.0F, 19.1F, 6.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, -3.6F, 19.1F, 6.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, -3.6F, 19.1F, -4.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, 6.0F, 19.1F, -4.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, -8.1F, 19.1F, 6.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, 0.9F, 19.1F, 6.0F, 2, 6, 2, 0.0F));
		spikes.cubeList.add(new ModelBox(spikes, 16, 15, -3.6F, 19.1F, -8.0F, 2, 6, 2, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		base.render(f5);
		spikes.render(f5);
	}

	public void renderModel(float f) {
		this.base.render(f);
		this.spikes.render(f);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}