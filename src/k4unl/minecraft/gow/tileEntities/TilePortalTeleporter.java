package k4unl.minecraft.gow.tileEntities;

import k4unl.minecraft.gow.network.PacketPipeline;
import k4unl.minecraft.gow.network.packets.PacketPortalEnabled;
import net.minecraftforge.common.util.ForgeDirection;


public class TilePortalTeleporter extends TileGOWBase {
	private ForgeDirection baseDir;
	private ForgeDirection portalDir;
	
	public void setRotation(ForgeDirection _baseDir, ForgeDirection _portalDir){
		baseDir = _baseDir;
		portalDir = _portalDir;
		if(!getWorldObj().isRemote){
			PacketPipeline.instance.sendToAllAround(new PacketPortalEnabled(xCoord, yCoord, zCoord, _baseDir, _portalDir), getWorldObj());
		}
	}
	
	
	public ForgeDirection getBaseDir(){
		return baseDir;
	}
	
	public ForgeDirection getPortalDir(){
		return portalDir;
	}
}
