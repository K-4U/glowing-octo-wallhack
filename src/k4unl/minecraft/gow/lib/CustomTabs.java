package k4unl.minecraft.gow.lib;

import k4unl.minecraft.gow.blocks.GOWBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CustomTabs {

	public static CreativeTabs tabGOW;
	
	public static void init(){
		tabGOW = new CreativeTabs("tabGOW") {
			
			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(GOWBlocks.portalBase);
			}
		};
	}
}
