package k4unl.minecraft.gow.blocks;

import k4unl.minecraft.gow.lib.config.Names;
import net.minecraft.tileentity.TileEntity;

public class BlockPortalBase extends GOWBlockBase {

	protected BlockPortalBase() {
		super(Names.portalBase);
		
	}

	@Override
	protected Class<? extends TileEntity> getTileEntity() {
		return null;
	}

}
