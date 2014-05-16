package k4unl.minecraft.gow.tileEntities;

import k4unl.minecraft.gow.network.PacketPipeline;
import k4unl.minecraft.gow.network.packets.PacketPortalEnabled;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.util.ForgeDirection;


public class TilePortalTeleporter extends TileGOWBase {
	private boolean hasSendPacket = true;
	private ForgeDirection baseDir;
	private ForgeDirection portalDir;
	
	public void setRotation(ForgeDirection _baseDir, ForgeDirection _portalDir){
		baseDir = _baseDir;
		portalDir = _portalDir;
		hasSendPacket = false;
	}
	
	@Override
	public void updateEntity(){
		if(!getWorldObj().isRemote && hasSendPacket == false && baseDir != null){
			hasSendPacket = true;
			PacketPipeline.instance.sendToAllAround(new PacketPortalEnabled(xCoord, yCoord, zCoord, baseDir, portalDir), getWorldObj());
		}
	}
	
	
	public ForgeDirection getBaseDir(){
		return baseDir;
	}
	
	public ForgeDirection getPortalDir(){
		return portalDir;
	}
	
	public void teleport(Entity ent){
		
	}
}
