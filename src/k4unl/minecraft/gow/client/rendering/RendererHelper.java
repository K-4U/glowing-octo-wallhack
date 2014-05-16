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
	
	private void renderSquareWithBars(float min, float max){
		
		GL11.glBegin(GL11.GL_QUADS);
		Vector3fMax pane = new Vector3fMax(min+RendererHelper.pixel, min, min+RendererHelper.pixel, max-RendererHelper.pixel, max, max-RendererHelper.pixel);
		Vector3fMax paneSideEW = new Vector3fMax(min, 0.0F+RendererHelper.pixel, min+RendererHelper.pixel, 1.0F, 1.0F-RendererHelper.pixel, 1.0F-RendererHelper.pixel);
		Vector3fMax paneSideNS = new Vector3fMax(min+RendererHelper.pixel, min+RendererHelper.pixel, min, 1.0F-RendererHelper.pixel, 1.0F-RendererHelper.pixel, 1.0F);
		RendererHelper.renderSide(pane, ForgeDirection.UP);
		RendererHelper.renderSide(pane, ForgeDirection.DOWN);
		
		RendererHelper.renderSide(paneSideEW, ForgeDirection.EAST);
		RendererHelper.renderSide(paneSideEW, ForgeDirection.WEST);
		
		RendererHelper.renderSide(paneSideNS, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneSideNS, ForgeDirection.SOUTH);
		
		GL11.glColor3f(1.0F, 0.0F, 0.0F);
		Vector3fMax paneTB_W = new Vector3fMax(min, min, min, RendererHelper.pixel, 1.0F, 1.0F);
		Vector3fMax paneTB_E = new Vector3fMax(1.0F-RendererHelper.pixel, min, min, 1.0F, 1.0F, 1.0F);
		Vector3fMax paneTB_N = new Vector3fMax(RendererHelper.pixel, min, min, 1.0F-RendererHelper.pixel, 1.0F, RendererHelper.pixel);
		Vector3fMax paneTB_S = new Vector3fMax(RendererHelper.pixel, min, 1.0F-RendererHelper.pixel, 1.0F-RendererHelper.pixel, 1.0F, 1.0F);
		
		RendererHelper.renderSide(paneTB_W, ForgeDirection.UP);
		RendererHelper.renderSide(paneTB_W, ForgeDirection.DOWN);
		RendererHelper.renderSide(paneTB_E, ForgeDirection.UP);
		RendererHelper.renderSide(paneTB_E, ForgeDirection.DOWN);
		RendererHelper.renderSide(paneTB_N, ForgeDirection.UP);
		RendererHelper.renderSide(paneTB_N, ForgeDirection.DOWN);
		RendererHelper.renderSide(paneTB_S, ForgeDirection.UP);
		RendererHelper.renderSide(paneTB_S, ForgeDirection.DOWN);
		
		Vector3fMax paneNS_W = new Vector3fMax(min, min, min, RendererHelper.pixel, 1.0F, 1.0F);
		Vector3fMax paneNS_E = new Vector3fMax(1.0F-RendererHelper.pixel, min, min, 1.0F, 1.0F, 1.0F);
		Vector3fMax paneNS_U = new Vector3fMax(RendererHelper.pixel, 1.0F-RendererHelper.pixel, min, 1.0F-RendererHelper.pixel, 1.0F, 1.0F);
		Vector3fMax paneNS_D = new Vector3fMax(RendererHelper.pixel, min, min, 1.0F-RendererHelper.pixel, RendererHelper.pixel, 1.0F);
		
		RendererHelper.renderSide(paneNS_W, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneNS_W, ForgeDirection.SOUTH);
		RendererHelper.renderSide(paneNS_E, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneNS_E, ForgeDirection.SOUTH);
		RendererHelper.renderSide(paneNS_U, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneNS_U, ForgeDirection.SOUTH);
		RendererHelper.renderSide(paneNS_D, ForgeDirection.NORTH);
		RendererHelper.renderSide(paneNS_D, ForgeDirection.SOUTH);
		
		Vector3fMax paneEW_N = new Vector3fMax(min, min, min, 1.0F, 1.0F, RendererHelper.pixel);
		Vector3fMax paneEW_S = new Vector3fMax(min, min, 1.0F-RendererHelper.pixel, 1.0F, 1.0F, 1.0F);
		Vector3fMax paneEW_T = new Vector3fMax(min, 1.0F-RendererHelper.pixel, min, 1.0F, 1.0F, 1.0F);
		Vector3fMax paneEW_D = new Vector3fMax(min, min, min, 1.0F, RendererHelper.pixel, 1.0F);
		
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


