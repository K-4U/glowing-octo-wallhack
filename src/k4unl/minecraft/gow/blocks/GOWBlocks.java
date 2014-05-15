package k4unl.minecraft.gow.blocks;

import k4unl.minecraft.gow.lib.config.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class GOWBlocks {
	public static Block portalBase;
	public static Block portalFrame;
	
	
	public static void init(){
		
		portalBase = new BlockPortalBase();
		portalFrame = new BlockPortalFrame();
		registerBlocks();
	}
	
	public static void registerBlocks(){
		GameRegistry.registerBlock(portalBase, Names.portalBase);
		GameRegistry.registerBlock(portalFrame, Names.portalFrame);
	}
}
