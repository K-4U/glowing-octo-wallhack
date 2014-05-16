package k4unl.minecraft.gow.network.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import k4unl.minecraft.gow.network.LocationIntPacket;
import k4unl.minecraft.gow.tileEntities.TilePortalTeleporter;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class PacketPortalEnabled extends LocationIntPacket {
	private ForgeDirection baseDir;
	private ForgeDirection portalDir;
	
	public PacketPortalEnabled(){}
	public PacketPortalEnabled(int x, int y, int z, ForgeDirection _baseDir, ForgeDirection _portalDir){
		super(x, y, z);
		baseDir = _baseDir;
		portalDir = _portalDir;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		super.encodeInto(ctx, buffer);
		buffer.writeInt(baseDir.ordinal());
		buffer.writeInt(portalDir.ordinal());
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		super.decodeInto(ctx, buffer);
		baseDir = ForgeDirection.getOrientation(buffer.readInt());
		portalDir = ForgeDirection.getOrientation(buffer.readInt());
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		TileEntity ent =player.worldObj.getTileEntity(x, y, z);
		Block bl = player.worldObj.getBlock(x, y, z);
		if(player.worldObj.getTileEntity(x, y, z) instanceof TilePortalTeleporter){
			((TilePortalTeleporter)player.worldObj.getTileEntity(x, y, z)).setRotation(baseDir, portalDir);
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

	}

}
