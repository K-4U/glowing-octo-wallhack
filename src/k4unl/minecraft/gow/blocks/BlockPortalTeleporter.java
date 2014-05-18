package k4unl.minecraft.gow.blocks;

import java.util.List;

import k4unl.minecraft.gow.lib.config.Config;
import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.lib.helperClasses.Location;
import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import k4unl.minecraft.gow.tileEntities.TilePortalTeleporter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPortalTeleporter extends GOWBlockRendering {
	private static Vector3fMax blockBounds = new Vector3fMax(0.3F, 0.3F, 0.3F, 0.7F, 0.7F, 0.7F);
	
	
	protected BlockPortalTeleporter() {
		super(Names.portalTeleporter);
	}

	@Override
	protected Class<? extends TileEntity> getTileEntity() {
		return TilePortalTeleporter.class;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean canRenderInPass(int pass){
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderBlockPass(){
		return 1;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess iba, int x, int y, int z){
		TileEntity ent = iba.getTileEntity(x, y, z);
		
		if(ent instanceof TilePortalTeleporter){
			TilePortalTeleporter teleporter = (TilePortalTeleporter)ent;
			Vector3fMax vector = blockBounds;
			if(teleporter.getBaseDir() != null){
				if(teleporter.getBaseDir().equals(ForgeDirection.NORTH) | teleporter.getPortalDir().equals(ForgeDirection.NORTH)){
					vector.setZMin(0.0F);
					vector.setZMax(1.0F);
				}
				if(teleporter.getPortalDir().equals(ForgeDirection.UP)){
					vector.setYMin(0.0F);
					vector.setYMax(1.0F);
				}
				if(teleporter.getBaseDir().equals(ForgeDirection.EAST) || teleporter.getPortalDir().equals(ForgeDirection.EAST)){
					vector.setXMin(0.0F);
					vector.setXMax(1.0F);
				}
			}
			
			this.setBlockBounds(vector.getXMin(), vector.getYMin(), vector.getZMin(), vector.getXMax(), vector.getYMax(), vector.getZMax());
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addCollisionBoxesToList(World w, int x, int y, int z, AxisAlignedBB axigAlignedBB, List arrayList, Entity entity){
		
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
		if(!world.isRemote){
			NBTTagCompound entCompound = entity.getEntityData();
			Location teLocation = new Location(x,y,z);
			TilePortalTeleporter teleporter = (TilePortalTeleporter)teLocation.getTE(world);
			Location teleportLocation = teleporter.getPortalBase().getTarget();
			long lastInPortal = entCompound.getLong("lastInPortal" + teleporter.getPortalBase().getIPLong());
			if(world.getTotalWorldTime() - lastInPortal > (Config.getInt("portalTimeoutInSeconds") * 20)){
				if(teleportLocation != null){
					if(entity instanceof EntityPlayer){
						((EntityPlayer)entity).setPositionAndUpdate(teleportLocation.getX(), teleportLocation.getY(), teleportLocation.getZ());	
					}else{
						entity.setLocationAndAngles(teleportLocation.getX(), teleportLocation.getY()+1, teleportLocation.getZ(), entity.rotationYaw, entity.rotationPitch);
					}
					entCompound.setLong("lastInPortal" + teleporter.getPortalBase().getIPLong(), world.getTotalWorldTime());
				}
			}
		}
	}
}
