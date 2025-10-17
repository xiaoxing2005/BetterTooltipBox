# BetterTooltipBox

A Minecraft mod that allows players to fully customize tooltip appearance with custom textures, colors, and layouts.

![Example](https://via.placeholder.com/800x400?text=Tooltip+Preview)

## Features

- 🎨 Customizable tooltip backgrounds with gradient colors
- 🖼️ Support for custom texture fragments
- 🌈 Per-edge border color control with gradient effects
- 📦 Per-item or per-mod tooltip styling
- 🔄 Live reload configuration without restarting

## Requirements

- Minecraft 1.7.10
- Forge
- GTNH 2.8.0+ (for versions 1.1.4+)

## Installation

1. Download the latest release from [Releases](https://github.com/yourusername/BetterTooltipBox/releases)
2. Place the `.jar` file in your `mods/` folder
3. Launch Minecraft

## Configuration

The configuration file is located at:
```
.minecraft/config/BetterTooltipBox/config.json
```

After making changes, reload the configuration in-game with:
```
/bettertooltipbox reload
```

---

## Configuration File Structure

### Root Object

```json
{
  "Enable_SelectionBox": true,
  "Enable_TooltipsOverwrite": false,
  "TooltipsTextureList": {
    "defaultTexture": { ... }
  },
  "SpecialItemList": {
    "textureName": ["modid:itemname:meta"]
  }
}
```

| Field | Type | Description |
|-------|------|-------------|
| `Enable_SelectionBox` | `boolean` | Enable/disable block selection box rendering |
| `Enable_TooltipsOverwrite` | `boolean` | Allow overwriting existing tooltip textures |
| `TooltipsTextureList` | `object` | Map of texture definitions (key = texture name) |
| `SpecialItemList` | `object` | Map of item-specific texture assignments |

---

## Tooltip Texture Definition

Each texture in `TooltipsTextureList` follows this structure:

```json
{
  "TextureName": "defaultTexture",
  "ModId": "bettertooltipbox",
  "ResourceLocation": "bettertooltipbox:gui/GregTech.png",
  "TextureSize": [256, 256],
  "BackgroundColor": {
    "StartColor": [147, 112, 219, 180],
    "EndColor": [147, 112, 219, 180]
  },
  "LineColor": {
    "Top": {
      "StartColor": [205, 165, 100, 255],
      "EndColor": [205, 165, 100, 255]
    },
    "Bottom": { ... },
    "Left": { ... },
    "Right": { ... },
    "Center": { ... }
  },
  "FragmentList": [
    {
      "X": 0,
      "Y": 0,
      "Width": 16,
      "Height": 16,
      "Offset": [-1, -1]
    }
  ]
}
```

---

## Field Reference

### TextureName
**Type:** `string`
**Required:** Yes
**Description:** Unique identifier for this texture definition. Used to reference this texture in `SpecialItemList`.

**Example:**
```json
"TextureName": "myCustomTooltip"
```

---

### ModId
**Type:** `string`
**Required:** No
**Description:** Mod ID to automatically apply this texture to all items from that mod.

**Example:**
```json
"ModId": "gregtech"
```

---

### ResourceLocation
**Type:** `string`
**Required:** Yes
**Description:** Path to the texture file in the resource pack format. Must follow Minecraft's resource location format: `modid:path/to/texture.png`

**Notes:**
- Textures must be placed in a resource pack
- Cannot directly reference files in the config directory

**Example:**
```json
"ResourceLocation": "bettertooltipbox:gui/GregTech.png"
```

---

### TextureSize
**Type:** `[width, height]`
**Required:** Yes
**Description:** Dimensions of the source texture file in pixels.

**Example:**
```json
"TextureSize": [256, 256]
```

---

### BackgroundColor
**Type:** `object`
**Required:** Yes
**Description:** Defines the tooltip background with vertical gradient support.

**Structure:**
```json
{
  "StartColor": [R, G, B, A],
  "EndColor": [R, G, B, A]
}
```

- `StartColor`: Top edge color
- `EndColor`: Bottom edge color
- Each channel ranges from 0-255
- `A` (alpha) controls transparency: 0 = fully transparent, 255 = fully opaque

**Examples:**

Solid purple background (70% opacity):
```json
"BackgroundColor": {
  "StartColor": [147, 112, 219, 180],
  "EndColor": [147, 112, 219, 180]
}
```

Gradient from dark blue (top) to black (bottom):
```json
"BackgroundColor": {
  "StartColor": [25, 25, 112, 200],
  "EndColor": [0, 0, 0, 200]
}
```

Fully transparent background:
```json
"BackgroundColor": {
  "StartColor": [0, 0, 0, 0],
  "EndColor": [0, 0, 0, 0]
}
```

---

### LineColor
**Type:** `object`
**Required:** Yes
**Description:** Defines colors for all border edges. Each edge supports horizontal/vertical gradients.

**Structure:**
```json
{
  "Top": { "StartColor": [R, G, B, A], "EndColor": [R, G, B, A] },
  "Bottom": { "StartColor": [R, G, B, A], "EndColor": [R, G, B, A] },
  "Left": { "StartColor": [R, G, B, A], "EndColor": [R, G, B, A] },
  "Right": { "StartColor": [R, G, B, A], "EndColor": [R, G, B, A] },
  "Center": { "StartColor": [R, G, B, A], "EndColor": [R, G, B, A] }
}
```

| Edge | Gradient Direction | Description |
|------|-------------------|-------------|
| `Top` | Left → Right | Top border (1px tall) |
| `Bottom` | Left → Right | Bottom border (1px tall) |
| `Left` | Top → Bottom | Left border (1px wide) |
| `Right` | Top → Bottom | Right border (1px wide) |
| `Center` | Left → Right | Horizontal divider line between item name and description |

**Example - Golden borders:**
```json
"LineColor": {
  "Top": {
    "StartColor": [205, 165, 100, 255],
    "EndColor": [205, 165, 100, 255]
  },
  "Bottom": {
    "StartColor": [205, 165, 100, 255],
    "EndColor": [205, 165, 100, 255]
  },
  "Left": {
    "StartColor": [205, 165, 100, 255],
    "EndColor": [205, 165, 100, 255]
  },
  "Right": {
    "StartColor": [205, 165, 100, 255],
    "EndColor": [205, 165, 100, 255]
  },
  "Center": {
    "StartColor": [205, 165, 100, 255],
    "EndColor": [205, 165, 100, 255]
  }
}
```

**Example - Gradient borders (fade to transparent at edges):**
```json
"LineColor": {
  "Top": {
    "StartColor": [255, 255, 255, 0],
    "EndColor": [255, 255, 255, 255]
  },
  "Bottom": {
    "StartColor": [255, 255, 255, 255],
    "EndColor": [255, 255, 255, 0]
  },
  "Left": {
    "StartColor": [255, 255, 255, 0],
    "EndColor": [255, 255, 255, 255]
  },
  "Right": {
    "StartColor": [255, 255, 255, 255],
    "EndColor": [255, 255, 255, 0]
  },
  "Center": {
    "StartColor": [100, 100, 100, 255],
    "EndColor": [100, 100, 100, 255]
  }
}
```

---

### FragmentList
**Type:** `array` of `Fragment` objects
**Required:** No (can be empty array `[]`)
**Description:** List of texture fragments to overlay on the tooltip. Used for decorative elements like corners, borders, or logos.

Each fragment is a rectangular region cropped from the source texture and positioned on the tooltip.

**Fragment Object Structure:**
```json
{
  "X": 0,
  "Y": 0,
  "Width": 16,
  "Height": 16,
  "Offset": [0, 0]
}
```

| Field | Type | Description |
|-------|------|-------------|
| `X` | `number` | X coordinate in the source texture (pixels from left) |
| `Y` | `number` | Y coordinate in the source texture (pixels from top) |
| `Width` | `number` | Width of the cropped region (pixels) |
| `Height` | `number` | Height of the cropped region (pixels) |
| `Offset` | `[x, y]` | Position offset from the corner `[-1, -1]` = 1px inward from top-left corner |

**Example - Corner decorations:**

4 small 1x1 pixel fragments, each inset 1 pixel from the corners:
```json
"FragmentList": [
  {
    "X": 0,
    "Y": 0,
    "Width": 1,
    "Height": 1,
    "Offset": [-1, -1]
  },
  {
    "X": 0,
    "Y": 0,
    "Width": 1,
    "Height": 1,
    "Offset": [1, -1]
  },
  {
    "X": 0,
    "Y": 0,
    "Width": 1,
    "Height": 1,
    "Offset": [-1, 1]
  },
  {
    "X": 0,
    "Y": 0,
    "Width": 1,
    "Height": 1,
    "Offset": [1, 1]
  }
]
```

**Example - Logo at top center:**
```json
"FragmentList": [
  {
    "X": 0,
    "Y": 0,
    "Width": 64,
    "Height": 16,
    "Offset": [0, 0]
  }
]
```

**Tips:**
- Use small 1x1 fragments for subtle corner accents
- Negative offset values move the fragment outward from the corner
- Positive offset values move the fragment inward from the corner
- Leave `FragmentList` empty (`[]`) for a clean, texture-less tooltip

---

## Complete Configuration Examples

### Example 1: Purple Background with Golden Borders

```json
{
  "Enable_SelectionBox": true,
  "Enable_TooltipsOverwrite": false,
  "TooltipsTextureList": {
    "defaultTexture": {
      "TextureName": "defaultTexture",
      "ResourceLocation": "bettertooltipbox:gui/GregTech.png",
      "TextureSize": [256, 256],
      "BackgroundColor": {
        "StartColor": [147, 112, 219, 180],
        "EndColor": [147, 112, 219, 180]
      },
      "LineColor": {
        "Top": {
          "StartColor": [205, 165, 100, 255],
          "EndColor": [205, 165, 100, 255]
        },
        "Bottom": {
          "StartColor": [205, 165, 100, 255],
          "EndColor": [205, 165, 100, 255]
        },
        "Left": {
          "StartColor": [205, 165, 100, 255],
          "EndColor": [205, 165, 100, 255]
        },
        "Right": {
          "StartColor": [205, 165, 100, 255],
          "EndColor": [205, 165, 100, 255]
        },
        "Center": {
          "StartColor": [205, 165, 100, 255],
          "EndColor": [205, 165, 100, 255]
        }
      },
      "FragmentList": [
        {
          "X": 0,
          "Y": 0,
          "Width": 1,
          "Height": 1,
          "Offset": [-1, -1]
        },
        {
          "X": 0,
          "Y": 0,
          "Width": 1,
          "Height": 1,
          "Offset": [1, -1]
        },
        {
          "X": 0,
          "Y": 0,
          "Width": 1,
          "Height": 1,
          "Offset": [-1, 1]
        },
        {
          "X": 0,
          "Y": 0,
          "Width": 1,
          "Height": 1,
          "Offset": [1, 1]
        }
      ]
    }
  },
  "SpecialItemList": {}
}
```

### Example 2: Transparent Background with White Border

```json
{
  "Enable_SelectionBox": true,
  "Enable_TooltipsOverwrite": false,
  "TooltipsTextureList": {
    "defaultTexture": {
      "TextureName": "defaultTexture",
      "ResourceLocation": "bettertooltipbox:gui/GregTech.png",
      "TextureSize": [256, 256],
      "BackgroundColor": {
        "StartColor": [0, 0, 0, 0],
        "EndColor": [0, 0, 0, 0]
      },
      "LineColor": {
        "Top": {
          "StartColor": [255, 255, 255, 255],
          "EndColor": [255, 255, 255, 255]
        },
        "Bottom": {
          "StartColor": [255, 255, 255, 255],
          "EndColor": [255, 255, 255, 255]
        },
        "Left": {
          "StartColor": [255, 255, 255, 255],
          "EndColor": [255, 255, 255, 255]
        },
        "Right": {
          "StartColor": [255, 255, 255, 255],
          "EndColor": [255, 255, 255, 255]
        },
        "Center": {
          "StartColor": [255, 255, 255, 128],
          "EndColor": [255, 255, 255, 128]
        }
      },
      "FragmentList": []
    }
  },
  "SpecialItemList": {}
}
```

### Example 3: Multiple Textures for Different Mods

```json
{
  "Enable_SelectionBox": true,
  "Enable_TooltipsOverwrite": false,
  "TooltipsTextureList": {
    "defaultTexture": {
      "TextureName": "defaultTexture",
      "ResourceLocation": "bettertooltipbox:gui/default.png",
      "TextureSize": [256, 256],
      "BackgroundColor": {
        "StartColor": [100, 100, 100, 200],
        "EndColor": [100, 100, 100, 200]
      },
      "LineColor": {
        "Top": { "StartColor": [255, 255, 255, 255], "EndColor": [255, 255, 255, 255] },
        "Bottom": { "StartColor": [255, 255, 255, 255], "EndColor": [255, 255, 255, 255] },
        "Left": { "StartColor": [255, 255, 255, 255], "EndColor": [255, 255, 255, 255] },
        "Right": { "StartColor": [255, 255, 255, 255], "EndColor": [255, 255, 255, 255] },
        "Center": { "StartColor": [255, 255, 255, 255], "EndColor": [255, 255, 255, 255] }
      },
      "FragmentList": []
    },
    "gregTechTooltip": {
      "TextureName": "gregTechTooltip",
      "ModId": "gregtech",
      "ResourceLocation": "bettertooltipbox:gui/GregTech.png",
      "TextureSize": [256, 256],
      "BackgroundColor": {
        "StartColor": [0, 100, 200, 180],
        "EndColor": [0, 50, 100, 180]
      },
      "LineColor": {
        "Top": { "StartColor": [0, 200, 255, 255], "EndColor": [0, 200, 255, 255] },
        "Bottom": { "StartColor": [0, 200, 255, 255], "EndColor": [0, 200, 255, 255] },
        "Left": { "StartColor": [0, 200, 255, 255], "EndColor": [0, 200, 255, 255] },
        "Right": { "StartColor": [0, 200, 255, 255], "EndColor": [0, 200, 255, 255] },
        "Center": { "StartColor": [0, 200, 255, 255], "EndColor": [0, 200, 255, 255] }
      },
      "FragmentList": []
    }
  },
  "SpecialItemList": {
    "gregTechTooltip": [
      "gregtech:gt.metaitem.01:32600"
    ]
  }
}
```

---

## Special Item List

The `SpecialItemList` allows you to assign specific textures to individual items.

**Format:**
```json
"SpecialItemList": {
  "textureName": [
    "modid:itemname:metadata"
  ]
}
```

**Example:**
```json
"SpecialItemList": {
  "epicTooltip": [
    "minecraft:diamond_sword:0",
    "minecraft:diamond_pickaxe:0"
  ],
  "rareTooltip": [
    "minecraft:gold_sword:0"
  ]
}
```

---

## Color Palette Reference

Here are some pre-made color schemes you can use:

### Royal Purple & Gold
```json
"BackgroundColor": {
  "StartColor": [147, 112, 219, 180],
  "EndColor": [147, 112, 219, 180]
},
"LineColor": {
  "Top": { "StartColor": [205, 165, 100, 255], "EndColor": [205, 165, 100, 255] }
  // ... (repeat for all edges)
}
```

### Dark Blue & Cyan
```json
"BackgroundColor": {
  "StartColor": [0, 30, 60, 200],
  "EndColor": [0, 15, 30, 200]
},
"LineColor": {
  "Top": { "StartColor": [0, 200, 255, 255], "EndColor": [0, 200, 255, 255] }
}
```

### Blood Red & Gold
```json
"BackgroundColor": {
  "StartColor": [139, 0, 0, 180],
  "EndColor": [80, 0, 0, 180]
},
"LineColor": {
  "Top": { "StartColor": [255, 215, 0, 255], "EndColor": [255, 215, 0, 255] }
}
```

### Forest Green & Brown
```json
"BackgroundColor": {
  "StartColor": [34, 139, 34, 180],
  "EndColor": [20, 80, 20, 180]
},
"LineColor": {
  "Top": { "StartColor": [139, 90, 43, 255], "EndColor": [139, 90, 43, 255] }
}
```

---

## Commands

| Command | Description |
|---------|-------------|
| `/bettertooltipbox reload` | Reload configuration without restarting Minecraft |

---

## Troubleshooting

### Tooltip appears but colors don't change
- Verify your JSON syntax is correct (use a JSON validator)
- Check that RGBA values are between 0-255
- Run `/bettertooltipbox reload` after editing

### Texture fragments don't appear
- Ensure `ResourceLocation` points to a valid texture file
- Verify the texture is in a loaded resource pack
- Check that `X`, `Y`, `Width`, `Height` are within the texture bounds

### Configuration file not found
- The config file is auto-generated on first launch
- Location: `.minecraft/config/BetterTooltipBox/config.json`
- If missing, launch the game once to generate it

### Changes don't apply to specific items
- Check `SpecialItemList` syntax
- Item format: `"modid:itemname:metadata"` (all lowercase)
- Use `/bettertooltipbox reload` after changes

---

## Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch
3. Follow existing code style
4. Test your changes thoroughly
5. Submit a pull request

---

## Credits

- Contributors: [See Contributors](https://github.com/xiaoxing2005/BetterTooltipBox/graphs/contributors)

---

## Support

- Issues: [GitHub Issues](https://github.com/xiaoxing2005/BetterTooltipBox/issues)
