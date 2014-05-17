package k4unl.minecraft.gow.items;

import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemIPCard extends GOWItemBase {

	public ItemIPCard() {
		super(Names.itemIPCard);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par7, float par8, float par9){
		if(!world.isRemote){
			TileEntity ent = world.getTileEntity(x, y, z);
			if(ent instanceof TilePortalBase){
				if(itemStack.getTagCompound() == null){
					itemStack.setTagCompound(new NBTTagCompound());
				}
				NBTTagCompound stackCompound = itemStack.getTagCompound();
				((ItemIPCard)GOWItems.itemIPCard).setDefaultInfo(itemStack, "Linked to: " + ((TilePortalBase)ent).getIPString());
				
				stackCompound.setLong("linked", ((TilePortalBase)ent).getIPLong());
				((ItemIPCard)GOWItems.itemIPCard).setEffect(itemStack, true);
				
				itemStack.setTagCompound(stackCompound);
			}
		}
		
		return false;
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
		if(player.isSneaking()){
			if(itemStack.getTagCompound() == null){
				itemStack.setTagCompound(new NBTTagCompound());
			}
			((ItemIPCard)GOWItems.itemIPCard).setDefaultInfo(itemStack, "");
			
			itemStack.getTagCompound().setLong("linked", 0);
			((ItemIPCard)GOWItems.itemIPCard).setEffect(itemStack, false);
		}
        return itemStack;
    }


}
