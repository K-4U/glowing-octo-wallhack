package k4unl.minecraft.gow.tileEntities;

import k4unl.minecraft.gow.lib.helperClasses.Location;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TilePortalFrame extends TileEntity{

	@Override
	public void updateEntity(){
		super.updateEntity();
	}
	
	@Override
	public void validate(){
		super.validate();
		
	}
	
	public boolean isConnectedTo(ForgeDirection dir){
		Location thatLocation = new Location(xCoord, yCoord, zCoord, dir);
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tCompound){
		super.readFromNBT(tCompound);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tCompound){
		super.writeToNBT(tCompound);
	}

	public void setPortalBase(TilePortalBase tilePortalBase) {
		
	}
}
