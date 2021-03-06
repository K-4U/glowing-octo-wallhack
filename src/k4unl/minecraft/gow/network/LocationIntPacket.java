package k4unl.minecraft.gow.network;

import net.minecraft.world.World;
import k4unl.minecraft.gow.lib.config.Constants;
import cpw.mods.fml.common.network.NetworkRegistry;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;


public abstract class LocationIntPacket extends AbstractPacket {
	protected int x, y, z;
	
	public LocationIntPacket(){}
	
	public LocationIntPacket(int _x, int _y, int _z){
		x = _x;
		y = _y;
		z = _z;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer){
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
	}
	
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer){
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
	}
	
	public NetworkRegistry.TargetPoint getTargetPoint(World world){
		return getTargetPoint(world, Constants.PACKET_UPDATE_DISTANCE);
	}
	
	public NetworkRegistry.TargetPoint getTargetPoint(World world, double updateDistance){
		return new NetworkRegistry.TargetPoint(world.provider.dimensionId, x, y, z, updateDistance);
	}
}

