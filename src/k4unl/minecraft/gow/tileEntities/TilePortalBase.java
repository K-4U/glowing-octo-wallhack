package k4unl.minecraft.gow.tileEntities;

import k4unl.minecraft.gow.blocks.BlockPortalFrame;
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
	
	private boolean checkPortalComplete(){
		int i = 0;
		ForgeDirection dir = ForgeDirection.NORTH;
		Location blockLocation = new Location(xCoord, yCoord, zCoord);
		int portalLength = 0;
		while(i != 2){
			for(int z = 0; z <= Config.getInt("maxPortalWidth"); z++){
				Location nLocation = new Location(xCoord, yCoord, zCoord, dir, z);
				if(nLocation.getBlock(getWorldObj()) instanceof BlockPortalFrame){
					
				}
			}
			
			i++;
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
