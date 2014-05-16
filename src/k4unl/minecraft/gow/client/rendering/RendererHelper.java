package k4unl.minecraft.gow.client.rendering;

import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class RendererHelper {
	public static float pixel = 1.0F/16.0F;
	
	public static void renderSide(Vector3fMax vector, ForgeDirection dir){
		//Top side
		if(dir == ForgeDirection.UP){
			GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
			GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
			GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
			GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
		}
		
		//Bottom side
		if(dir == ForgeDirection.DOWN){
			GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
			GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
			GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
			GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
		}
		
		//West side
		if(dir == ForgeDirection.WEST){
			GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
			GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
			GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
			GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
		}
		
		//East side
		if(dir == ForgeDirection.EAST){
			GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
			GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
			GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
			GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
		}
		
		//North side
		if(dir == ForgeDirection.NORTH){
			GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
			GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
			GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
			GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
		}
		
		//South side
		if(dir == ForgeDirection.SOUTH){
			GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
			GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
			GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
			GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
		}
	}
	
	
	public static void drawColoredCube(Vector3fMax vector){
		//Top side
		GL11.glColor3f(1.0F, 0.0F, 0.0F);
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
		
		//Bottom side
		GL11.glColor3f(1.0F, 1.0F, 0.0F);
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
		
		//West side
		GL11.glColor3f(0.0F, 1.0F, 0.0F);
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
		
		//East side
		GL11.glColor3f(0.0F, 1.0F, 1.0F);
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
		
		//North side
		GL11.glColor3f(0.0F, 0.0F, 1.0F);
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
		
		//South side
		GL11.glColor3f(0.0F, 0.0F, 0.0F);
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
	}
	
	public static void drawWhiteCube(Vector3fMax vector){
		//Top side
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
		
		//Bottom side
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
		
		//West side
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
		
		//East side
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
		
		//North side
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMin());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMin());
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMin());
		
		//South side
		GL11.glVertex3f(vector.getXMin(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMin(), vector.getZMax());
		GL11.glVertex3f(vector.getXMax(), vector.getYMax(), vector.getZMax());
		GL11.glVertex3f(vector.getXMin(), vector.getYMax(), vector.getZMax());
	}
	
	public static void drawCubeWithLines(int size){
		float rF = 0.8F;
		float gF = 0.8F;
		float bF = 0.8F;
		float minPP = RendererHelper.pixel * (size+1);
		float minNP = RendererHelper.pixel * size;
		float maxPP = RendererHelper.pixel * (16-(size+1));
		float maxNP = RendererHelper.pixel * (16-size);
		
		Vector3fMax vNS = new Vector3fMax(minPP, minPP, minNP, maxPP, maxPP, maxNP);
		Vector3fMax vEW = new Vector3fMax(minNP, minPP, minPP, maxNP, maxPP, maxPP);
		Vector3fMax vTB = new Vector3fMax(minPP, minNP, minPP, maxPP, maxNP, maxPP);
		GL11.glColor3f(rF, gF, bF);
		RendererHelper.renderSide(vNS, ForgeDirection.NORTH);
		RendererHelper.renderSide(vNS, ForgeDirection.SOUTH);
		
		RendererHelper.renderSide(vEW, ForgeDirection.EAST);
		RendererHelper.renderSide(vEW, ForgeDirection.WEST);
		
		RendererHelper.renderSide(vTB, ForgeDirection.UP);
		RendererHelper.renderSide(vTB, ForgeDirection.DOWN);
		
		GL11.glColor3f(1.0F, 0.0F, 0.0F);
		Vector3fMax vEWS = new Vector3fMax(minNP, minNP, minNP, maxNP, maxNP, minPP);
		Vector3fMax vEWN = new Vector3fMax(minNP, minNP, maxPP, maxNP, maxNP, maxNP);
		Vector3fMax vNSW = new Vector3fMax(minNP, minNP, minNP, minPP, maxNP, maxNP);
		Vector3fMax vNSE = new Vector3fMax(maxPP, minNP, minNP, maxNP, maxNP, maxNP);
		Vector3fMax vNST = new Vector3fMax(minPP, minNP, minNP, minPP, maxNP, maxNP);
		Vector3fMax vNSB = new Vector3fMax(maxPP, minNP, minNP, maxNP, maxNP, maxNP);
		
		Vector3fMax vTBW = new Vector3fMax(minNP, minNP, minNP, minPP, maxNP, maxNP);
		Vector3fMax vTBE = new Vector3fMax(maxPP, minNP, minNP, maxNP, maxNP, maxNP);
		Vector3fMax vTBN = new Vector3fMax(minPP, minNP, minNP, maxPP, maxNP, minPP);
		Vector3fMax vTBS = new Vector3fMax(minPP, minNP, maxPP, maxPP, maxNP, maxNP);
		
		RendererHelper.renderSide(vEWS, ForgeDirection.EAST);
		RendererHelper.renderSide(vEWS, ForgeDirection.WEST);
		RendererHelper.renderSide(vEWN, ForgeDirection.EAST);
		RendererHelper.renderSide(vEWN, ForgeDirection.WEST);

		RendererHelper.renderSide(vNSW, ForgeDirection.NORTH);
		RendererHelper.renderSide(vNSW, ForgeDirection.SOUTH);
		RendererHelper.renderSide(vNSE, ForgeDirection.NORTH);
		RendererHelper.renderSide(vNSE, ForgeDirection.SOUTH);
		RendererHelper.renderSide(vNST, ForgeDirection.NORTH);
		RendererHelper.renderSide(vNST, ForgeDirection.SOUTH);
		RendererHelper.renderSide(vNSB, ForgeDirection.NORTH);
		RendererHelper.renderSide(vNSB, ForgeDirection.SOUTH);
		
		RendererHelper.renderSide(vTBW, ForgeDirection.UP);
		RendererHelper.renderSide(vTBW, ForgeDirection.DOWN);
		RendererHelper.renderSide(vTBE, ForgeDirection.UP);
		RendererHelper.renderSide(vTBE, ForgeDirection.DOWN);
		RendererHelper.renderSide(vTBN, ForgeDirection.UP);
		RendererHelper.renderSide(vTBN, ForgeDirection.DOWN);
		RendererHelper.renderSide(vTBS, ForgeDirection.UP);
		RendererHelper.renderSide(vTBS, ForgeDirection.DOWN);
	}
}


