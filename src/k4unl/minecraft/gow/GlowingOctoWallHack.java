package k4unl.minecraft.gow;

import k4unl.minecraft.gow.blocks.GOWBlocks;
import k4unl.minecraft.gow.lib.CustomTabs;
import k4unl.minecraft.gow.lib.IPs;
import k4unl.minecraft.gow.lib.Log;
import k4unl.minecraft.gow.lib.config.ModInfo;
import k4unl.minecraft.gow.network.PacketPipeline;
import k4unl.minecraft.gow.proxy.CommonProxy;
import k4unl.minecraft.gow.tileEntities.TileEntities;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;



@Mod(
	modid = ModInfo.ID,
	name = ModInfo.NAME,
	version = ModInfo.VERSION
)


public class GlowingOctoWallHack {
	@Instance(value=ModInfo.ID)
	public static GlowingOctoWallHack instance;
	
	public static IPs ipList = new IPs();
	
	@SidedProxy(
			clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy",
			serverSide = ModInfo.PROXY_LOCATION + ".CommonProxy"
	)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		GOWBlocks.init();
		TileEntities.init();
		CustomTabs.init();
		Log.init();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		
		PacketPipeline.init();
		
		proxy.init();
		proxy.initRenderers();
		proxy.initSounds();
	}
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
