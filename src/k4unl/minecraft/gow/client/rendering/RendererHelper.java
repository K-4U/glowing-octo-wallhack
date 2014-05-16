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
}


