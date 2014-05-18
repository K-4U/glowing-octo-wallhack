package k4unl.minecraft.gow.client.rendering.itemRendering;

import k4unl.minecraft.gow.client.rendering.RendererHelper;
import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRendererIPCard implements IItemRenderer{
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
		case ENTITY:
			render(-0.5F, 0.0F, -0.5F, 1.0F);
			break;
		case EQUIPPED:
			render(-0.2F, 0.4F, 0.3F, 0.8F);
			break;
		case EQUIPPED_FIRST_PERSON:
			render(-1.0F, 1.0F, 0.4F, 0.7F);
			break;
		case FIRST_PERSON_MAP:
			break;
		case INVENTORY:
			render(0.0F, -0.1F, 0.0F, 1.0F);
			break;
		default:
			break;
		}
	}
	
	private void render(float x, float y, float z, float scale){
		
		GL11.glScalef(scale, scale, scale);
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glBegin(GL11.GL_QUADS);
		
		RendererHelper.drawWhiteCube(new Vector3fMax(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F));
		
		GL11.glEnd();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	 
}
