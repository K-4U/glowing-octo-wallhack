package k4unl.minecraft.gow.client.rendering;

import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import k4unl.minecraft.gow.tileEntities.TilePortalFrame;
import cpw.mods.fml.client.registry.ClientRegistry;

public class Renderers {

	public static void init(){
		ClientRegistry.bindTileEntitySpecialRenderer(TilePortalBase.class, new RendererPortalBase());
		ClientRegistry.bindTileEntitySpecialRenderer(TilePortalFrame.class, new RendererPortalFrame());
	}
}
