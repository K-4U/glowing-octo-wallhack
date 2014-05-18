package k4unl.minecraft.gow.items;

import java.util.List;

import k4unl.minecraft.gow.lib.CustomTabs;
import k4unl.minecraft.gow.lib.config.ModInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GOWItemBase extends Item {

	private String mName;
	private boolean hasEffect = false;
	private String defaultInfo = "";
	
	public GOWItemBase(String name){
		super();
		
		mName = name;
		setMaxStackSize(64);
		setUnlocalizedName(name);
		
		setTextureName(ModInfo.LID + ":" + name);
		setCreativeTab(CustomTabs.tabGOW);
	}
	
	
	public void setEffect(boolean _hasEffect){
		hasEffect = _hasEffect;
	}
	
	public void setEffect(ItemStack itemStack, boolean _hasEffect){
		NBTTagCompound stackCompound = itemStack.getTagCompound();
		stackCompound.setBoolean("hasEffect", _hasEffect);
		itemStack.setTagCompound(stackCompound);
	}
	
	@Override
	public boolean hasEffect(ItemStack itemStack){
		if(itemStack.getTagCompound() == null){
			itemStack.setTagCompound(new NBTTagCompound());
		}
		
		return hasEffect || itemStack.getTagCompound().getBoolean("hasEffect");
	}
	
	public void setDefaultInfo(String info){
		defaultInfo = info;
	}
	
	public void setDefaultInfo(ItemStack itemStack, String info){
		if(itemStack.getTagCompound() == null){
			itemStack.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound stackCompound = itemStack.getTagCompound();
		stackCompound.setString("defaultInfo", info);
		itemStack.setTagCompound(stackCompound);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4){
		if(defaultInfo != ""){
			list.add(defaultInfo);
		}
		if(itemStack.getTagCompound() != null){
			if(itemStack.getTagCompound().getString("defaultInfo") != ""){
				list.add(itemStack.getTagCompound().getString("defaultInfo"));
			}
		}
	}
	
	
}
