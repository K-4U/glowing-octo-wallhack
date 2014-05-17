package k4unl.minecraft.gow.client.gui;

import k4unl.minecraft.gow.blocks.GOWBlocks;
import k4unl.minecraft.gow.containers.ContainerPortalBase;
import k4unl.minecraft.gow.lib.config.ModInfo;
import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiPortalBase extends GuiContainer {

	protected static final ResourceLocation resLoc = new ResourceLocation(ModInfo.LID, "textures/gui/portalBase.png");
	protected TilePortalBase base;
	
	public GuiPortalBase(InventoryPlayer invPlayer, TilePortalBase _base) {
		super(new ContainerPortalBase(invPlayer, _base));

		base = _base;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(resLoc);
		
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		//Draw IP address
		
		drawHorizontalAlignedString(82 + x, 44 + y, 76, base.getIPString(), false);
		drawHorizontalAlignedString(82 + x, 24 + y, 76, "IP-address:", false);
		//fontRendererObj.drawString(base.getIPString(), 82 + x, 28+y, 0xFFFFFF, true);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		drawHorizontalAlignedString(7,5,xSize-14, GOWBlocks.portalBase.getLocalizedName(), true);
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
