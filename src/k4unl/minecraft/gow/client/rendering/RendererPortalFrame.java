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
		GL11.glBegin(GL11.GL_QUADS);
		Vector3fMax vector = new Vector3fMax(0.40F, 0.40F, 0.40F, 0.6F, 0.6F, 0.6F);
		RendererHelper.drawColoredCube(vector);
		
		boolean isN = false;
		boolean isS = false;
		boolean isU = false;
		boolean isD = false;
		boolean isE = false;
		boolean isW = false;
		//Yuck
		if(frame.isConnectedTo(ForgeDirection.NORTH)){
			Vector3fMax v = new Vector3fMax(0.4F, 0.4F, 0.0F, 0.6F, 0.6F, 0.4F);
			RendererHelper.drawColoredCube(v);
			isN = true;
		}
		if(frame.isConnectedTo(ForgeDirection.SOUTH)){
			Vector3fMax v = new Vector3fMax(0.4F, 0.4F, 0.6F, 0.6F, 0.6F, 1.0F);
			RendererHelper.drawColoredCube(v);
			isS = true;
		}
		
		if(frame.isConnectedTo(ForgeDirection.EAST)){
			Vector3fMax v = new Vector3fMax(0.6F, 0.4F, 0.4F, 1.0F, 0.6F, 0.6F);
			RendererHelper.drawColoredCube(v);
			isE = true;
		}
		if(frame.isConnectedTo(ForgeDirection.WEST)){
			Vector3fMax v = new Vector3fMax(0.0F, 0.4F, 0.4F, 0.4F, 0.6F, 0.6F);
			RendererHelper.drawColoredCube(v);
			isW = true;
		}
		
		if(frame.isConnectedTo(ForgeDirection.UP)){
			Vector3fMax v = new Vector3fMax(0.4F, 0.6F, 0.4F, 0.6F, 1.0F, 0.6F);
			RendererHelper.drawColoredCube(v);	
			isU = true;
		}
		if(frame.isConnectedTo(ForgeDirection.DOWN)){
			Vector3fMax v = new Vector3fMax(0.4F, 0.0F, 0.4F, 0.6F, 0.6F, 0.6F);
			RendererHelper.drawColoredCube(v);
			isD = true;
		}
		
		boolean isCorner = ((isU || isD) && (isN || isS || isE || isW)) || ((isN || isS) && (isE || isW));
		if(isCorner){
			RendererHelper.drawColoredCube(new Vector3fMax(0.3F, 0.3F, 0.3F, 0.7F, 0.7F, 0.7F));
		}
		
		
		GL11.glEnd();
	}

}
