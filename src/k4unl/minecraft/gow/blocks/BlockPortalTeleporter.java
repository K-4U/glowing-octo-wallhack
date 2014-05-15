package k4unl.minecraft.gow.blocks;

import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.tileEntities.TilePortalTeleporter;
import net.minecraft.tileentity.TileEntity;

public class BlockPortalTeleporter extends GOWBlockRendering {

	protected BlockPortalTeleporter() {
		super(Names.portalTeleporter);
	}

	@Override
	protected Class<? extends TileEntity> getTileEntity() {
		return TilePortalTeleporter.class;
	}
}
