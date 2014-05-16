package k4unl.minecraft.gow.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;

@ChannelHandler.Sharable
public class PacketPipeline extends
		MessageToMessageCodec<FMLProxyPacket, AbstractPacket> {

	public static PacketPipeline instance;
	
	private EnumMap<Side, FMLEmbeddedChannel> channels;
	private final LinkedList<Class<? extends AbstractPacket>> packets = new LinkedList<Class<? extends AbstractPacket>>();
	
	public boolean registerPacket(Class<? extends AbstractPacket> clazz){
		if(packets.size() >= 256){
			throw new IllegalArgumentException("Registered more thatn 256 packets!");
		}
		
		if(packets.contains(clazz)){
			throw new IllegalArgumentException("Tried to register a packet that is already registered!");
		}
		
		packets.add(clazz);
		return true;
	}
	
	
	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractPacket msg,
			List<Object> out) throws Exception {
		ByteBuf buffer = Unpooled.buffer();
		Class<? extends AbstractPacket> clazz = msg.getClass();
		if(!packets.contains(msg.getClass())){
			throw new NullPointerException("No packet registered for: " + msg.getClass().getCanonicalName());
		}
		
		byte discriminator = (byte) packets.indexOf(clazz);
		buffer.writeByte(ctx, buffer);
		
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg,
			List<Object> out) throws Exception {
	}

}
