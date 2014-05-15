package k4unl.minecraft.gow.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilePortalBase extends TileEntity {
	private boolean portalFormed;
	
	@Override
	public void updateEntity(){
		super.updateEntity();
		//Every 10 ticks, check for a complete portal.
		if(getWorldObj().getTotalWorldTime() % 10 == 0){
			if(checkPortalComplete()){
				if(portalFormed){
					validatePortal();
				}else{
					invalidatePortal();
				}
			}
		}
	}
	
	public boolean checkPortalComplete(){
		
		return false;
	}
	
	public void validatePortal(){
		
	}
	
	public void invalidatePortal(){
		
	}
	
	
	@Override
	public void validate(){
		super.validate();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tCompound){
		super.readFromNBT(tCompound);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tCompound){
		super.writeToNBT(tCompound);
	}
}
