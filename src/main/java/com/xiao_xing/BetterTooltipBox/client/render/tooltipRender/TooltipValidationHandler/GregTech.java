package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import java.util.ArrayList;

import bartworks.common.blocks.BWBlocks;
import bartworks.common.blocks.BWBlocksGlass2;
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

public class GregTech extends ModIdValidationBase {

    private static final ArrayList<String> ModIdList = new ArrayList<>() {};

    private final ArrayList<String> Tier = new ArrayList<>();
    {
        Tier.add("ULV");
        Tier.add("LV");
        Tier.add("MV");
        Tier.add("HV");
        Tier.add("EV");
        Tier.add("IV");
        Tier.add("LuV");
        Tier.add("ZPM");
        Tier.add("UV");
        Tier.add("UHV");
        Tier.add("UEV");
        Tier.add("UIV");
        Tier.add("UMV");
        Tier.add("UHV");
        Tier.add("UXV");
    }
    private String TooltipsName;

    static {
        ModIdList.add("gregtech");
        ModIdList.add("kubatech");
        ModIdList.add("GoodGenerator");
        ModIdList.add("bartworks");
    }

    public GregTech() {
    }

    @Override
    public boolean modIdCheck(String modId, ItemStack itemStack) {
        if (!ModIdList.contains(modId)) return false;
        if (!ExtraItemStackList.isEmpty()) {
            for (ItemStack item : ExtraItemStackList) {
                if (item.getItem() == itemStack.getItem() && item.getItemDamage() == itemStack.getItemDamage()) {
                    return true;
                }
            }
        }
        long VoltageTier = checkTier(itemStack);
        if (VoltageTier > -1) {
            String tier = GTValues.VN[(byte) VoltageTier];
            return Tier.contains(tier.toUpperCase());
        }
        String Name = itemStack.getDisplayName().toUpperCase();
        for (String tier : Tier) {
            if (Name.contains(tier)) {
                TooltipsName = tier;
                return true;
            }
        }
        return false;
    }

    private byte checkTier(ItemStack itemStack) {
        byte VoltageTier = -1;
        try {
            final int tDamage = itemStack.getItemDamage();
            Block block = Block.getBlockFromItem(itemStack.getItem());
            if (block instanceof BWBlocks || block instanceof BWBlocksGlass2) {
                Integer tGlassTier = GlassTier.getGlassBlockTier(block, tDamage);
                if (tGlassTier != null) {
                    VoltageTier = GTUtility.getTier(tGlassTier);
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
        } catch (NullPointerException ignored) {}
        return VoltageTier;
    }

    @Override
    public String getTooltipName() {
        return Tier;
    }
}
