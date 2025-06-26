package com.xiao_xing.BetterTooltipBox;

import java.io.IOException;

import com.xiao_xing.BetterTooltipBox.Mixins.MixinPlugin;
import com.xiao_xing.BetterTooltipBox.client.render.event.keyInputEvent;
import com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.TooltipsLoader;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        new keyInputEvent();
    }

    @Override
    public void init(FMLInitializationEvent event) throws IOException {
        super.init(event);
        if (MixinPlugin.isLoaderGTNHlib) {
            try {
                Class.forName("com.xiao_xing.BetterTooltipBox.client.render.event.renderTooltipEvent")
                    .getConstructor()
                    .newInstance();
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

}
