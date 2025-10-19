# BetterTooltipBox

[English Documentation](docs/README_EN.md) | 中文文档

本 Mod 修改了游戏内 Tooltip 提示框，玩家可以自由按照固定的图片格式修改各种各样精美的贴图。

**GTNH 2.8.0 及以上请使用 v1.1.4 或更高版本**

## 功能特性

- 🎨 自定义 Tooltip 背景色，支持渐变效果
- 🖼️ 支持自定义贴图碎片装饰
- 🌈 独立控制每条边框的颜色和渐变
- 📦 可为特定物品或整个模组设置专属样式
- 🔄 热重载配置，无需重启游戏

## 环境要求

- Minecraft 1.7.10
- Forge
- GTNH 2.8.0+（适用于 1.1.4+ 版本）

## 安装方法

1. 从 [Releases](https://github.com/yourusername/BetterTooltipBox/releases) 下载最新版本
2. 将 `.jar` 文件放入 `mods/` 文件夹
3. 启动 Minecraft

## 配置文件

配置文件位置：

```
.minecraft/config/BetterTooltipBox/config.json
```

修改配置后，在游戏内使用以下命令重载：

```
/bettertooltipbox save
/bettertooltipbox reload
```

---

## 配置文件结构

### 根对象

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

| 字段                         | 类型        | 说明                        |
|----------------------------|-----------|---------------------------|
| `Enable_SelectionBox`      | `boolean` | 启用/禁用方块选择框渲染              |
| `Enable_TooltipsOverwrite` | `boolean` | 允许覆盖已有的 Tooltip 材质        |
| `TooltipsTextureList`      | `object`  | Tooltip 材质定义列表（键名 = 材质名称） |
| `SpecialItemList`          | `object`  | 为特定物品指定材质的映射表             |

---

## Tooltip 材质定义

`TooltipsTextureList` 中的每个材质遵循以下结构：

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

## 字段说明

### TextureName（材质名称）

**类型：** `string`
**必填：** 是
**说明：** 该材质定义的唯一标识符，用于在 `SpecialItemList` 中引用此材质。

**示例：**

```json
{
  "TextureName": "myCustomTooltip"
}
```

---

### ModId（模组 ID）

**类型：** `string`
**必填：** 否
**说明：** 指定模组 ID，自动将此材质应用到该模组的所有物品。mod内置了gregtech的Tooltip材质，如需替换请将`Enable_TooltipsOverwrite`设为true并直接以对应电压等级作为材质名称。

**示例：**

```json
{
  "ModId": "gregtech"
}
```

---

### ResourceLocation（资源位置）

**类型：** `string`
**必填：** 是
**说明：** 贴图文件的资源路径，必须遵循 Minecraft 资源定位格式：`modid:path/to/texture.png`

**注意事项：**

- 贴图必须放置在资源包中
- 无法直接引用 config 目录下的文件

**示例：**

```json
{
  "ResourceLocation": "bettertooltipbox:gui/GregTech.png"
}
```

---

### TextureSize（贴图尺寸）

**类型：** `[width, height]`
**必填：** 是
**说明：** 源贴图文件的像素尺寸。

**示例：**

```json
{
  "TextureSize":[256, 256]
}
```

---

### BackgroundColor（背景颜色）

**类型：** `object`
**必填：** 是
**说明：** 定义 Tooltip 背景色，支持垂直渐变。

**结构：**

```json
{
  "StartColor":["R", "G", "B", "A"],
  "EndColor":["R", "G", "B", "A"]
}
```

- `StartColor`：顶部颜色
- `EndColor`：底部颜色
- 每个通道取值范围 0-255
- `A`（Alpha）控制透明度：0 = 完全透明，255 = 完全不透明

**示例：**

纯色紫色背景（70% 不透明度）：

```json
{
  "BackgroundColor":{
    "StartColor":[147, 112, 219, 180],
    "EndColor":[147, 112, 219, 180]
  }
}
```

从深蓝（顶部）到黑色（底部）的渐变：

```json
{
  "BackgroundColor":{
    "StartColor":[25, 25, 112, 200],
    "EndColor":[0, 0, 0, 200]
  }
}
```

完全透明背景：

```json
{
  "BackgroundColor":{
    "StartColor":[0, 0, 0, 0],
    "EndColor":[0, 0, 0, 0]
  }
}
```

---

### LineColor（边框颜色）

**类型：** `object`
**必填：** 是
**说明：** 定义所有边框的颜色，每条边支持水平/垂直渐变。

**结构：**

```json
{
  "Top": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] },
  "Bottom": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] },
  "Left": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] },
  "Right": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] },
  "Center": { "StartColor": ["R", "G", "B", "A"], "EndColor": ["R", "G", "B", "A"] }
}
```

| 边框位置 | 渐变方向 | 说明 |
|---------|---------|------|
| `Top` | 左 → 右 | 顶部边框（1 像素高）|
| `Bottom` | 左 → 右 | 底部边框（1 像素高）|
| `Left` | 上 → 下 | 左侧边框（1 像素宽）|
| `Right` | 上 → 下 | 右侧边框（1 像素宽）|
| `Center` | 左 → 右 | 物品名称和描述之间的水平分割线 |

**示例 - 金色边框：**

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

**示例 - 渐变边框（边缘淡出为透明）：**

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

### FragmentList（贴图碎片列表）

**类型：** `array`，包含多个 `Fragment` 对象
**必填：** 否（可以为空数组 `{}`,可选类型有`Top_Left`,`Bottom_Left`,`Top_Right`,`Bottom_Right`,`Top_Center`,`Bottom_Center`,其中`Top_Center`,`Bottom_Center`会根据纹理宽度强制居中）
**说明：** 叠加在 Tooltip 上的贴图碎片列表，用于装饰性元素，如角落、边框或 Logo。

每个碎片是从源贴图中裁剪的矩形区域，放置在 Tooltip 的指定位置。

**碎片对象结构：**

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

| 字段 | 类型 | 说明 |
|------|------|------|
| `X` | `number` | 源贴图中的 X 坐标（从左侧开始的像素数）|
| `Y` | `number` | 源贴图中的 Y 坐标（从顶部开始的像素数）|
| `Width` | `number` | 裁剪区域的宽度（像素）|
| `Height` | `number` | 裁剪区域的高度（像素）|
| `Offset` | `[x, y]` | 相对于角落的位置偏移，`[-1, -1]` = 从左上角向内偏移 1 像素 |

**示例 - 四角装饰：**

4 个小的 1x1 像素碎片，每个从角落向内偏移 1 像素：

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

**示例 - 顶部中心的 Logo：**

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

**使用技巧：**

- 使用小的 1x1 碎片可以实现精细的角落点缀
- 负偏移值会将碎片向角落外侧移动
- 正偏移值会将碎片向角落内侧移动
- 留空 `FragmentList`（`{}`）可获得干净无贴图的 Tooltip

---

## 完整配置示例

### 示例 1：紫色背景 + 金色边框

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

### 示例 2：透明背景 + 白色边框

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

### 示例 3：为不同模组配置多个材质

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

## 特殊物品列表

`SpecialItemList` 允许你为特定物品指定专属材质。

**格式：**

```json
{
  "SpecialItemList":{
    "textureName":[
      "modid:itemname:metadata"
    ]
  }
}
```

**示例：**

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

## 配色方案参考

以下是一些预设配色方案供你使用：

### 皇家紫金

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
// ... (其他边框重复相同设置)

### 深蓝青色

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

### 血红金色

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

### 森林绿棕

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

## 游戏内命令

| 命令                                    | 说明                                                |
|---------------------------------------|---------------------------------------------------|
| `/bettertooltipbox add “TooltipName”` | 将手中的物品添加进`SpecialItemList`中并使用指定的Tooltip材质        |
| `/bettertooltipbox reload`            | 重载配置文件，无需重启游戏，一般需要与`/bettertooltipbox save`配合使用   |
| `/bettertooltipbox save`              | 保存配置文件，无需重启游戏，一般需要与`/bettertooltipbox reload`配合使用 |
| `/bettertooltipbox reload`            | 重载配置文件，无需重启游戏，一般需要与`/bettertooltipbox save`配合使用   |

---

## 常见问题

### Tooltip 显示了但颜色没有改变

- 检查 JSON 语法是否正确（可使用在线 JSON 验证器）
- 确认 RGBA 值在 0-255 范围内
- 编辑后运行 `/bettertooltipbox save`与`/bettertooltipbox reload`

### 贴图碎片没有显示

- 确认 `ResourceLocation` 指向有效的贴图文件
- 验证贴图已放置在已加载的资源包中
- 检查 `X`、`Y`、`Width`、`Height` 是否在贴图范围内

### 找不到配置文件

- 配置文件在首次启动时自动生成
- 位置：`.minecraft/config/BetterTooltipBox/config.json`
- 如果缺失，启动一次游戏即可生成

### 对特定物品的修改没有生效

- 检查 `SpecialItemList` 语法
- 物品格式：`"modid:itemname:metadata"`（全小写）
- 修改后使用 `/bettertooltipbox save`与`/bettertooltipbox reload`

---

## 贡献指南

欢迎贡献代码！请遵循以下准则：

1. Fork 本仓库
2. 创建功能分支
3. 遵循现有代码风格
4. 充分测试你的修改
5. 提交 Pull Request

---

## 致谢

- 贡献者：[查看贡献者列表](https://github.com/xiaoxing2005/BetterTooltipBox/graphs/contributors)

---

## 支持与反馈

- 问题反馈：[GitHub Issues](https://github.com/xiaoxing2005/BetterTooltipBox/issues)
