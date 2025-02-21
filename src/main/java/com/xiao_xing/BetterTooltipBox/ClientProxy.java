package com.xiao_xing.BetterTooltipBox;

import com.xiao_xing.BetterTooltipBox.Mixins.MixinPlugin;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy {

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        if (MixinPlugin.isLoaderGTNHlib) {
            try {
                Class.forName("com.xiao_xing.BetterTooltipBox.client.event.renderTooltipEvent")
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
