package k4unl.minecraft.gow.events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHelper {

	
	public static void init(){
		MinecraftForge.EVENT_BUS.register(new EventHelper());
	}
	
	
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event){
		//World w = event.world;
		
		//GlowingOctoWallHack.ipList = IPs.forWorld(w);
	}
}
