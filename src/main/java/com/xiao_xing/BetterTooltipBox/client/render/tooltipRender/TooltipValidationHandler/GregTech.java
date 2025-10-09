package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import java.util.ArrayList;

import bartworks.common.blocks.BWBlocks;
import bartworks.common.blocks.BWBlocksGlass2;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TextureManager;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue.TooltipsTexture;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.MTECable;
import gregtech.api.util.GTUtility;
import gregtech.api.util.GlassTier;
import gregtech.common.blocks.BlockMachines;
import gregtech.common.blocks.ItemMachines;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GTValues.V;

public class GregTech implements ITooltipValidationHandler{

    protected final ArrayList<ItemStack> ExtraItemStackList = new ArrayList<>();

    private final ArrayList<String> Tier = new ArrayList<>();
    {
        Tier.add("ULV");
        Tier.add("LV");
        Tier.add("UHV");
        Tier.add("UEV");
        Tier.add("UIV");
        Tier.add("UMV");
        Tier.add("UHV");
        Tier.add("MV");
        Tier.add("HV");
        Tier.add("EV");
        Tier.add("IV");
        Tier.add("LuV");
        Tier.add("ZPM");
        Tier.add("UV");
        Tier.add("UXV");
        Tier.add("MAX");
    }

    public GregTech() {
    }

//    public boolean modIdCheck(String modId, ItemStack itemStack) {
//        if (!ExtraItemStackList.isEmpty()) {
//            for (ItemStack item : ExtraItemStackList) {
//                if (item.getItem() == itemStack.getItem() && item.getItemDamage() == itemStack.getItemDamage()) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

    private byte checkTier(ItemStack itemStack) {
        byte VoltageTier = -1;
            final int tDamage = itemStack.getItemDamage();
            Block block = Block.getBlockFromItem(itemStack.getItem());
            if (block instanceof BWBlocks || block instanceof BWBlocksGlass2) {
                Integer tGlassTier = GlassTier.getGlassBlockTier(block, tDamage);
                if (tGlassTier != null) {
                    return tGlassTier.byteValue();
                }
            } else if ((tDamage <= 0) || (tDamage >= GregTechAPI.METATILEENTITIES.length)) {
                return -1;
            } else if (itemStack.getItem() instanceof ItemMachines || block instanceof BlockMachines) {
                IMetaTileEntity[] iMetaTileEntities = GregTechAPI.METATILEENTITIES;
                if (iMetaTileEntities[tDamage] instanceof MetaTileEntity mte) {
                    final IGregTechTileEntity tile = mte.getBaseMetaTileEntity();
                    if (tile != null && tile.getInputVoltage() > 0) {
                        VoltageTier = tile.getOutputVoltage() > 0
                            ? GTUtility.getTier(Math.min(tile.getInputVoltage(), tile.getOutputVoltage()))
                            : GTUtility.getTier(tile.getInputVoltage());
                    }
                } else if (iMetaTileEntities[tDamage] instanceof MTECable cable) {
                    VoltageTier = GTUtility.getTier(cable.mVoltage);
                }
            }
        return VoltageTier;
    }

    private TooltipsTexture getTierTexture(String tier) {
        return TextureManager.getInstance().getTexture(tier);
    }

    @Override
    public TooltipsTexture TooltipValidation(String modId, ItemStack itemStack) {
       byte VoltageTier = checkTier(itemStack);
        if (VoltageTier != -1) {
            return getTierTexture(GTValues.VN[VoltageTier]);
        }
        String Name = itemStack.getDisplayName().toUpperCase();
        for (String tier : Tier) {
            int index = Name.indexOf(tier.toUpperCase());
            if (index != -1) {
                return getTierTexture(tier);
            }
        }
        return null;
    }

}
