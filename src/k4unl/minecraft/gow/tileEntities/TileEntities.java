package k4unl.minecraft.gow.tileEntities;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities {
	
	public static void init(){
		GameRegistry.registerTileEntity(TilePortalBase.class, "tilePortalBase");
		GameRegistry.registerTileEntity(TilePortalFrame.class, "tilePortalFrame");
		GameRegistry.registerTileEntity(TilePortalTeleporter.class, "tilePortalTeleporter");
	}
}
