package fi.dy.masa.tweakeroo.config;

import java.util.List;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;

public class Hotkeys
{
    public static final ConfigHotkey ACCURATE_BLOCK_PLACEMENT_IN        = new ConfigHotkey("accurateBlockPlacementInto",        "",     KeybindSettings.PRESS_ALLOWEXTRA, "The key to activate the accurate block placement\nmode/overlay for placing the block facing\ninto the clicked block face");
    public static final ConfigHotkey ACCURATE_BLOCK_PLACEMENT_REVERSE   = new ConfigHotkey("accurateBlockPlacementReverse",     "",     KeybindSettings.PRESS_ALLOWEXTRA, "The key to activate the accurate block placement\nmode/overlay for placing the block facing\nthe opposite way from what it would normally be");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_COLUMN   = new ConfigHotkey("破坏方块限制模式-列",     "",     "更改 破坏方块限制模式为 列 模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_DIAGONAL = new ConfigHotkey("破坏方块限制模式-对角线",   "",     "更改 破坏方块限制模式为 对角线 模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_FACE     = new ConfigHotkey("破坏方块限制模式-表面",       "",     "更改 破坏方块限制模式为 表面 模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_LAYER    = new ConfigHotkey("破坏方块限制模式-层",      "",     "更改 破坏方块限制模式为 层 模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_LINE     = new ConfigHotkey("破坏方块限制模式-线",       "",     "更改 破坏方块限制模式为 线 模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_PLANE    = new ConfigHotkey("破坏方块限制模式-平面",      "",     "更改 破坏方块限制模式为 平面 模式");
    public static final ConfigHotkey COPY_SIGN_TEXT                     = new ConfigHotkey("复制告示牌文本",                      "",     "从已放置的告示牌复制文本。该文本可与 告示牌信息复制 一起使用.");
    public static final ConfigHotkey ELYTRA_CAMERA                      = new ConfigHotkey("elytraCamera",                      "",     "The key to lock the current real player rotations, only allowing the\ninputs (mouse) to affect separate \"camera rotations\" used only for the rendering\nwhile this key is active.\nMeant for freely looking down/around while elytra flying straight.");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_ADJACENT  = new ConfigHotkey("flexibleBlockPlacementAdjacent",    "",     KeybindSettings.PRESS_ALLOWEXTRA, "The key to activate the flexible block placement\nmode/overlay for placing the block in an adjacent position");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_OFFSET    = new ConfigHotkey("flexibleBlockPlacementOffset",      "LEFT_CONTROL", KeybindSettings.PRESS_ALLOWEXTRA, "The key to activate the flexible block placement\nmode/overlay for placing the block in a\noffset or diagonal position");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_ROTATION  = new ConfigHotkey("flexibleBlockPlacementRotation",    "LEFT_ALT", KeybindSettings.PRESS_ALLOWEXTRA, "The key to activate the flexible block placement\nmode/overlay for placing the block with\na rotation/facing");
    public static final ConfigHotkey FLY_PRESET_1                       = new ConfigHotkey("飞行速度预设1",                        "",     "使用飞行速度预设1");
    public static final ConfigHotkey FLY_PRESET_2                       = new ConfigHotkey("飞行速度预设2",                        "",     "使用飞行速度预设2");
    public static final ConfigHotkey FLY_PRESET_3                       = new ConfigHotkey("飞行速度预设3",                        "",     "使用飞行速度预设3");
    public static final ConfigHotkey FLY_PRESET_4                       = new ConfigHotkey("飞行速度预设4",                        "",     "使用飞行速度预设4");
    public static final ConfigHotkey HOTBAR_SCROLL                      = new ConfigHotkey("hotbarScroll",                      "",     KeybindSettings.RELEASE_ALLOW_EXTRA, "The key to hold to allow scrolling the hotbar\nthrough the player inventory rows");
    public static final ConfigHotkey HOTBAR_SWAP_BASE                   = new ConfigHotkey("hotbarSwapBase",                    "",     KeybindSettings.PRESS_ALLOWEXTRA, "The base key to show the hotbar/inventory overlay");
    public static final ConfigHotkey HOTBAR_SWAP_1                      = new ConfigHotkey("hotbarSwap1",                       "",     "Swap the hotbar with the top-most inventory row");
    public static final ConfigHotkey HOTBAR_SWAP_2                      = new ConfigHotkey("hotbarSwap2",                       "",     "Swap the hotbar with the middle inventory row");
    public static final ConfigHotkey HOTBAR_SWAP_3                      = new ConfigHotkey("hotbarSwap3",                       "",     "Swap the hotbar with the bottom-most inventory row");
    public static final ConfigHotkey INVENTORY_PREVIEW                  = new ConfigHotkey("容器预览",                  "LEFT_ALT", KeybindSettings.PRESS_ALLOWEXTRA, "激活容器预览功能的按键");
    public static final ConfigHotkey OPEN_CONFIG_GUI                    = new ConfigHotkey("Mod设置界面",                     "X,C",  "打开Mod设置界面按键");
    public static final ConfigHotkey PLACEMENT_Y_MIRROR                 = new ConfigHotkey("placementYMirror",                  "",     KeybindSettings.PRESS_ALLOWEXTRA, "The key to mirror the targeted y-position within the block");
    public static final ConfigHotkey PLAYER_INVENTORY_PEEK              = new ConfigHotkey("playerInventoryPeek",               "",     KeybindSettings.PRESS_ALLOWEXTRA, "The key to activate the player inventory peek/preview feature");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_COLUMN  = new ConfigHotkey("快速放置模式-列",    "Z,3",  "更改 快速放置模式 为 列 模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_DIAGONAL= new ConfigHotkey("快速放置模式-对角线",  "Z,5",  "更改 快速放置模式 为 对角线 模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_FACE    = new ConfigHotkey("快速放置模式-表面",      "Z,2",  "更改 快速放置模式 为 表面 模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_LAYER   = new ConfigHotkey("快速放置模式-层",     "Z,6",  "更改 快速放置模式 为 层 模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_LINE    = new ConfigHotkey("快速放置模式-线",      "Z,4",  "更改 快速放置模式 为 线 模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_PLANE   = new ConfigHotkey("快速放置模式-平面",     "Z,1",  "更改 快速放置模式 为 平面 模式");
    public static final ConfigHotkey SKIP_ALL_RENDERING                 = new ConfigHotkey("切换跳过所有渲染",                  "",     "切换跳过所有渲染");
    public static final ConfigHotkey SKIP_WORLD_RENDERING               = new ConfigHotkey("切换跳过世界渲染",                "",     "切换跳过世界渲染");
    public static final ConfigHotkey TOOL_PICK                          = new ConfigHotkey("toolPick",                          "",     "工具开关->自动切换有效工具 的热键");
    public static final ConfigHotkey ZOOM_ACTIVATE                      = new ConfigHotkey("zoomActivate",                      "",     "Zoom activation hotkey");

    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            ACCURATE_BLOCK_PLACEMENT_IN,
            ACCURATE_BLOCK_PLACEMENT_REVERSE,
            BREAKING_RESTRICTION_MODE_COLUMN,
            BREAKING_RESTRICTION_MODE_DIAGONAL,
            BREAKING_RESTRICTION_MODE_FACE,
            BREAKING_RESTRICTION_MODE_LAYER,
            BREAKING_RESTRICTION_MODE_LINE,
            BREAKING_RESTRICTION_MODE_PLANE,
            COPY_SIGN_TEXT,
            ELYTRA_CAMERA,
            FLEXIBLE_BLOCK_PLACEMENT_ADJACENT,
            FLEXIBLE_BLOCK_PLACEMENT_OFFSET,
            FLEXIBLE_BLOCK_PLACEMENT_ROTATION,
            FLY_PRESET_1,
            FLY_PRESET_2,
            FLY_PRESET_3,
            FLY_PRESET_4,
            HOTBAR_SCROLL,
            HOTBAR_SWAP_BASE,
            HOTBAR_SWAP_1,
            HOTBAR_SWAP_2,
            HOTBAR_SWAP_3,
            INVENTORY_PREVIEW,
            OPEN_CONFIG_GUI,
            PLACEMENT_Y_MIRROR,
            PLAYER_INVENTORY_PEEK,
            PLACEMENT_RESTRICTION_MODE_COLUMN,
            PLACEMENT_RESTRICTION_MODE_DIAGONAL,
            PLACEMENT_RESTRICTION_MODE_FACE,
            PLACEMENT_RESTRICTION_MODE_LAYER,
            PLACEMENT_RESTRICTION_MODE_LINE,
            PLACEMENT_RESTRICTION_MODE_PLANE,
            SKIP_ALL_RENDERING,
            SKIP_WORLD_RENDERING,
            TOOL_PICK,
            ZOOM_ACTIVATE
    );
}
