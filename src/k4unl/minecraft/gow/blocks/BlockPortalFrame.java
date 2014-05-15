package k4unl.minecraft.gow.blocks;

import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.tileEntities.TilePortalFrame;
import net.minecraft.tileentity.TileEntity;

public class BlockPortalFrame extends GOWBlockRendering {

	protected BlockPortalFrame() {
		super(Names.portalFrame);
	}

	@Override
	protected Class<? extends TileEntity> getTileEntity() {
		return TilePortalFrame.class;
	}

}
