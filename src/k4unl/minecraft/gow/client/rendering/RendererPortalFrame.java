package k4unl.minecraft.gow.client.rendering;

import k4unl.minecraft.gow.lib.config.ModInfo;
import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import k4unl.minecraft.gow.tileEntities.TilePortalFrame;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class RendererPortalFrame extends TileEntitySpecialRenderer {
	private static final ResourceLocation resLoc = new ResourceLocation(ModInfo.LID, "textures/model/portalBase.png");
	
	
	@Override
	public void renderTileEntityAt(TileEntity ent, double x, double y,
			double z, float frame) {
		doRender((TilePortalFrame)ent, x, y, z, frame);

	}
	
	private void doRender(TilePortalFrame myFrame, double x, double y, double z, float frame){
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		
		//FMLClientHandler.instance().getClient().getTextureManager().bindTexture(resLoc);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		renderFrame(myFrame);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
	private void renderFrame(TilePortalFrame frame){
		float minPP = RendererHelper.pixel * 6;
		float minNP = RendererHelper.pixel * 5;
		float maxPP = RendererHelper.pixel * (16-6);
		float maxNP = RendererHelper.pixel * (16-5);
		GL11.glBegin(GL11.GL_QUADS);
		Vector3fMax vector = new Vector3fMax(minNP, minNP, minNP, maxNP, maxNP, maxNP);
		RendererHelper.drawColoredCube(vector);
		
		boolean isN = false;
		boolean isS = false;
		boolean isU = false;
		boolean isD = false;
		boolean isE = false;
		boolean isW = false;
		//Yuck
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		if(frame.isConnectedTo(ForgeDirection.NORTH)){
			Vector3fMax vTB = new Vector3fMax(minPP, minNP, 0.0F, maxPP, maxNP, minNP);
			Vector3fMax vEW = new Vector3fMax(minNP, minPP, 0.0F, maxNP, maxPP, minNP);
			
			RendererHelper.renderSide(vTB, ForgeDirection.UP);
			RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
			RendererHelper.renderSide(vEW, ForgeDirection.EAST);
			RendererHelper.renderSide(vEW, ForgeDirection.WEST);
			
			GL11.glColor3f(1.0F, 0.0F, 0.0F);
			Vector3fMax vTBW = new Vector3fMax(minNP, minNP, 0.0F, minPP, maxNP, minNP);
			Vector3fMax vTBE = new Vector3fMax(maxPP, minNP, 0.0F, maxNP, maxNP, minNP);
			RendererHelper.renderSide(vTBW, ForgeDirection.UP);
			RendererHelper.renderSide(vTBW, ForgeDirection.DOWN);
			RendererHelper.renderSide(vTBE, ForgeDirection.UP);
			RendererHelper.renderSide(vTBE, ForgeDirection.DOWN);
			isN = true;
		}
		if(frame.isConnectedTo(ForgeDirection.SOUTH)){
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
			Vector3fMax vTB = new Vector3fMax(minPP, minNP, maxNP, maxPP, maxNP, 1.0F);
			Vector3fMax vEW = new Vector3fMax(minNP, minPP, maxNP, maxNP, maxPP, 1.0F);
			RendererHelper.renderSide(vTB, ForgeDirection.UP);
			RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
			RendererHelper.renderSide(vEW, ForgeDirection.EAST);
			RendererHelper.renderSide(vEW, ForgeDirection.WEST);
			
			GL11.glColor3f(1.0F, 0.0F, 0.0F);
			Vector3fMax vTBW = new Vector3fMax(minNP, minNP, maxNP, minPP, maxNP, 1.0F);
			Vector3fMax vTBE = new Vector3fMax(maxPP, minNP, maxNP, maxNP, maxNP, 1.0F);
			RendererHelper.renderSide(vTBW, ForgeDirection.UP);
			RendererHelper.renderSide(vTBW, ForgeDirection.DOWN);
			RendererHelper.renderSide(vTBE, ForgeDirection.UP);
			RendererHelper.renderSide(vTBE, ForgeDirection.DOWN);
			isS = true;
		}
		
		if(frame.isConnectedTo(ForgeDirection.EAST)){
			Vector3fMax v = new Vector3fMax(0.6F, minNP, minNP, 1.0F, maxNP, maxNP);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
			RendererHelper.drawColoredCube(v);
			isE = true;
		}
		if(frame.isConnectedTo(ForgeDirection.WEST)){
			Vector3fMax v = new Vector3fMax(0.0F, minNP, minNP, minNP, maxNP, maxNP);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
			RendererHelper.drawColoredCube(v);
			isW = true;
		}
		
		if(frame.isConnectedTo(ForgeDirection.UP)){
			Vector3fMax v = new Vector3fMax(minNP, maxNP, minNP, maxNP, 1.0F, maxNP);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
			RendererHelper.drawColoredCube(v);	
			isU = true;
		}
		if(frame.isConnectedTo(ForgeDirection.DOWN)){
			Vector3fMax v = new Vector3fMax(minNP, 0.0F, minNP, maxNP, maxNP, maxNP);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
			RendererHelper.drawColoredCube(v);
			isD = true;
		}
		
		boolean isCorner = ((isU || isD) && (isN || isS || isE || isW)) || ((isN || isS) && (isE || isW));
		if(isCorner){
			RendererHelper.drawColoredCube(new Vector3fMax(minNP-(RendererHelper.pixel*2), minNP-(RendererHelper.pixel*2), minNP-(RendererHelper.pixel*2), maxNP+(RendererHelper.pixel*2), maxNP+(RendererHelper.pixel*2), maxNP+(RendererHelper.pixel*2)));
		}
		
		
		GL11.glEnd();
	}

}
