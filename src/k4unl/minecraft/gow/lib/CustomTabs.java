package k4unl.minecraft.gow.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CustomTabs {

	public static CreativeTabs tabGOW;
	
	public static void init(){
		tabGOW = new CreativeTabs("tabGOW") {
			
			@Override
			public Item getTabIconItem() {
				//TODO: CHANGE ME
				return Items.apple;
			}
		};
	}
}
