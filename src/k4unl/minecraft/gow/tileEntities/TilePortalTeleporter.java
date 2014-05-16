package k4unl.minecraft.gow.tileEntities;

import k4unl.minecraft.gow.network.PacketPipeline;
import k4unl.minecraft.gow.network.packets.PacketPortalEnabled;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.util.ForgeDirection;


public class TilePortalTeleporter extends TileGOWBase {
	private boolean hasSendPacket = true;
	private float transparancy = 0.2F;
	private float prevTransparancy = 0.2F;
	private float directionTransparency = 0.01F;
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
		if(getWorldObj().isRemote){
			prevTransparancy = transparancy;
			transparancy += directionTransparency;
			if(transparancy >= 0.8F){
				directionTransparency = -0.01F;
			}else if(transparancy <= 0.3F){
				directionTransparency = 0.01F;
			}
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

	public float getTransparancy(float frame) {
		return transparancy + ((prevTransparancy - transparancy) * frame);
	}
}
