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
		float rF = 0.8F;
		float gF = 0.8F;
		float bF = 0.8F;
		float colorFrameR = 1.0F;
		float colorFrameG = 0.0F;
		float colorFrameB = 0.0F;
		if(frame.getIsActive()){
			colorFrameR = 0.0F;
			colorFrameG = 1.0F;
		}
		float minPP = RendererHelper.pixel * 6;
		float minNP = RendererHelper.pixel * 5;
		float maxPP = RendererHelper.pixel * (16-6);
		float maxNP = RendererHelper.pixel * (16-5);
		GL11.glBegin(GL11.GL_QUADS);
		//RendererHelper.drawColoredCube(vector);
		
		boolean isN = false;
		boolean isS = false;
		boolean isU = false;
		boolean isD = false;
		boolean isE = false;
		boolean isW = false;
		//Yuck
		GL11.glColor3f(rF, gF, bF);
		if(frame.isConnectedTo(ForgeDirection.NORTH)){
			Vector3fMax vTB = new Vector3fMax(minPP, minNP, 0.0F, maxPP, maxNP, minNP);
			Vector3fMax vEW = new Vector3fMax(minNP, minPP, 0.0F, maxNP, maxPP, minNP);
			
			RendererHelper.renderSide(vTB, ForgeDirection.UP);
			RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
			RendererHelper.renderSide(vEW, ForgeDirection.EAST);
			RendererHelper.renderSide(vEW, ForgeDirection.WEST);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vTBW = new Vector3fMax(minNP, minNP, 0.0F, minPP, maxNP, minNP);
			Vector3fMax vTBE = new Vector3fMax(maxPP, minNP, 0.0F, maxNP, maxNP, minNP);
			Vector3fMax vEWB = new Vector3fMax(minNP, minNP, 0.0F, maxNP, minPP, minNP);
			Vector3fMax vEWT = new Vector3fMax(minNP, maxPP, 0.0F, maxNP, maxNP, minNP);
			
			RendererHelper.renderSide(vTBW, ForgeDirection.UP);
			RendererHelper.renderSide(vTBW, ForgeDirection.DOWN);
			RendererHelper.renderSide(vTBE, ForgeDirection.UP);
			RendererHelper.renderSide(vTBE, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vEWT, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWT, ForgeDirection.WEST);
			RendererHelper.renderSide(vEWB, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWB, ForgeDirection.WEST);
			isN = true;
		}
		if(frame.isConnectedTo(ForgeDirection.SOUTH)){
			GL11.glColor3f(rF, gF, bF);
			Vector3fMax vTB = new Vector3fMax(minPP, minNP, maxNP, maxPP, maxNP, 1.0F);
			Vector3fMax vEW = new Vector3fMax(minNP, minPP, maxNP, maxNP, maxPP, 1.0F);
			RendererHelper.renderSide(vTB, ForgeDirection.UP);
			RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
			RendererHelper.renderSide(vEW, ForgeDirection.EAST);
			RendererHelper.renderSide(vEW, ForgeDirection.WEST);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vTBW = new Vector3fMax(minNP, minNP, maxNP, minPP, maxNP, 1.0F);
			Vector3fMax vTBE = new Vector3fMax(maxPP, minNP, maxNP, maxNP, maxNP, 1.0F);
			Vector3fMax vEWB = new Vector3fMax(minNP, minNP, maxNP, maxNP, minPP, 1.0F);
			Vector3fMax vEWT = new Vector3fMax(minNP, maxPP, maxNP, maxNP, maxNP, 1.0F);
			
			RendererHelper.renderSide(vTBW, ForgeDirection.UP);
			RendererHelper.renderSide(vTBW, ForgeDirection.DOWN);
			RendererHelper.renderSide(vTBE, ForgeDirection.UP);
			RendererHelper.renderSide(vTBE, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vEWT, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWT, ForgeDirection.WEST);
			RendererHelper.renderSide(vEWB, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWB, ForgeDirection.WEST);
			isS = true;
		}
		
		if(frame.isConnectedTo(ForgeDirection.EAST)){
			Vector3fMax vTB = new Vector3fMax(maxNP, minNP, minPP, 1.0F, maxNP, maxPP);
			Vector3fMax vNS = new Vector3fMax(maxNP, minPP, minNP, 1.0F, maxPP, maxNP);
			GL11.glColor3f(rF, gF, bF);
			RendererHelper.renderSide(vTB, ForgeDirection.UP);
			RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vNS, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNS, ForgeDirection.SOUTH);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vTBN = new Vector3fMax(maxNP, minNP, minNP, 1.0F, maxNP, minPP);
			Vector3fMax vTBS = new Vector3fMax(maxNP, minNP, maxPP, 1.0F, maxNP, maxNP);
			
			Vector3fMax vNST = new Vector3fMax(maxNP, maxPP, minNP, 1.0F, maxNP, maxNP);
			Vector3fMax vNSB = new Vector3fMax(maxNP, minNP, minNP, 1.0F, minPP, maxNP);
			RendererHelper.renderSide(vTBN, ForgeDirection.UP);
			RendererHelper.renderSide(vTBN, ForgeDirection.DOWN);
			RendererHelper.renderSide(vTBS, ForgeDirection.UP);
			RendererHelper.renderSide(vTBS, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vNST, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNST, ForgeDirection.SOUTH);
			RendererHelper.renderSide(vNSB, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSB, ForgeDirection.SOUTH);
			isE = true;
		}
		if(frame.isConnectedTo(ForgeDirection.WEST)){
			Vector3fMax vTB = new Vector3fMax(0.0F, minNP, minPP, minNP, maxNP, maxPP);
			Vector3fMax vNS = new Vector3fMax(0.0F, minPP, minNP, minNP, maxPP, maxNP);
			GL11.glColor3f(rF, gF, bF);
			RendererHelper.renderSide(vTB, ForgeDirection.UP);
			RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vNS, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNS, ForgeDirection.SOUTH);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vTBN = new Vector3fMax(0.0F, minNP, minNP, minNP, maxNP, minPP);
			Vector3fMax vTBS = new Vector3fMax(0.0F, minNP, maxPP, minNP, maxNP, maxNP);
			
			Vector3fMax vNST = new Vector3fMax(0.0F, maxPP, minNP, minNP, maxNP, maxNP);
			Vector3fMax vNSB = new Vector3fMax(0.0F, minNP, minNP, minNP, minPP, maxNP);
			RendererHelper.renderSide(vTBN, ForgeDirection.UP);
			RendererHelper.renderSide(vTBN, ForgeDirection.DOWN);
			RendererHelper.renderSide(vTBS, ForgeDirection.UP);
			RendererHelper.renderSide(vTBS, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vNST, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNST, ForgeDirection.SOUTH);
			RendererHelper.renderSide(vNSB, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSB, ForgeDirection.SOUTH);
			isW = true;
		}
		
		if(frame.isConnectedTo(ForgeDirection.UP)){
			Vector3fMax vNS = new Vector3fMax(minPP, maxNP, minNP, maxPP, 1.0F, maxNP);
			Vector3fMax vEW = new Vector3fMax(minNP, maxNP, minPP, maxNP, 1.0F, maxPP);
			GL11.glColor3f(rF, gF, bF);
			RendererHelper.renderSide(vNS, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNS, ForgeDirection.SOUTH);
			
			RendererHelper.renderSide(vEW, ForgeDirection.EAST);
			RendererHelper.renderSide(vEW, ForgeDirection.WEST);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vEWS = new Vector3fMax(minNP, maxNP, minNP, maxNP, 1.0F, minPP);
			Vector3fMax vEWN = new Vector3fMax(minNP, maxNP, maxPP, maxNP, 1.0F, maxNP);
			Vector3fMax vNSW = new Vector3fMax(minNP, maxNP, minNP, minPP, 1.0F, maxNP);
			Vector3fMax vNSE = new Vector3fMax(maxPP, maxNP, minNP, maxNP, 1.0F, maxNP);
			
			RendererHelper.renderSide(vEWS, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWS, ForgeDirection.WEST);
			RendererHelper.renderSide(vEWN, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWN, ForgeDirection.WEST);

			RendererHelper.renderSide(vNSW, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSW, ForgeDirection.SOUTH);
			RendererHelper.renderSide(vNSE, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSE, ForgeDirection.SOUTH);
			
			isU = true;
		}
		if(frame.isConnectedTo(ForgeDirection.DOWN)){
			Vector3fMax vNS = new Vector3fMax(minPP, 0.0F, minNP, maxPP, minNP, maxNP);
			Vector3fMax vEW = new Vector3fMax(minNP, 0.0F, minPP, maxNP, minNP, maxPP);
			GL11.glColor3f(rF, gF, bF);
			RendererHelper.renderSide(vNS, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNS, ForgeDirection.SOUTH);
			
			RendererHelper.renderSide(vEW, ForgeDirection.EAST);
			RendererHelper.renderSide(vEW, ForgeDirection.WEST);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vEWS = new Vector3fMax(minNP, 0.0F, minNP, maxNP, minNP, minPP);
			Vector3fMax vEWN = new Vector3fMax(minNP, 0.0F, maxPP, maxNP, minNP, maxNP);
			Vector3fMax vNSW = new Vector3fMax(minNP, 0.0F, minNP, minPP, minNP, maxNP);
			Vector3fMax vNSE = new Vector3fMax(maxPP, 0.0F, minNP, maxNP, minNP, maxNP);
			
			RendererHelper.renderSide(vEWS, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWS, ForgeDirection.WEST);
			RendererHelper.renderSide(vEWN, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWN, ForgeDirection.WEST);

			RendererHelper.renderSide(vNSW, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSW, ForgeDirection.SOUTH);
			RendererHelper.renderSide(vNSE, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSE, ForgeDirection.SOUTH);
			isD = true;
		}
		
		boolean isCorner = ((isU || isD) && (isN || isS || isE || isW)) || ((isN || isS) && (isE || isW));
		if(((!isU && !isD && !isN && !isS && !isW && !isE && !isW) || (isU != isD || isN != isS || isE != isW)) && !isCorner){
			RendererHelper.drawCubeWithLines(5);
		}
		if(isCorner){
			RendererHelper.drawCubeWithLines(4);
		}
		
		if(isU && isD){
			Vector3fMax vNS = new Vector3fMax(minPP, minNP, minNP, maxPP, maxNP, maxNP);
			Vector3fMax vEW = new Vector3fMax(minNP, minNP, minPP, maxNP, maxNP, maxPP);
			GL11.glColor3f(rF, gF, bF);
			RendererHelper.renderSide(vNS, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNS, ForgeDirection.SOUTH);
			
			RendererHelper.renderSide(vEW, ForgeDirection.EAST);
			RendererHelper.renderSide(vEW, ForgeDirection.WEST);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vEWS = new Vector3fMax(minNP, minNP, minNP, maxNP, maxNP, minPP);
			Vector3fMax vEWN = new Vector3fMax(minNP, minNP, maxPP, maxNP, maxNP, maxNP);
			Vector3fMax vNSW = new Vector3fMax(minNP, minNP, minNP, minPP, maxNP, maxNP);
			Vector3fMax vNSE = new Vector3fMax(maxPP, minNP, minNP, maxNP, maxNP, maxNP);
			
			RendererHelper.renderSide(vEWS, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWS, ForgeDirection.WEST);
			RendererHelper.renderSide(vEWN, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWN, ForgeDirection.WEST);

			RendererHelper.renderSide(vNSW, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSW, ForgeDirection.SOUTH);
			RendererHelper.renderSide(vNSE, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSE, ForgeDirection.SOUTH);
		}else if(isN && isS){
			GL11.glColor3f(rF, gF, bF);
			Vector3fMax vTB = new Vector3fMax(minPP, minNP, minNP, maxPP, maxNP, maxNP);
			Vector3fMax vEW = new Vector3fMax(minNP, minPP, minNP, maxNP, maxPP, maxNP);
			
			RendererHelper.renderSide(vTB, ForgeDirection.UP);
			RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
			RendererHelper.renderSide(vEW, ForgeDirection.EAST);
			RendererHelper.renderSide(vEW, ForgeDirection.WEST);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vTBW = new Vector3fMax(minNP, minNP, minNP, minPP, maxNP, maxNP);
			Vector3fMax vTBE = new Vector3fMax(maxPP, minNP, minNP, maxNP, maxNP, maxNP);
			Vector3fMax vEWB = new Vector3fMax(minNP, minNP, minNP, maxNP, minPP, maxNP);
			Vector3fMax vEWT = new Vector3fMax(minNP, maxPP, minNP, maxNP, maxNP, maxNP);
			
			RendererHelper.renderSide(vTBW, ForgeDirection.UP);
			RendererHelper.renderSide(vTBW, ForgeDirection.DOWN);
			RendererHelper.renderSide(vTBE, ForgeDirection.UP);
			RendererHelper.renderSide(vTBE, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vEWT, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWT, ForgeDirection.WEST);
			RendererHelper.renderSide(vEWB, ForgeDirection.EAST);
			RendererHelper.renderSide(vEWB, ForgeDirection.WEST);
		}else if(isE && isW){
			Vector3fMax vTB = new Vector3fMax(minNP, minNP, minPP, maxNP, maxNP, maxPP);
			Vector3fMax vNS = new Vector3fMax(minNP, minPP, minNP, maxNP, maxPP, maxNP);
			GL11.glColor3f(rF, gF, bF);
			RendererHelper.renderSide(vTB, ForgeDirection.UP);
			RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vNS, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNS, ForgeDirection.SOUTH);
			
			GL11.glColor3f(colorFrameR, colorFrameG, colorFrameB);
			Vector3fMax vTBN = new Vector3fMax(minNP, minNP, minNP, maxNP, maxNP, minPP);
			Vector3fMax vTBS = new Vector3fMax(minNP, minNP, maxPP, maxNP, maxNP, maxNP);
			
			Vector3fMax vNST = new Vector3fMax(minNP, maxPP, minNP, maxNP, maxNP, maxNP);
			Vector3fMax vNSB = new Vector3fMax(minNP, minNP, minNP, maxNP, minPP, maxNP);
			RendererHelper.renderSide(vTBN, ForgeDirection.UP);
			RendererHelper.renderSide(vTBN, ForgeDirection.DOWN);
			RendererHelper.renderSide(vTBS, ForgeDirection.UP);
			RendererHelper.renderSide(vTBS, ForgeDirection.DOWN);
			
			RendererHelper.renderSide(vNST, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNST, ForgeDirection.SOUTH);
			RendererHelper.renderSide(vNSB, ForgeDirection.NORTH);
			RendererHelper.renderSide(vNSB, ForgeDirection.SOUTH);
		}
		
		
		GL11.glEnd();
	}

}
