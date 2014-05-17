package k4unl.minecraft.gow.client.gui;

import org.lwjgl.opengl.GL11;

import k4unl.minecraft.gow.blocks.GOWBlocks;
import k4unl.minecraft.gow.lib.config.ModInfo;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiPortalBase extends GuiContainer {

	protected ResourceLocation resLoc = new ResourceLocation(ModInfo.LID, "textures/gui/portalBase.fw.png");
	
	public GuiPortalBase(Container par1Container) {
		super(par1Container);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(resLoc);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		drawHorizontalAlignedString(7,3,xSize-14, GOWBlocks.portalBase.getLocalizedName(), true);
	}

	public void drawHorizontalAlignedString(int xOffset, int yOffset, int w, String text, boolean useShadow){
		int stringWidth = fontRendererObj.getStringWidth(text);
		int newX = xOffset;
		if(stringWidth < w){
			newX = (w / 2) - (stringWidth / 2) + xOffset;
		}
		
		fontRendererObj.drawString(text, newX, yOffset, 0xFFFFFF, useShadow);
	}
	
}
