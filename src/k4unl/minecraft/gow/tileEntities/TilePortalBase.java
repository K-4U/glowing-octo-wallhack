package k4unl.minecraft.gow.tileEntities;

import k4unl.minecraft.gow.blocks.BlockPortalFrame;
import k4unl.minecraft.gow.blocks.GOWBlocks;
import k4unl.minecraft.gow.lib.Log;
import k4unl.minecraft.gow.lib.config.Config;
import k4unl.minecraft.gow.lib.helperClasses.Location;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TilePortalBase extends TileEntity {
	private boolean portalFormed;
	
	@Override
	public void updateEntity(){
		super.updateEntity();
		//Every 10 ticks, check for a complete portal.
		if(getWorldObj().getTotalWorldTime() % 20 == 0){
			if(checkPortalComplete()){
				if(portalFormed){
					validatePortal();
				}else{
					invalidatePortal();
				}
			}
		}
	}
	
	private boolean checkPortalComplete(){
		int i = 0;
		ForgeDirection dir = ForgeDirection.NORTH;
		//Location blockLocation = new Location(xCoord, yCoord, zCoord);
		int portalLength = 0;
		int portalLength2 = 0;
		while(i != 2){
			for(int z = 0; z <= Config.getInt("maxPortalWidth"); z++){
				Location nLocation = new Location(xCoord, yCoord, zCoord, dir, z);
				Location oLocation = new Location(xCoord, yCoord, zCoord, dir.getOpposite(), z);
				if(nLocation.getBlock(getWorldObj()) == GOWBlocks.portalFrame){
					portalLength++;
				}else{
					break;
				}
				if(oLocation.getBlock(getWorldObj()) == GOWBlocks.portalFrame){
					portalLength2++;
				}else{
					break;
				}
			}
			if(portalLength > 0 && portalLength == portalLength2){
				//Valid portal found.
				//Break out of loop
				break;
			}else{
				portalLength = 0;
				portalLength2 = 0;
			}
			
			dir = ForgeDirection.EAST;
			i++;
		}
		if(portalLength > 0 && portalLength == portalLength2){
			portalLength += portalLength2;
			Log.info("Portal found with length " + portalLength);
			return true;
		}
		return false;
	}
	
	private void validatePortal(){
		
	}
	
	private void invalidatePortal(){
		
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
