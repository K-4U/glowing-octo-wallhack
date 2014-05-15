package k4unl.minecraft.gow.blocks;


public abstract class GOWBlockRendering extends GOWBlockBase {

	protected GOWBlockRendering(String name) {
		super(name);
	}

	@Override
	public int getRenderType(){
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
}
