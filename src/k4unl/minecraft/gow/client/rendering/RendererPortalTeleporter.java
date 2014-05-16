package k4unl.minecraft.gow.client.rendering;

import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import k4unl.minecraft.gow.tileEntities.TilePortalTeleporter;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class RendererPortalTeleporter extends TileEntitySpecialRenderer {
	
	@Override
	public void renderTileEntityAt(TileEntity ent, double x, double y,
			double z, float frame) {
		doRender((TilePortalTeleporter)ent, x, y, z, frame);

	}
	
	private void doRender(TilePortalTeleporter myTeleporter, double x, double y, double z, float frame){
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		
		//FMLClientHandler.instance().getClient().getTextureManager().bindTexture(resLoc);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		renderTeleporter(myTeleporter);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}
	
	private void renderTeleporter(TilePortalTeleporter teleporter){
		GL11.glBegin(GL11.GL_QUADS);
		Vector3fMax vector = new Vector3fMax(0.40F, 0.40F, 0.40F, 0.6F, 0.6F, 0.6F);

		if(teleporter != null){
			if(teleporter.getBaseDir() != null){
				if(teleporter.getBaseDir().equals(ForgeDirection.NORTH) | teleporter.getPortalDir().equals(ForgeDirection.NORTH)){
					vector.setZMin(0.0F);
					vector.setZMax(1.0F);
				}
				if(teleporter.getPortalDir().equals(ForgeDirection.UP)){
					vector.setYMin(0.0F);
					vector.setYMax(1.0F);
				}
				if(teleporter.getBaseDir().equals(ForgeDirection.EAST) || teleporter.getPortalDir().equals(ForgeDirection.EAST)){
					vector.setXMin(0.0F);
					vector.setXMax(1.0F);
				}
			}
		}
		RendererHelper.drawColoredCube(vector);
		
		GL11.glEnd();
	}

}
