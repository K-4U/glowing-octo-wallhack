package k4unl.minecraft.gow.client.rendering;

import k4unl.minecraft.gow.lib.config.ModInfo;
import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class RendererPortalBase extends TileEntitySpecialRenderer {
	private static final ResourceLocation resLoc = new ResourceLocation(ModInfo.LID, "textures/model/portalBase.png");
	
	
	@Override
	public void renderTileEntityAt(TileEntity ent, double x, double y,
			double z, float frame) {
		doRender((TilePortalBase)ent, x, y, z, frame);

	}
	
	private void doRender(TilePortalBase base, double x, double y, double z, float frame){
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		
		//FMLClientHandler.instance().getClient().getTextureManager().bindTexture(resLoc);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		renderBase();
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
	private void renderBase(){
		GL11.glBegin(GL11.GL_QUADS);
		Vector3fMax pane = new Vector3fMax(0.0F+RendererHelper.pixel, 0.0F, 0.0F+RendererHelper.pixel, 1.0F-RendererHelper.pixel, 1.0F, 1.0F-RendererHelper.pixel);
		Vector3fMax paneSideEW = new Vector3fMax(0.0F, 0.0F+RendererHelper.pixel, 0.0F+RendererHelper.pixel, 1.0F, 1.0F-RendererHelper.pixel, 1.0F-RendererHelper.pixel);
		Vector3fMax paneSideNS = new Vector3fMax(0.0F+RendererHelper.pixel, 0.0F+RendererHelper.pixel, 0.0F, 1.0F-RendererHelper.pixel, 1.0F-RendererHelper.pixel, 1.0F);
		RendererHelper.renderSide(pane, ForgeDirection.UP);
		RendererHelper.renderSide(pane, ForgeDirection.DOWN);
		
		RendererHelper.renderSide(paneSideEW, ForgeDirection.EAST);
		RendererHelper.renderSide(paneSideEW, ForgeDirection.WEST);
		
		RendererHelper.renderSide(paneSideNS, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneSideNS, ForgeDirection.SOUTH);
		
		GL11.glEnd();
	}

}
