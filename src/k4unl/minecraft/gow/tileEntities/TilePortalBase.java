package k4unl.minecraft.gow.tileEntities;

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
		if(getWorldObj().getTotalWorldTime() % 20 == 0 && !getWorldObj().isRemote){
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
		ForgeDirection baseDir = ForgeDirection.NORTH;
		//Location blockLocation = new Location(xCoord, yCoord, zCoord);
		int portalWidth = 0;
		int half = 0;
		while(i != 2){
			for(int z = 1; z <= Config.getInt("maxPortalWidth"); z++){
				Location nLocation = new Location(xCoord, yCoord, zCoord, baseDir, z);
				Location oLocation = new Location(xCoord, yCoord, zCoord, baseDir.getOpposite(), z);
				if(nLocation.getBlock(getWorldObj()) == GOWBlocks.portalFrame){
					portalWidth++;
					half++;
				}else{
					break;
				}
				if(oLocation.getBlock(getWorldObj()) == GOWBlocks.portalFrame){
					portalWidth++;
				}else{
					break;
				}
			}
			if(portalWidth > 0 && portalWidth % 2 == 0){
				//Valid portal found.
				//Break out of loop
				break;
			}else{
				portalWidth = 0;
			}
			
			baseDir = ForgeDirection.EAST;
			i++;
		}
		if(portalWidth == 0 || portalWidth % 2 != 0){
			return false;
		}
		
		
		//Now, that is the bottom taken care of. Let's see about the rest!
		i = 0;
		ForgeDirection portalDir = baseDir.getRotation(ForgeDirection.UP);
		Location firstLocation = new Location(xCoord, yCoord, zCoord, baseDir, half);
		Location secondLocation = new Location(xCoord, yCoord, zCoord, baseDir.getOpposite(), half);
		int portalHeight = 0;
		while(i != 3){
			Log.info("Checking for portal with basedir at " + baseDir + " and top at " + portalDir);
			for(int y = 1; y <= Config.getInt("maxPortalHeight"); y++){
				Location nLocation = new Location(firstLocation, portalDir, y);
				Location oLocation = new Location(secondLocation, portalDir, y);
				if(nLocation.getBlock(getWorldObj()) == GOWBlocks.portalFrame){
					portalHeight++;
				}else{
					break;
				}
				if(oLocation.getBlock(getWorldObj()) != GOWBlocks.portalFrame){
					break;
				}
			}
			
			if(portalHeight > 1){
				break;
			}
			portalDir = portalDir.getRotation(baseDir);
			portalHeight = 0;
			i++;
		}
		
		if(portalHeight == 0){
			return false;
		}
		
		//Check other side (aka top):
		Location topCenter = new Location(xCoord, yCoord, zCoord, portalDir, portalHeight);
		if(topCenter.getBlock(getWorldObj()) != GOWBlocks.portalFrame){
			return false;
		}
		for(int x = 1; x <= half; x++){
			Location nLocation = new Location(xCoord, yCoord, zCoord, baseDir, x);
			Location oLocation = new Location(xCoord, yCoord, zCoord, baseDir.getOpposite(), x);
			if(nLocation.getBlock(getWorldObj()) != GOWBlocks.portalFrame){
				return false;
			}
			if(oLocation.getBlock(getWorldObj()) != GOWBlocks.portalFrame){
				return false;
			}
		}
		
		Log.info("Found a portal. It's " + portalWidth + " wide and " + portalHeight + " high in " + baseDir + " with the portal in the " + portalDir);
		
		return true;
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

