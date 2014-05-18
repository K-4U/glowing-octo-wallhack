package k4unl.minecraft.gow.client.rendering;

import k4unl.minecraft.gow.blocks.GOWBlocks;
import k4unl.minecraft.gow.client.rendering.itemRendering.ItemRendererPortalBase;
import k4unl.minecraft.gow.client.rendering.itemRendering.ItemRendererPortalFrame;
import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import k4unl.minecraft.gow.tileEntities.TilePortalFrame;
import k4unl.minecraft.gow.tileEntities.TilePortalTeleporter;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;

public class Renderers {
	public static void init(){
		ClientRegistry.bindTileEntitySpecialRenderer(TilePortalBase.class, new RendererPortalBase());
		ClientRegistry.bindTileEntitySpecialRenderer(TilePortalFrame.class, new RendererPortalFrame());
		ClientRegistry.bindTileEntitySpecialRenderer(TilePortalTeleporter.class, new RendererPortalTeleporter());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(GOWBlocks.portalBase), new ItemRendererPortalBase());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(GOWBlocks.portalFrame), new ItemRendererPortalFrame());
	}
}
