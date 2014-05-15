package k4unl.minecraft.gow.client.rendering;

import k4unl.minecraft.gow.lib.config.ModInfo;
import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import k4unl.minecraft.gow.tileEntities.TilePortalFrame;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RendererPortalFrame extends TileEntitySpecialRenderer {
	private static final ResourceLocation resLoc = new ResourceLocation(ModInfo.LID, "textures/model/portalBase.png");
	
	
	@Override
	public void renderTileEntityAt(TileEntity ent, double x, double y,
			double z, float frame) {
		doRender((TilePortalFrame)ent, x, y, z, frame);

	}
	
	private void doRender(TilePortalFrame base, double x, double y, double z, float frame){
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
		Vector3fMax vector = new Vector3fMax(0.40F, 0.40F, 0.40F, 0.6F, 0.6F, 0.6F);
		RendererHelper.drawColoredCube(vector);
		
		GL11.glEnd();
	}

}
