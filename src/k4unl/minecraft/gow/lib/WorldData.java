package k4unl.minecraft.gow.lib;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;

public class WorldData extends WorldSavedData {

	public final static String key = "gow.portals";
	
	public static WorldData forWorld(World world){
		MapStorage storage = world.perWorldStorage;
		WorldData result = (WorldData)storage.loadData(WorldData.class, key);
		if(result == null){
			result = new WorldData();
			storage.setData(key, result);
		}
		return result;
	}
	
	public WorldData() {
		super(key);
	}

	@Override
	public void readFromNBT(NBTTagCompound var1) {

	}

	@Override
	public void writeToNBT(NBTTagCompound var1) {

	}

}
