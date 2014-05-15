package k4unl.minecraft.gow.lib.helperClasses;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class Location {
	private int x;
	private int y;
	private int z;
	
	public Location(int _x, int _y, int _z){
		x = _x;
		y = _y;
		z = _z;
	}
	
	public Block getBlock(IBlockAccess iba){
		
	}
}
