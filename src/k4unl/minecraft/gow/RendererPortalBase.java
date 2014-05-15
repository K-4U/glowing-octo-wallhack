package k4unl.minecraft.gow;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RendererPortalBase extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity ent, double x, double y,
			double z, float frame) {

	}
	
	private void renderBase(){
		GL11.glBegin(GL11.GL_QUADS);
		
		
		GL11.glEnd();
	}

}
