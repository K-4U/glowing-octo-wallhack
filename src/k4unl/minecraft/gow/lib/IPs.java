package k4unl.minecraft.gow.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IPs {
	private Random rnd;
	private List<Long> registeredIps;
	
	public IPs(){
		registeredIps = new ArrayList<Long>();
		rnd = new Random(System.currentTimeMillis()/1000);
	}
	
	public boolean IPExists(long ip){
		return registeredIps.contains(ip);
	}
	
	public void registerIP(long ip){
		registeredIps.add(ip);
	}
	
	public void removeIP(long ip){
		registeredIps.remove(ip);
	}
	
	public String generateNewRandomIP(){
		String[] IP = {"10", "230", "0", "0"};
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
	
	public long ipToLong(String IP){
		long result = 0;
		String[] pieces = IP.split("\\.");
		
		for(int i = 3; i >= 0; i--){
			result |= (Long.parseLong(pieces[3-i]) << (i * 8));
		}
		
		return result & 0xFFFFFFFF;
	}
	
	public String longToIp(long IP){
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
}
