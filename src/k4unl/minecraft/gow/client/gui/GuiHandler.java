package k4unl.minecraft.gow.client.gui;

import k4unl.minecraft.gow.containers.ContainerPortalBase;
import k4unl.minecraft.gow.tileEntities.TilePortalBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity ent = world.getTileEntity(x, y, z);
		if(ent != null){
			switch(ID){
			case GuiIDS.GUIPortalBase:
				if(ent instanceof TilePortalBase){
					return new ContainerPortalBase(player.inventory, (TilePortalBase) ent);
				}
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

}
