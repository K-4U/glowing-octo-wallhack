package k4unl.minecraft.gow.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import k4unl.minecraft.gow.lib.helperClasses.Location;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;

public class IPs extends WorldSavedData {
	private Random rnd;
	private boolean isLoaded = false;
	private Map<Long, Location> registeredIps;
	
	public final static String key = "gow.portals";
	
	public static IPs forWorld(World world){
		MapStorage storage = world.perWorldStorage;
		IPs result = (IPs)storage.loadData(IPs.class, key);
		if(result == null){
			result = new IPs();
			storage.setData(key, result);
		}
		return result;
	}
	
	public IPs(String key){
		super(key);
		registeredIps = new HashMap<Long, Location>();
		rnd = new Random(System.currentTimeMillis()/1000);
	}
	
	public IPs(){
		super(key);
		registeredIps = new HashMap<Long, Location>();
		rnd = new Random(System.currentTimeMillis()/1000);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tCompound){
		isLoaded = true;
		int entries = tCompound.getInteger("entries");
		for(int i = 0; i<entries; i++){
			NBTTagCompound entryCompound = tCompound.getCompoundTag(""+i);
			long key = entryCompound.getLong("key");
			Location value = new Location(entryCompound.getIntArray("location"));
			registeredIps.put(key, value);
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tCompound){
		int i = 0;
		for(Map.Entry<Long, Location> entry : registeredIps.entrySet()){
			NBTTagCompound entryCompound = new NBTTagCompound();
			entryCompound.setLong("key", entry.getKey());
			entryCompound.setIntArray("location", entry.getValue().getIntArray());
			tCompound.setTag(i+"", entryCompound);
			i++;
		}
		tCompound.setInteger("entries", registeredIps.size());
	}
	
	public boolean IPExists(long ip){
		return registeredIps.containsKey(ip);
	}
	
	public void registerIP(long ip, Location loc){
		registeredIps.put(ip, loc);
		markDirty();
	}
	
	public void removeIP(long ip){
		registeredIps.remove(ip);
		markDirty();
	}
	
	public String generateNewRandomIP(int dimensionID){
		String[] IP = {"10", (dimensionID + 2) + "", "0", "0"};
		String fullIP = "";
		boolean redo = true;
		while(redo){
			IP[2] = rnd.nextInt(253) + 1 + "";
			IP[3] = rnd.nextInt(253) + 1 + "";
			
			fullIP = IP[0] + "." + IP[1] + "." + IP[2] + "." + IP[3];
			redo = IPExists(ipToLong(fullIP));
		}
		return fullIP;
	}
	
	public static long ipToLong(String IP){
		long result = 0;
		String[] pieces = IP.split("\\.");
		
		for(int i = 3; i >= 0; i--){
			result |= (Long.parseLong(pieces[3-i]) << (i * 8));
		}
		
		return result & 0xFFFFFFFF;
	}
	
	public static String longToIp(long IP){
		StringBuilder sb = new StringBuilder(15);
		for(int i = 0; i < 4; i++){
			sb.insert(0, Long.toString(IP & 0xFF));
			if(i < 3){
				sb.insert(0, '.');
			}
			
			IP >>= 8;
		}
		return sb.toString();
	}

	public Location getLocation(long linked) {
		return registeredIps.get(linked);
	}
}
