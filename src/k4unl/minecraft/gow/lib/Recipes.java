package k4unl.minecraft.gow.lib;

import k4unl.minecraft.gow.blocks.GOWBlocks;
import k4unl.minecraft.gow.items.GOWItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GOWBlocks.portalBase, 1), true,
				new Object[] {
			"III",
			"EEE",
			"III",
			'I', Items.iron_ingot,
			'E', Items.ender_pearl
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GOWBlocks.portalFrame, 6), true,
				new Object[] {
			"III",
			"IEI",
			"III",
			'I', Items.iron_ingot,
			'E', Items.ender_pearl
		}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GOWItems.itemIPCard, 1), true,
				new Object[] {
			"ROO",
			"RWI",
			"RII",
			'I', Items.iron_ingot,
			'R', Items.redstone,
			'W', new ItemStack(Blocks.wool, 1, 15),
			'O', new ItemStack(Blocks.wool, 1, 14)
		}));
	}
}
