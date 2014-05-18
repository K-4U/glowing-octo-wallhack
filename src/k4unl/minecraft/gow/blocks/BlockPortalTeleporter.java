package k4unl.minecraft.gow.blocks;

import java.util.List;
import java.util.Random;

import k4unl.minecraft.gow.lib.TeleportHelper;
import k4unl.minecraft.gow.lib.config.Config;
import k4unl.minecraft.gow.lib.config.Names;
import k4unl.minecraft.gow.lib.helperClasses.Location;
import k4unl.minecraft.gow.lib.helperClasses.Vector3fMax;
import k4unl.minecraft.gow.tileEntities.TilePortalTeleporter;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPortalTeleporter extends GOWBlockRendering {
	private static Vector3fMax blockBounds = new Vector3fMax(0.499F, 0.499F, 0.499F, 0.501F, 0.501F, 0.501F);
	
	
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
			Vector3fMax vector = blockBounds.copy();
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
					TeleportHelper.teleportEntity(entity, teleportLocation);
					/*if(teleportLocation.getDimension() != world.provider.dimensionId){
						
					}else{
						if(entity instanceof EntityPlayer){
							((EntityPlayer)entity).setPositionAndUpdate(teleportLocation.getX()+0.5, teleportLocation.getY()+0.5, teleportLocation.getZ()+0.5);	
						}else{
							entity.setLocationAndAngles(teleportLocation.getX()+0.5, teleportLocation.getY()+0.5, teleportLocation.getZ()+0.5, entity.rotationYaw, entity.rotationPitch);
						}
					}*/
					
					entCompound.setLong("lastInPortal" + teleporter.getPortalBase().getIPLong(), world.getTotalWorldTime());
				}
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World w, int x, int y, int z, Random rnd){
		/*for (int l = 0; l < 1; ++l)
        {*/
		if(rnd.nextInt(100) <= 50){
            double d0 = (double)((float)x + rnd.nextFloat());
            double d1 = (double)((float)y + rnd.nextFloat());
            double d2 = (double)((float)z + rnd.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = rnd.nextInt(2) * 2 - 1;
            d3 = ((double)rnd.nextFloat() - 0.6D) * 0.1D;
            d4 = ((double)rnd.nextFloat() - 0.6D) * 0.1D;
            d5 = ((double)rnd.nextFloat() - 0.6D) * 0.1D;

            w.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
		}
        //}
	}
}
