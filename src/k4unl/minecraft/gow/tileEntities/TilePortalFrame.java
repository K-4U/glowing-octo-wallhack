package k4unl.minecraft.gow.tileEntities;

import k4unl.minecraft.gow.lib.helperClasses.Location;
import k4unl.minecraft.gow.network.PacketPipeline;
import k4unl.minecraft.gow.network.packets.PacketPortalStateChanged;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TilePortalFrame extends TileGOWBase{
	private boolean hasSendPacket = true;
	private boolean isActive;
	private TilePortalBase parent;
	
	@Override
	public void updateEntity(){
		super.updateEntity();
		if(!getWorldObj().isRemote && hasSendPacket == false){
			hasSendPacket = true;
			PacketPipeline.instance.sendToAllAround(new PacketPortalStateChanged(xCoord, yCoord, zCoord, isActive), getWorldObj());
		}
	}
	
	@Override
	public void validate(){
		super.validate();
		
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isConnectedTo(ForgeDirection dir){
		Location thatLocation = new Location(xCoord, yCoord, zCoord, dir);
		if(thatLocation.getTE(getWorldObj()) instanceof TilePortalFrame ||  thatLocation.getTE(getWorldObj()) instanceof TilePortalBase){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tCompound){
		super.readFromNBT(tCompound);
		isActive = tCompound.getBoolean("isActive");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tCompound){
		super.writeToNBT(tCompound);
		tCompound.setBoolean("isActive", isActive);
	}

	public void setPortalBase(TilePortalBase tilePortalBase) {
		parent = tilePortalBase;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean b) {
		isActive = b;
		hasSendPacket = false;
		markDirty();
	}

	public Location getBlockLocation() {
		return new Location(xCoord, yCoord, zCoord);
	}
}
