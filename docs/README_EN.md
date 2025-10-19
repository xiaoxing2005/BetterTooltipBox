# BetterTooltipBox

[中文文档](README.md) | English Documentation

This mod modifies the in-game Tooltip box, allowing players to freely customize it with various exquisite textures according to a fixed image format.

**For GTNH 2.8.0 and above, please use v1.1.4 or higher.**

## Features

- 🎨 Customize Tooltip background color, with gradient support
- 🖼️ Support for custom texture fragment decorations
- 🌈 Independent color and gradient control for each border
- 📦 Set exclusive styles for specific items or entire mods
- 🔄 Hot-reload configuration without restarting the game

## Requirements

- Minecraft 1.7.10
- Forge
- GTNH 2.8.0+ (for version 1.1.4+)

## Installation

1. Download the latest version from [Releases](https://github.com/yourusername/BetterTooltipBox/releases)
2. Place the `.jar` file into the `mods/` folder
3. Launch Minecraft

## Configuration File

Configuration file location:

```
.minecraft/config/BetterTooltipBox/config.json
```

After modifying the configuration, use the following commands in-game to reload:

```
/bettertooltipbox save
/bettertooltipbox reload
```

---

## Configuration File Structure

### Root Object

```json
{
  "Enable_SelectionBox": true,
  "Enable_TooltipsOverwrite": false,
  "TooltipsTextureList":{
    "defaultTexture":{}
  },
  "SpecialItemList":{
    "textureName":["modid:itemname:meta"]
  }
}
```

| Field                      | Type      | Description                                               |
|----------------------------|-----------|-----------------------------------------------------------|
| `Enable_SelectionBox`      | `boolean` | Enable/disable block selection box rendering.             |
| `Enable_TooltipsOverwrite` | `boolean` | Allow overwriting existing Tooltip textures.              |
| `TooltipsTextureList`      | `object`  | List of Tooltip texture definitions (key = texture name). |
| `SpecialItemList`          | `object`  | Mapping table to assign textures to specific items.       |

---

## Tooltip Texture Definition

Each texture in `TooltipsTextureList` follows this structure:

```json
{
  "defaultTexture":{
    "TextureName": "defaultTexture",
    "ModId": "bettertooltipbox",
    "ResourceLocation": "bettertooltipbox:gui/GregTech.png",
    "TextureSize":[256, 256],
    "BackgroundColor": {
      "StartColor":[147, 112, 219, 180],
      "EndColor":[147, 112, 219, 180]
    },
    "LineColor": {
      "Top": {
        "StartColor":[205, 165, 100, 255],
        "EndColor":[205, 165, 100, 255]
      },
      "Bottom": {},
      "Left": {},
      "Right": {},
      "Center": {}
    },
    "FragmentList":{
      "Top_Center":{
        "X": 0,
        "Y": 0,
        "Width": 16,
        "Height": 16,
        "Offset":[-1, -1]
      }
    }
  }
}
```

---

## Field Descriptions

### TextureName

**Type:** `string`
**Required:** Yes
**Description:** A unique identifier for this texture definition, used to reference it in `SpecialItemList`.

**Example:**

```json
{
  "TextureName": "myCustomTooltip"
}
```

---

### ModId

**Type:** `string`
**Required:** No
**Description:** Specify a mod ID to automatically apply this texture to all items from that mod. The mod has a built-in GregTech Tooltip texture. To replace it, set `Enable_TooltipsOverwrite` to true and use the corresponding voltage tier name as the texture name.

**Example:**

```json
{
  "ModId": "gregtech"
}
```

---

### ResourceLocation

**Type:** `string`
**Required:** Yes
**Description:** The resource path to the texture file, which must follow the Minecraft resource location format: `modid:path/to/texture.png`

**Notes:**

- The texture must be placed in a resource pack.
- You cannot directly reference files in the config directory.

**Example:**

```json
{
  "ResourceLocation": "bettertooltipbox:gui/GregTech.png"
}
```

---

### TextureSize

**Type:** `[width, height]`
**Required:** Yes
**Description:** The pixel dimensions of the source texture file.

**Example:**

```json
{
  "TextureSize":[256, 256]
}
```

---

### BackgroundColor

**Type:** `object`
**Required:** Yes
**Description:** Defines the Tooltip background color, supporting a vertical gradient.

**Structure:**

```json
{
  "StartColor":["R", "G", "B", "A"],
  "EndColor":["R", "G", "B", "A"]
}
```

- `StartColor`: Top color
- `EndColor`: Bottom color
- Each channel value ranges from 0-255.
- `A` (Alpha) controls transparency: 0 = fully transparent, 255 = fully opaque.

**Example:**

Solid purple background (70% opacity):

```json
{
  "BackgroundColor":{
    "StartColor":[147, 112, 219, 180],
    "EndColor":[147, 112, 219, 180]
  }
}
```

Gradient from dark blue (top) to black (bottom):

```json
{
  "BackgroundColor":{
    "StartColor":[25, 25, 112, 200],
    "EndColor":[0, 0, 0, 200]
  }
}
```

Fully transparent background:

```json
{
  "BackgroundColor":{
    "StartColor":[0, 0, 0, 0],
    "EndColor":[0, 0, 0, 0]
  }
}
```

---

### LineColor (Border Color)

**Type:** `object`
**Required:** Yes
**Description:** Defines the color for all borders. Each border supports a horizontal/vertical gradient.

**Structure:**

```json
{
  "Top": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] },
  "Bottom": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] },
  "Left": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] },
  "Right": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] },
  "Center": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] }
}
```

| Border Position | Gradient Direction | Description                                       |
|-----------------|--------------------|---------------------------------------------------|
| `Top`           | Left → Right       | Top border (1 pixel high)                         |
| `Bottom`        | Left → Right       | Bottom border (1 pixel high)                      |
| `Left`          | Top → Bottom       | Left border (1 pixel wide)                        |
| `Right`         | Top → Bottom       | Right border (1 pixel wide)                       |
| `Center`        | Left → Right       | Horizontal separator between item name and description |

**Example - Gold Border:**

```json
{
  "LineColor":{
    "Top":{
      "StartColor":[205, 165, 100, 255],
      "EndColor":[205, 165, 100, 255]
    },
    "Bottom":{
      "StartColor":[205, 165, 100, 255],
      "EndColor":[205, 165, 100, 255]
    },
    "Left":{
      "StartColor":[205, 165, 100, 255],
      "EndColor":[205, 165, 100, 255]
    },
    "Right":{
      "StartColor":[205, 165, 100, 255],
      "EndColor":[205, 165, 100, 255]
    },
    "Center":{
      "StartColor":[205, 165, 100, 255],
      "EndColor":[205, 165, 100, 255]
    }
  }
}
```

**Example - Gradient Border (fading to transparent at edges):**

```json
{
  "LineColor":{
    "Top": {
      "StartColor":[255, 255, 255, 0],
      "EndColor":[255, 255, 255, 255]
    },
    "Bottom":{
      "StartColor":[255, 255, 255, 255],
      "EndColor":[255, 255, 255, 0]
    },
    "Left":{
      "StartColor":[255, 255, 255, 0],
      "EndColor":[255, 255, 255, 255]
    },
    "Right": {
      "StartColor":[255, 255, 255, 255],
      "EndColor":[255, 255, 255, 0]
    },
    "Center":{
      "StartColor":[100, 100, 100, 255],
      "EndColor":[100, 100, 100, 255]
    }
  }
}
```

---

### FragmentList (Texture Fragment List)

**Type:** `array`, containing multiple `Fragment` objects
**Required:** No (can be an empty object `{}`, optional types are `Top_Left`, `Bottom_Left`, `Top_Right`, `Bottom_Right`, `Top_Center`, `Bottom_Center`, where `Top_Center` and `Bottom_Center` will be forced to the center based on the texture width)
**Description:** A list of texture fragments overlaid on the Tooltip, used for decorative elements like corners, borders, or logos.

Each fragment is a rectangular area cropped from the source texture and placed at a specified position on the Tooltip.

**Fragment Object Structure:**

```json
{
  "Top_Center":{
    "X": 0,
    "Y": 0,
    "Width": 16,
    "Height": 16,
    "Offset": [0, 0]
  }
}
```

| Field  | Type     | Description                                                          |
|--------|----------|----------------------------------------------------------------------|
| `X`    | `number` | X coordinate in the source texture (pixels from the left)            |
| `Y`    | `number` | Y coordinate in the source texture (pixels from the top)             |
| `Width`| `number` | Width of the cropped area (pixels)                                   |
| `Height`| `number` | Height of the cropped area (pixels)                                  |
| `Offset`| `[x, y]` | Positional offset relative to the corner, `[-1, -1]` = offset 1 pixel inwards from the top-left corner |

**Example - Four Corner Decorations:**

4 small 1x1 pixel fragments, each offset 1 pixel inwards from its corner:

```json
{
  "FragmentList":{
    "Top_Left":{
      "X": 0,
      "Y": 0,
      "Width": 1,
      "Height": 1,
      "Offset":[-1, -1]
    },
    "Bottom_Left":{
      "X": 0,
      "Y": 0,
      "Width": 1,
      "Height": 1,
      "Offset":[1, -1]
    },
    "Top_Right":{
      "X": 0,
      "Y": 0,
      "Width": 1,
      "Height": 1,
      "Offset":[-1, 1]
    },
    "Bottom_Right":{
      "X": 0,
      "Y": 0,
      "Width": 1,
      "Height": 1,
      "Offset":[1, 1]
    }
  }
}
```

**Example - Logo at the Top Center:**

```json
{
  "FragmentList":{
    "Top_Center":{
      "X": 0,
      "Y": 0,
      "Width": 64,
      "Height": 16,
      "Offset":[0, 0]
    }
  }
}
```

**Usage Tips:**

- Use small 1x1 fragments for fine corner details.
- Negative offset values move the fragment outwards from the corner.
- Positive offset values move the fragment inwards from the corner.
- Leave `FragmentList` empty (`{}`) for a clean, texture-free Tooltip.

---

## Full Configuration Examples

### Example 1: Purple Background + Gold Border

```json
{
  "Enable_SelectionBox": true,
  "Enable_TooltipsOverwrite": false,
  "TooltipsTextureList":{
    "defaultTexture":{
      "TextureName": "defaultTexture",
      "ResourceLocation": "bettertooltipbox:gui/GregTech.png",
      "TextureSize":[256, 256],
      "BackgroundColor":{
        "StartColor":[147, 112, 219, 180],
        "EndColor":[147, 112, 219, 180]
      },
      "LineColor":{
        "Top":{
          "StartColor":[205, 165, 100, 255],
          "EndColor":[205, 165, 100, 255]
        },
        "Bottom":{
          "StartColor":[205, 165, 100, 255],
          "EndColor":[205, 165, 100, 255]
        },
        "Left":{
          "StartColor":[205, 165, 100, 255],
          "EndColor":[205, 165, 100, 255]
        },
        "Right":{
          "StartColor":[205, 165, 100, 255],
          "EndColor":[205, 165, 100, 255]
        },
        "Center":{
          "StartColor":[205, 165, 100, 255],
          "EndColor":[205, 165, 100, 255]
        }
      },
      "FragmentList":{
        "Top_Left":{
          "X": 0,
          "Y": 0,
          "Width": 1,
          "Height": 1,
          "Offset":[-1, -1]
        },
        "Bottom_Left":{
          "X": 0,
          "Y": 0,
          "Width": 1,
          "Height": 1,
          "Offset":[1, -1]
        },
        "Top_Right":{
          "X": 0,
          "Y": 0,
          "Width": 1,
          "Height": 1,
          "Offset":[-1, 1]
        },
        "Bottom_Right":{
          "X": 0,
          "Y": 0,
          "Width": 1,
          "Height": 1,
          "Offset":[1, 1]
        }
      }
    }
  },
  "SpecialItemList":{}
}
```

### Example 2: Transparent Background + White Border

```json
{
  "Enable_SelectionBox": true,
  "Enable_TooltipsOverwrite": false,
  "TooltipsTextureList":{
    "defaultTexture":{
      "TextureName": "defaultTexture",
      "ResourceLocation": "bettertooltipbox:gui/GregTech.png",
      "TextureSize":[256, 256],
      "BackgroundColor":{
        "StartColor":[0, 0, 0, 0],
        "EndColor":[0, 0, 0, 0]
      },
      "LineColor":{
        "Top":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255]
        },
        "Bottom":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255]
        },
        "Left":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255]
        },
        "Right":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255]
        },
        "Center":{
          "StartColor":[255, 255, 255, 128],
          "EndColor":[255, 255, 255, 128]
        }
      },
      "FragmentList":{}
    }
  },
  "SpecialItemList":{}
}
```

### Example 3: Multiple Textures for Different Mods

```json
{
  "Enable_SelectionBox": true,
  "Enable_TooltipsOverwrite": true,
  "TooltipsTextureList": {
    "defaultTexture": {
      "TextureName": "defaultTexture",
      "ResourceLocation": "bettertooltipbox:gui/default.png",
      "TextureSize": [256, 256],
      "BackgroundColor": {
        "StartColor": [100, 100, 100, 200],
        "EndColor": [100, 100, 100, 200]
      },
      "LineColor":{
        "Top":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255] },
        "Bottom":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255] },
        "Left":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255] },
        "Right":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255] },
        "Center":{
          "StartColor":[255, 255, 255, 255],
          "EndColor":[255, 255, 255, 255] }
      },
      "FragmentList":{}
    },
    "ULV": {
      "TextureName": "ULV",
      "ModId": "gregtech",
      "ResourceLocation": "bettertooltipbox:gui/GregTech.png",
      "TextureSize":[256, 256],
      "BackgroundColor":{
        "StartColor":[0, 100, 200, 180],
        "EndColor":[0, 50, 100, 180]
      },
      "LineColor":{
        "Top":{
          "StartColor": [0, 200, 255, 255],
          "EndColor": [0, 200, 255, 255] },
        "Bottom":{
          "StartColor": [0, 200, 255, 255],
          "EndColor": [0, 200, 255, 255] },
        "Left":{
          "StartColor": [0, 200, 255, 255],
          "EndColor": [0, 200, 255, 255] },
        "Right":{
          "StartColor": [0, 200, 255, 255],
          "EndColor": [0, 200, 255, 255] },
        "Center":{
          "StartColor": [0, 200, 255, 255],
          "EndColor": [0, 200, 255, 255] }
      },
      "FragmentList":{}
    }
  },
  "SpecialItemList": {
    "ULV": [
      "gregtech:gt.metaitem.01:32600"
    ]
  }
}
```

---

## Special Item List

`SpecialItemList` allows you to assign specific textures to particular items.

**Format:**

```json
{
  "SpecialItemList":{
    "textureName":[
      "modid:itemname:metadata"
    ]
  }
}
```

**Example:**

```json
{
  "SpecialItemList":{
    "epicTooltip":[
      "minecraft:diamond_sword:0",
      "minecraft:diamond_pickaxe:0"
    ],
    "rareTooltip":[
      "minecraft:gold_sword:0"
    ]
  }
}
```

---

## Color Scheme Reference

Here are some preset color schemes for you to use:

### Royal Purple & Gold

```json
{
  "BackgroundColor":{
    "StartColor":[147, 112, 219, 180],
    "EndColor":[147, 112, 219, 180]
  },
  "LineColor":{
    "Top":{
      "StartColor":[205, 165, 100, 255],
      "EndColor":[205, 165, 100, 255]
    }
  }
}

```
// ... (repeat same settings for other borders)

### Deep Blue & Cyan

```json
{
  "BackgroundColor":{
    "StartColor":[0, 30, 60, 200],
    "EndColor":[0, 15, 30, 200]
  },
  "LineColor":{
    "Top":{
      "StartColor":[0, 200, 255, 255],
      "EndColor":[0, 200, 255, 255]
    }
  }
}
```

### Blood Red & Gold

```json
{
  "BackgroundColor":{
    "StartColor":[139, 0, 0, 180],
    "EndColor":[80, 0, 0, 180]
  },
  "LineColor":{
    "Top":{
      "StartColor":[255, 215, 0, 255],
      "EndColor":[255, 215, 0, 255]
    }
  }
}
```

### Forest Green & Brown

```json
{
  "BackgroundColor":{
    "StartColor":[34, 139, 34, 180],
    "EndColor":[20, 80, 20, 180]
  },
  "LineColor":{
    "Top":{
      "StartColor":[139, 90, 43, 255],
      "EndColor":[139, 90, 43, 255]
    }
  }
}
```

---

## In-Game Commands

| Command                                 | Description                                                                                                   |
|-----------------------------------------|---------------------------------------------------------------------------------------------------------------|
| `/bettertooltipbox add "TooltipName"`   | Adds the item in hand to the `SpecialItemList` and applies the specified Tooltip texture.                   |
| `/bettertooltipbox reload`              | Reloads the configuration file without restarting the game. Usually used with `/bettertooltipbox save`.       |
| `/bettertooltipbox save`                | Saves the configuration file without restarting the game. Usually used with `/bettertooltipbox reload`.       |
| `/bettertooltipbox reload`              | Reloads the configuration file without restarting the game. Usually used with `/bettertooltipbox save`.       |

---

## FAQ

### The Tooltip is displayed, but the color hasn't changed.

- Check if the JSON syntax is correct (you can use an online JSON validator).
- Confirm that RGBA values are within the 0-255 range.
- Run `/bettertooltipbox save` and `/bettertooltipbox reload` after editing.

### Texture fragments are not showing.

- Confirm that `ResourceLocation` points to a valid texture file.
- Verify that the texture is placed in a loaded resource pack.
- Check if `X`, `Y`, `Width`, and `Height` are within the texture's bounds.

### Cannot find the configuration file.

- The configuration file is generated automatically on the first launch.
- Location: `.minecraft/config/BetterTooltipBox/config.json`
- If it's missing, launching the game once will generate it.

### Changes to a specific item are not taking effect.

- Check the `SpecialItemList` syntax.
- Item format: `"modid:itemname:metadata"` (all lowercase).
- Use `/bettertooltipbox save` and `/bettertooltipbox reload` after making changes.

---

## Contribution Guidelines

Contributions are welcome! Please follow these guidelines:

1. Fork this repository.
2. Create a feature branch.
3. Adhere to the existing code style.
4. Thoroughly test your changes.
5. Submit a Pull Request.

---

## Acknowledgements

- Contributors: [View contributor list](https://github.com/xiaoxing2005/BetterTooltipBox/graphs/contributors)

---

## Support and Feedback

- For issues: [GitHub Issues](https://github.com/xiaoxing2005/BetterTooltipBox/issues)
