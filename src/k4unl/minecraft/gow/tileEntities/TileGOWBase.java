package k4unl.minecraft.gow.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileGOWBase extends TileEntity {
	private boolean isRedstonePowered;
	
	
	@Override
	public void updateEntity(){
		super.updateEntity();
		checkRedstonePower();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tCompound){
		super.readFromNBT(tCompound);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tCompound){
		super.writeToNBT(tCompound);
	}
	
	public void checkRedstonePower(){
		boolean isIndirectlyPowered = getWorldObj().isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord);
		if(isIndirectlyPowered && !isRedstonePowered){
			isRedstonePowered = true;
			redstoneChanged();
		}else if(!isIndirectlyPowered && isRedstonePowered){
			isRedstonePowered = false;
			redstoneChanged();
		}
	}
	
	
	protected void redstoneChanged(){
		
	}
}
