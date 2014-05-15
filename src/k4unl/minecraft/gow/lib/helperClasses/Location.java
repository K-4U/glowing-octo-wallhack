package k4unl.minecraft.gow.lib.helperClasses;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class Location {
	private int x;
	private int y;
	private int z;
	
	public Location(int _x, int _y, int _z){
		x = _x;
		y = _y;
		z = _z;
	}
	
	public Location(int _x, int _y, int _z, ForgeDirection d, int offset){
		x = _x + (d.offsetX * offset);
		y = _y + (d.offsetY * offset);
		z = _z + (d.offsetZ * offset);
	}
	
	public Location(Location baseLoc, ForgeDirection d, int offset){
		x = baseLoc.getX() + (d.offsetX * offset);
		y = baseLoc.getY() + (d.offsetY * offset);
		z = baseLoc.getZ() + (d.offsetZ * offset);
	}
	
	public Location(int _x, int _y, int _z, ForgeDirection d) {
		x = _x + d.offsetX;
		y = _y + d.offsetY;
		z = _z + d.offsetZ;
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
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getZ(){
		return z;
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
		return String.format("X: " + x + "\tY: " + y + "\tZ: " + z);
	}
}
