package k4unl.minecraft.gow.lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class Functions {

	public static void showMessageInChat(EntityPlayer player, String message){
		player.addChatMessage(new ChatComponentText(message));
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
}
