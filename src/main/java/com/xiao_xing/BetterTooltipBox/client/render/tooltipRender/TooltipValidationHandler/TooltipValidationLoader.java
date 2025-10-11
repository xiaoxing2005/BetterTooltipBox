package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler;

import static gregtech.api.enums.Mods.ModIDs.BART_WORKS;
import static gregtech.api.enums.Mods.ModIDs.DETRAV_SCANNER_MOD;
import static gregtech.api.enums.Mods.ModIDs.GALACTI_GREG;
import static gregtech.api.enums.Mods.ModIDs.GOOD_GENERATOR;
import static gregtech.api.enums.Mods.ModIDs.GREG_TECH;
import static gregtech.api.enums.Mods.ModIDs.G_G_FAB;
import static gregtech.api.enums.Mods.ModIDs.G_T_N_H_LANTHANIDES;
import static gregtech.api.enums.Mods.ModIDs.G_T_PLUS_PLUS;
import static gregtech.api.enums.Mods.ModIDs.G_T_PLUS_PLUS_EVERGLADES;
import static gregtech.api.enums.Mods.ModIDs.KEKZ_TECH;
import static gregtech.api.enums.Mods.ModIDs.KUBA_TECH;
import static gregtech.api.enums.Mods.ModIDs.N_E_I_ORE_PLUGIN;
import static gregtech.api.enums.Mods.ModIDs.TECTECH;

public class TooltipValidationLoader {

    public static void loaderGT(){
        ITooltipValidationHandler GT = new GregTech();
        ITooltipValidationHandler.register(GREG_TECH, GT);
        ITooltipValidationHandler.register(BART_WORKS, GT);
        ITooltipValidationHandler.register(DETRAV_SCANNER_MOD, GT);
        ITooltipValidationHandler.register(GALACTI_GREG, GT);
        ITooltipValidationHandler.register(G_G_FAB, GT);
        ITooltipValidationHandler.register(GOOD_GENERATOR, GT);
        ITooltipValidationHandler.register(G_T_N_H_LANTHANIDES, GT);
        ITooltipValidationHandler.register(G_T_PLUS_PLUS, GT);
        ITooltipValidationHandler.register(G_T_PLUS_PLUS_EVERGLADES, GT);
        ITooltipValidationHandler.register(KEKZ_TECH, GT);
        ITooltipValidationHandler.register(KUBA_TECH, GT);
        ITooltipValidationHandler.register(N_E_I_ORE_PLUGIN, GT);
        ITooltipValidationHandler.register(TECTECH, GT);
    }

}
