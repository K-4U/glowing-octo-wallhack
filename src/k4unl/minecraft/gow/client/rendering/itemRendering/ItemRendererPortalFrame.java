package k4unl.minecraft.gow.client.rendering.itemRendering;

import k4unl.minecraft.gow.client.rendering.RendererPortalFrame;
import k4unl.minecraft.gow.tileEntities.TilePortalFrame;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRendererPortalFrame implements IItemRenderer{
	private static RendererPortalFrame portalFrameRenderer = new RendererPortalFrame();
	
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
		portalFrameRenderer.doRender(new TilePortalFrame(), x, y, z, 0);
	}
	
	 
}
