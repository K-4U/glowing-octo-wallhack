package k4unl.minecraft.gow.tileEntities;

import net.minecraftforge.common.util.ForgeDirection;


public class TilePortalTeleporter extends TileGOWBase {
	private ForgeDirection baseDir;
	private ForgeDirection portalDir;
	
	public void setRotation(ForgeDirection _baseDir, ForgeDirection _portalDir){
		baseDir = _baseDir;
		portalDir = _portalDir;
	}
	
	
	public ForgeDirection getBaseDir(){
		return baseDir;
	}
	
	public ForgeDirection getPortalDir(){
		return portalDir;
	}
}
