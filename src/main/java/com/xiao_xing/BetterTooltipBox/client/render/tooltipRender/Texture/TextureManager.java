package com.xiao_xing.BetterTooltipBox.client.render.tooltipRender.Textrue;

import com.xiao_xing.BetterTooltipBox.Config.ConfigManager;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Objects;

import static com.xiao_xing.BetterTooltipBox.BetterTooltipBox.LOG;

public class TextureManager {

    private final HashMap<String, TooltipsTexture> TEXTURE_MAP = new HashMap<>();
    private final HashMap<String,TooltipsTexture> SpecialItemList = new HashMap<>();

    public static final TextureManager INSTANCE = new TextureManager();
//    static {
//        TEXTURE_MAP.put("default", new ResourceLocation(ResourceID + "gui/tooltip_borders.png"));
//    }

    public static TextureManager getInstance() {
        return INSTANCE;
    }

    public void register(TooltipsTexture Texture) {
        if (TEXTURE_MAP.containsKey(Texture.getTextureName()) && ConfigManager.Instance.Enable_TooltipsOverwrite) {
            LOG.warn("Texture {} 被替换！", Texture.getTextureName());
            TEXTURE_MAP.put(Texture.getTextureName(), Texture);
        }else {
            LOG.warn("Texture {} 注册成功！", Texture.getTextureName());
            TEXTURE_MAP.put(Texture.getTextureName(), Texture);
        }
    }

    public void reload(TooltipsTexture Texture){
        TEXTURE_MAP.put(Texture.getTextureName(), Texture);
    }

    public  void registerSpecialItem(String itemStack, String name){
        TooltipsTexture texture = TextureManager.getInstance().getTexture(name);
        if(itemStack==null||texture==null){
            return;
        }
        SpecialItemList.put(itemStack,texture);
    }

    public void registerSpecialItem(String itemStack, TooltipsTexture texture){
        if(itemStack==null||texture==null){
            return;
        }
        SpecialItemList.put(itemStack,texture);
    }

    public void removeSpecialItem(String itemStack){
        if(itemStack==null){
            return;
        }
        SpecialItemList.remove(itemStack);
    }

    public TooltipsTexture getTexture(String TextureName) {
        if (TEXTURE_MAP.containsKey(TextureName)) {
            return TEXTURE_MAP.get(TextureName);
        }
        LOG.error("Texture {} not found", TextureName);
        return null;
    }

    public TooltipsTexture fromItemTexture(ItemStack itemStack){
        if (itemStack==null){
            return null;
        }
        return SpecialItemList.get(Objects.requireNonNull(GameRegistry.findUniqueIdentifierFor(itemStack.getItem())) + ":" +itemStack.getItemDamage());
    }
}
