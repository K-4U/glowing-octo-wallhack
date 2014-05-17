package k4unl.minecraft.gow.items;

import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemIPHolder extends GOWItemBase {

	public ItemIPHolder() {
		super(Names.itemIPCard);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par7, float par8, float par9){
		if(!world.isRemote){
			TileEntity ent = world.getTileEntity(x, y, z);
			if(ent instanceof TilePortalBase){
				NBTTagCompound itemCompound = itemStack.getTagCompound();
				
			}
		}
		
		return false;
	}

}
