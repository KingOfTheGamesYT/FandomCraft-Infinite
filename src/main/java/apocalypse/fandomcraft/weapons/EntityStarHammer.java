package apocalypse.fandomcraft.weapons;

import net.minecraft.item.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;

public class EntityStarHammer extends ItemSword
{
    public EntityStarHammer(final Item.ToolMaterial material) {
        super(material);
    }
    
    public int getRenderType() {
        return -1;
    }
    
    public void renderSpecial() {
        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("fandomcraft:" + this.getUnlocalizedName().substring(5));
    }
}
