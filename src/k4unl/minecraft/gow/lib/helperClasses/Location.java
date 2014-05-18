package k4unl.minecraft.gow.lib.helperClasses;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class Location {
	private int x;
	private int y;
	private int z;
	private int dimension;
	
	public Location(int _x, int _y, int _z){
		x = _x;
		y = _y;
		z = _z;
	}
	public Location(int _x, int _y, int _z, int _dimension){
		x = _x;
		y = _y;
		z = _z;
		dimension = _dimension;
	}
	
	public Location(int[] loc){
		if(loc.length > 2){
			x = loc[0];
			y = loc[1];
			z = loc[2];
			if(loc.length > 3){
				dimension = loc[3];
			}
		}else{
			//Log.error("Trying to load a location with a wrong int array!");
		}
	}
	
	public Location(int _x, int _y, int _z, ForgeDirection d, int offset){
		x = _x + (d.offsetX * offset);
		y = _y + (d.offsetY * offset);
		z = _z + (d.offsetZ * offset);
	}
	
	public Location(int _x, int _y, int _z, int _dimension, ForgeDirection d, int offset){
		x = _x + (d.offsetX * offset);
		y = _y + (d.offsetY * offset);
		z = _z + (d.offsetZ * offset);
		dimension = _dimension;
	}
	
	public Location(Location baseLoc, ForgeDirection d, int offset){
		x = baseLoc.getX() + (d.offsetX * offset);
		y = baseLoc.getY() + (d.offsetY * offset);
		z = baseLoc.getZ() + (d.offsetZ * offset);
		dimension = baseLoc.dimension;
	}
	
	public Location(int _x, int _y, int _z, ForgeDirection d) {
		x = _x + d.offsetX;
		y = _y + d.offsetY;
		z = _z + d.offsetZ;
	}
	public Location(int _x, int _y, int _z, int _dimension, ForgeDirection d) {
		x = _x + d.offsetX;
		y = _y + d.offsetY;
		z = _z + d.offsetZ;
		dimension = _dimension;
	}

	public Block getBlock(IBlockAccess iba){
		return iba.getBlock(x, y, z);
	}
	
	public Block getBlock(IBlockAccess iba, ForgeDirection dir){
		return iba.getBlock(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
	}
	
	public TileEntity getTE(IBlockAccess iba){
		return iba.getTileEntity(x, y, z);
	}
	
	public TileEntity getTE(IBlockAccess iba, ForgeDirection dir){
		return iba.getTileEntity(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
	}
	
	public void setX(int newX){
		x = newX;
	}
	public void setY(int newY){
		y = newY;
	}
	public void setZ(int newZ){
		z = newZ;
	}
	public void setDimension(int newDimension){
		dimension = newDimension;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getZ(){
		return z;
	}
	public int getDimension(){
		return dimension;
	}
	
	public void addX(int toAdd){
		x += toAdd;
	}
	public void addY(int toAdd){
		y += toAdd;
	}
	public void addZ(int toAdd){
		z += toAdd;
	}
	
	public void offset(ForgeDirection dir, int offsetInt){
		x += dir.offsetX * offsetInt;
		y += dir.offsetY * offsetInt;
		z += dir.offsetZ * offsetInt;
	}

	public String print() {
		return String.format("D: " + dimension + " X: " + x + " Y: " + y + " Z: " + z);
	}
	
	public int[] getIntArray(){
		return new int[] {x, y, z, dimension};
	}
}
