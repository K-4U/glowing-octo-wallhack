package k4unl.minecraft.gow.containers;

import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerPortalBase extends Container {

	protected TilePortalBase base;
	
	public ContainerPortalBase(InventoryPlayer invPlayer, TilePortalBase _base){
		base = _base;
		
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return false;
	}

}
