package com.xiao_xing.BetterTooltipBox;

import com.xiao_xing.BetterTooltipBox.Config.ConfigManager;
import com.xiao_xing.BetterTooltipBox.Mixins.plugin.mixinPlugin;
import com.xiao_xing.BetterTooltipBox.client.command.commandConfig;
import com.xiao_xing.BetterTooltipBox.client.render.event.keyInputEvent;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Texture.TextureLoader;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipValidationHandler.TooltipValidationLoader;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.io.IOException;
import java.util.ArrayList;

import static com.xiao_xing.BetterTooltipBox.Config.ConfigManager.registerSpecialItemList;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        ConfigManager.init(event.getModConfigurationDirectory());
        new TextureLoader().loader();
        new keyInputEvent();

        if (Loader.isModLoaded("gregtech")) {
            TooltipValidationLoader.loaderGT();
        }
    }

    @Override
    public void init(FMLInitializationEvent event) throws IOException {
        super.init(event);
        if (mixinPlugin.isLoaderGTNHlib) {
            try {
                Class.forName("com.xiao_xing.BetterTooltipBox.client.render.event.renderTooltipEvent")
                    .getConstructor()
                    .newInstance();
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        registerSpecialItemList();
        super.postInit(event);
    }

    @Override
    public void serverStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new commandConfig());
    }

}
