package k4unl.minecraft.gow.items;

import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
				((ItemIPCard)GOWItems.itemIPCard).setDefaultInfo(itemStack, "Linked to: " + ((TilePortalBase)ent).getIPString());
				
				itemStack.getTagCompound().setLong("linked", ((TilePortalBase)ent).getIPLong());
				((ItemIPCard)GOWItems.itemIPCard).setEffect(itemStack, true);
			}
		}
		
		return false;
	}

}
