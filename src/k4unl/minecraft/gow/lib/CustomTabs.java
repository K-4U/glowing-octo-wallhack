package k4unl.minecraft.gow.lib;

import k4unl.minecraft.gow.blocks.GOWBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomTabs {

	public static CreativeTabs tabGOW;
	
	public static void init(){
		tabGOW = new CreativeTabs("tabGOW") {
			
			public ItemStack getIconItemStack() {
                return new ItemStack(GOWBlocks.portalBase, 1, 0);
            }
			
			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(GOWBlocks.portalBase);
			}
		};
	}
}
