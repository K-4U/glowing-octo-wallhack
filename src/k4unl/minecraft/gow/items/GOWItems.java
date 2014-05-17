package k4unl.minecraft.gow.items;

import k4unl.minecraft.gow.lib.config.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class GOWItems {
	public static Item itemIPCard;
	
	public static void init(){
		itemIPCard = new ItemIPCard();
	}
	
	private static void registerItems(){
		GameRegistry.registerItem(itemIPCard, Names.itemIPCard);
	}
}
