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
	
	public void doRender(TilePortalBase base, double x, double y, double z, float frame){
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		
		//FMLClientHandler.instance().getClient().getTextureManager().bindTexture(resLoc);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		renderBase(base);
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
	private void renderBase(TilePortalBase base){
		float colorFrameR = 1.0F;
		float colorFrameG = 0.0F;
		float colorFrameB = 0.0F;
		float colorFaceR = 255.0F;
		float colorFaceG = 255.0F;
		float colorFaceB = 255.0F;
		int color = base.getDye();
		
		switch(color){
		case 0:
			colorFaceR = 221.0F;
			colorFaceG = 221.0F;
			colorFaceB = 221.0F;
			break;
		case 1:
			colorFaceR = 219.0F;
			colorFaceG = 125.0F;
			colorFaceB = 62.0F;
			break;
		case 2:
			colorFaceR = 179.0F;
			colorFaceG = 80.0F;
			colorFaceB = 188.0F;
			break;
		case 3:
			colorFaceR = 107.0F;
			colorFaceG = 138.0F;
			colorFaceB = 1201.0F;
			break;
		case 4:
			colorFaceR = 177.0F;
			colorFaceG = 166.0F;
			colorFaceB = 39.0F;
			break;
		case 5:
			colorFaceR = 65.0F;
			colorFaceG = 174.0F;
			colorFaceB = 56.0F;
			break;
		case 6:
			colorFaceR = 208.0F;
			colorFaceG = 132.0F;
			colorFaceB = 153.0F;
			break;
		case 7:
			colorFaceR = 64.0F;
			colorFaceG = 64.0F;
			colorFaceB = 64.0F;
			break;
		case 8:
			colorFaceR = 154.0F;
			colorFaceG = 161.0F;
			colorFaceB = 161.0F;
			break;
		case 9:
			colorFaceR = 46.0F;
			colorFaceG = 110.0F;
			colorFaceB = 137.0F;
			break;
		case 10:
			colorFaceR = 126.0F;
			colorFaceG = 61.0F;
			colorFaceB = 181.0F;
			break;
		case 11:
			colorFaceR = 46.0F;
			colorFaceG = 56.0F;
			colorFaceB = 141.0F;
			break;
		case 12:
			colorFaceR = 79.0F;
			colorFaceG = 50.0F;
			colorFaceB = 31.0F;
			break;
		case 13:
			colorFaceR = 53.0F;
			colorFaceG = 70.0F;
			colorFaceB = 27.0F;
			break;
		case 14:
			colorFaceR = 150.0F;
			colorFaceG = 52.0F;
			colorFaceB = 48.0F;
			break;
		case 15:
			colorFaceR = 25.0F;
			colorFaceG = 22.0F;
			colorFaceB = 22.0F;
			default:
				break;
		}
		
		colorFaceR = colorFaceR / 255.0F;
		colorFaceG = colorFaceG / 255.0F;
		colorFaceB = colorFaceB / 255.0F;
		
		if(base.getIsActive()){
			colorFrameR = 0.0F;
			colorFrameG = 1.0F;
		}
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(colorFaceR, colorFaceG, colorFaceB);
		Vector3fMax pane = new Vector3fMax(0.0F+RendererHelper.pixel, 0.0F, 0.0F+RendererHelper.pixel, 1.0F-RendererHelper.pixel, 1.0F, 1.0F-RendererHelper.pixel);
		Vector3fMax paneSideEW = new Vector3fMax(0.0F, 0.0F+RendererHelper.pixel, 0.0F+RendererHelper.pixel, 1.0F, 1.0F-RendererHelper.pixel, 1.0F-RendererHelper.pixel);
		Vector3fMax paneSideNS = new Vector3fMax(0.0F+RendererHelper.pixel, 0.0F+RendererHelper.pixel, 0.0F, 1.0F-RendererHelper.pixel, 1.0F-RendererHelper.pixel, 1.0F);
		RendererHelper.renderSide(pane, ForgeDirection.UP);
		RendererHelper.renderSide(pane, ForgeDirection.DOWN);
		
		RendererHelper.renderSide(paneSideEW, ForgeDirection.EAST);
		RendererHelper.renderSide(paneSideEW, ForgeDirection.WEST);
		
		RendererHelper.renderSide(paneSideNS, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneSideNS, ForgeDirection.SOUTH);
		
		GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
		Vector3fMax paneTB_W = new Vector3fMax(0.0F, 0.0F, 0.0F, RendererHelper.pixel, 1.0F, 1.0F);
		Vector3fMax paneTB_E = new Vector3fMax(1.0F-RendererHelper.pixel, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		Vector3fMax paneTB_N = new Vector3fMax(RendererHelper.pixel, 0.0F, 0.0F, 1.0F-RendererHelper.pixel, 1.0F, RendererHelper.pixel);
		Vector3fMax paneTB_S = new Vector3fMax(RendererHelper.pixel, 0.0F, 1.0F-RendererHelper.pixel, 1.0F-RendererHelper.pixel, 1.0F, 1.0F);
		
		RendererHelper.renderSide(paneTB_W, ForgeDirection.UP);
		RendererHelper.renderSide(paneTB_W, ForgeDirection.DOWN);
		RendererHelper.renderSide(paneTB_E, ForgeDirection.UP);
		RendererHelper.renderSide(paneTB_E, ForgeDirection.DOWN);
		RendererHelper.renderSide(paneTB_N, ForgeDirection.UP);
		RendererHelper.renderSide(paneTB_N, ForgeDirection.DOWN);
		RendererHelper.renderSide(paneTB_S, ForgeDirection.UP);
		RendererHelper.renderSide(paneTB_S, ForgeDirection.DOWN);
		
		Vector3fMax paneNS_W = new Vector3fMax(0.0F, 0.0F, 0.0F, RendererHelper.pixel, 1.0F, 1.0F);
		Vector3fMax paneNS_E = new Vector3fMax(1.0F-RendererHelper.pixel, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		Vector3fMax paneNS_U = new Vector3fMax(RendererHelper.pixel, 1.0F-RendererHelper.pixel, 0.0F, 1.0F-RendererHelper.pixel, 1.0F, 1.0F);
		Vector3fMax paneNS_D = new Vector3fMax(RendererHelper.pixel, 0.0F, 0.0F, 1.0F-RendererHelper.pixel, RendererHelper.pixel, 1.0F);
		
		RendererHelper.renderSide(paneNS_W, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneNS_W, ForgeDirection.SOUTH);
		RendererHelper.renderSide(paneNS_E, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneNS_E, ForgeDirection.SOUTH);
		RendererHelper.renderSide(paneNS_U, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneNS_U, ForgeDirection.SOUTH);
		RendererHelper.renderSide(paneNS_D, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneNS_D, ForgeDirection.SOUTH);
		
		Vector3fMax paneEW_N = new Vector3fMax(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, RendererHelper.pixel);
		Vector3fMax paneEW_S = new Vector3fMax(0.0F, 0.0F, 1.0F-RendererHelper.pixel, 1.0F, 1.0F, 1.0F);
		Vector3fMax paneEW_T = new Vector3fMax(0.0F, 1.0F-RendererHelper.pixel, 0.0F, 1.0F, 1.0F, 1.0F);
		Vector3fMax paneEW_D = new Vector3fMax(0.0F, 0.0F, 0.0F, 1.0F, RendererHelper.pixel, 1.0F);
		
		RendererHelper.renderSide(paneEW_N, ForgeDirection.EAST);
		RendererHelper.renderSide(paneEW_N, ForgeDirection.WEST);
		RendererHelper.renderSide(paneEW_S, ForgeDirection.EAST);
		RendererHelper.renderSide(paneEW_S, ForgeDirection.WEST);
		RendererHelper.renderSide(paneEW_T, ForgeDirection.EAST);
		RendererHelper.renderSide(paneEW_T, ForgeDirection.WEST);
		RendererHelper.renderSide(paneEW_D, ForgeDirection.EAST);
		RendererHelper.renderSide(paneEW_D, ForgeDirection.WEST);
		
		GL11.glEnd();
	}

}
