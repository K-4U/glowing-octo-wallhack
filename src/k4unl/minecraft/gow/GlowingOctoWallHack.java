package k4unl.minecraft.gow;

import k4unl.minecraft.gow.lib.config.ModInfo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;



@Mod(
	modid = ModInfo.ID,
	name = ModInfo.NAME,
	version = ModInfo.VERSION
)


public class GlowingOctoWallHack {
	@Instance(value=ModInfo.ID)
	public static GlowingOctoWallHack instance;
	
	@SidedProxy(
			clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy",
			serverSide = ModInfo.PROXY_LOCATION + ".CommonProxy"
	)
	public static CommonProxy proxy;
	
}
