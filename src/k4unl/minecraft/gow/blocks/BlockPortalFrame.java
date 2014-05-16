package k4unl.minecraft.gow.blocks;

import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import k4unl.minecraft.gow.tileEntities.TilePortalFrame;
import net.minecraft.tileentity.TileEntity;

public class BlockPortalFrame extends GOWBlockRendering {
	private static Vector3fMax blockBounds = new Vector3fMax(0.3F, 0.3F, 0.3F, 0.7F, 0.7F, 0.7F);
	
	protected BlockPortalFrame() {
		super(Names.portalFrame);
	}

	@Override
	protected Class<? extends TileEntity> getTileEntity() {
		return TilePortalFrame.class;
	}
	
}
