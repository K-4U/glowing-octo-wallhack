package k4unl.minecraft.gow.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

import k4unl.minecraft.gow.lib.config.ModInfo;
import k4unl.minecraft.gow.network.packets.PacketPortalEnabled;
import k4unl.minecraft.gow.network.packets.PacketPortalStateChanged;
import k4unl.minecraft.gow.network.packets.PacketSpawnParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
		buffer.writeByte(discriminator);
		msg.encodeInto(ctx, buffer);
		FMLProxyPacket proxyPacket = new FMLProxyPacket(buffer.copy(), ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
		out.add(proxyPacket);
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg,
			List<Object> out) throws Exception {
		ByteBuf payload = msg.payload();
		byte discriminator = payload.readByte();
		
		Class<? extends AbstractPacket> clazz = packets.get(discriminator);
		if(clazz == null){
			throw new NullPointerException("No packet registereted for discriminator: " + discriminator);
		}
		
		AbstractPacket pkt = clazz.newInstance();
		pkt.decodeInto(ctx, payload.slice());
		
		EntityPlayer player;
		switch(FMLCommonHandler.instance().getEffectiveSide()){
		case CLIENT:
			player = getClientPlayer();
			pkt.handleClientSide(player);
			break;
			
		case SERVER:
			INetHandler netHandler = ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
			player = ((NetHandlerPlayServer)netHandler).playerEntity;
			pkt.handleServerSide(player);
			break;
		default:
			
		}
		
		out.add(pkt);
	}
	
	
	public PacketPipeline(){
		registerPacket(PacketPortalEnabled.class);
		registerPacket(PacketPortalStateChanged.class);
		registerPacket(PacketSpawnParticle.class);
		
		channels = NetworkRegistry.INSTANCE.newChannel(ModInfo.LID, this);
		
		Collections.sort(packets, new Comparator<Class<? extends AbstractPacket>>(){

			@Override
			public int compare(Class<? extends AbstractPacket> arg0,
					Class<? extends AbstractPacket> arg1) {
				int com = String.CASE_INSENSITIVE_ORDER.compare(arg0.getCanonicalName(), arg1.getCanonicalName());
				if(com == 0){
					com = arg0.getCanonicalName().compareTo(arg1.getCanonicalName());
				}
				return com;
			}
			
		});
	}
	
	public static void init(){
		instance = new PacketPipeline();
	}
	
	@SideOnly(Side.CLIENT)
	private EntityPlayer getClientPlayer(){
		return Minecraft.getMinecraft().thePlayer;
	}
	
	public void sendToAll(AbstractPacket message){
		channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		channels.get(Side.SERVER).writeAndFlush(message);
	}
	
	public void sendTo(AbstractPacket message, EntityPlayerMP player){
		channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
		channels.get(Side.SERVER).writeAndFlush(message);
	}
	
	public void sendToAllAround(LocationIntPacket message, World world, double distance){
		sendToAllAround(message, message.getTargetPoint(world,distance));
	}
	
	public void sendToAllAround(LocationIntPacket message, World world){
		sendToAllAround(message, message.getTargetPoint(world));
	}
	
	public void sendToAllAround(LocationDoublePacket message, World world){
		sendToAllAround(message, message.getTargetPoint(world));
	}
	
	public void sendToAllAround(AbstractPacket message, NetworkRegistry.TargetPoint point){
		channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
		channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
		channels.get(Side.SERVER).writeAndFlush(message);
	}
	
	public void sendToDimension(AbstractPacket message, int dimensionId){
		channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
		channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(dimensionId);
		channels.get(Side.SERVER).writeAndFlush(message);
	}
	
	public void sendToServer(AbstractPacket message){
		channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		channels.get(Side.CLIENT).writeAndFlush(message);
	}
	

}
