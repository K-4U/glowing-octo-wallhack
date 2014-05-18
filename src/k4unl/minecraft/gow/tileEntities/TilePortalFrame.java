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
	private Location parentLocation;
	//private TilePortalBase parent;
	private int colorIndex = 0;
	
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
		if(thatLocation == null || getWorldObj() == null){
			return false;
		}
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
		parentLocation = new Location(tCompound.getIntArray("parent"));
		colorIndex = tCompound.getInteger("dye");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tCompound){
		super.writeToNBT(tCompound);
		tCompound.setBoolean("isActive", isActive);
		if(parentLocation != null){
			tCompound.setIntArray("parent", parentLocation.getIntArray());
		}
		tCompound.setInteger("dye",colorIndex);
	}

	public void setPortalBase(TilePortalBase tilePortalBase) {
		parentLocation = tilePortalBase.getBlockLocation();
		markDirty();
		getWorldObj().markBlockForUpdate(xCoord, yCoord, zCoord);
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
	
	public TilePortalBase getBase() {
		return (TilePortalBase) parentLocation.getTE(getWorldObj());
	}
	public void dye(int i) {
		colorIndex = i;
		markDirty();
		getWorldObj().markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	public int getDye(){
		return colorIndex;
	}

}
