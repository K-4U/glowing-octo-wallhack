package k4unl.minecraft.gow.blocks;

import k4unl.minecraft.gow.lib.config.Names;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class GOWBlocks {
	public static Block portalBase;
	public static Block portalFrame;
	public static Block portalTeleporter;
	
	
	public static void init(){
		portalBase = new BlockPortalBase();
		portalFrame = new BlockPortalFrame();
		portalTeleporter = new BlockPortalTeleporter();
		registerBlocks();
	}
	
	public static void registerBlocks(){
		GameRegistry.registerBlock(portalBase, Names.portalBase);
		GameRegistry.registerBlock(portalFrame, Names.portalFrame);
		GameRegistry.registerBlock(portalTeleporter, Names.portalTeleporter);
	}
}
