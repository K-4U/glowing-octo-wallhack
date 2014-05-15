package k4unl.minecraft.gow.tileEntities;

import k4unl.minecraft.gow.lib.helperClasses.Location;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TilePortalFrame extends TileGOWBase{

	@Override
	public void updateEntity(){
		super.updateEntity();
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
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tCompound){
		super.writeToNBT(tCompound);
	}

	public void setPortalBase(TilePortalBase tilePortalBase) {
		
	}
}
