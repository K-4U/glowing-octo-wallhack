package k4unl.minecraft.gow.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public abstract class AbstractPacket {

	public abstract void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer);

}
