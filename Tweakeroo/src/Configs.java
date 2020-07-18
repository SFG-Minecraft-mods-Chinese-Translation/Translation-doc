package fi.dy.masa.tweakeroo.config;

import java.io.File;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.HudAlignment;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import fi.dy.masa.malilib.config.options.ConfigColor;
import fi.dy.masa.malilib.config.options.ConfigDouble;
import fi.dy.masa.malilib.config.options.ConfigInteger;
import fi.dy.masa.malilib.config.options.ConfigOptionList;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.malilib.config.options.ConfigStringList;
import fi.dy.masa.malilib.util.ActiveMode;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;
import fi.dy.masa.malilib.util.restrictions.UsageRestriction.ListType;
import fi.dy.masa.tweakeroo.Reference;
import fi.dy.masa.tweakeroo.tweaks.MiscTweaks;
import fi.dy.masa.tweakeroo.tweaks.PlacementTweaks;
import fi.dy.masa.tweakeroo.util.InventoryUtils;
import fi.dy.masa.tweakeroo.util.PlacementRestrictionMode;
import fi.dy.masa.tweakeroo.util.SnapAimMode;

public class Configs implements IConfigHandler
{
    private static final String CONFIG_FILE_NAME = Reference.MOD_ID + ".json";

    public static class Generic
    {
        public static final ConfigInteger       AFTER_CLICKER_CLICK_COUNT           = new ConfigInteger     ("放置后右键次数",  1, 1, 32, "工具开关 -> 放置后右键 功能配置");
        public static final ConfigDouble        BLOCK_REACH_DISTANCE                = new ConfigDouble      ("最大放置距离上限", 4.5, 0, 8, "工具开关 -> 调整最大放置距离 功能设置");
        public static final ConfigInteger       BREAKING_GRID_SIZE                  = new ConfigInteger     ("网格破坏模式大小", 3, 1, 1000, "工具开关 -> 网格破坏模式 功能设置\n按住设置的热键+滑动滚轮\n即可快速调整该值");
        public static final ConfigOptionList    BREAKING_RESTRICTION_MODE           = new ConfigOptionList  ("方块破坏限制模式设置", PlacementRestrictionMode.LINE, "工具开关 -> 方块破坏限制模式 功能设置\n选择你要使用的方块破坏限制模式（热键可选）");
        public static final ConfigColor         CHAT_BACKGROUND_COLOR               = new ConfigColor       ("聊天消息颜色", "#80000000", "工具开关 -> 覆盖默认聊天消息颜色 功能设置\n在此处设置你想要的颜色");
        public static final ConfigString        CHAT_TIME_FORMAT                    = new ConfigString      ("时间戳格式设置", "[HH:mm:ss]", "工具开关 -> 聊天信息时间戳 相关设置\n你可以做出一些你需要的更改");
        public static final ConfigBoolean       CLIENT_PLACEMENT_ROTATION           = new ConfigBoolean     ("单人游戏和客户端放置轮换", true, "[机翻]启用单人游戏和客户端放置轮换，例如在没有Carpet mod的单人游戏中进行精确放置");
        public static final ConfigOptionList    ELYTRA_CAMERA_INDICATOR             = new ConfigOptionList  ("视角旋转相关设置", ActiveMode.WITH_KEY, "在视角旋转处于启用状态时渲染真实的俯仰角指示器");
        public static final ConfigInteger       FAST_BLOCK_PLACEMENT_COUNT          = new ConfigInteger     ("fastBlockPlacementCount", 2, 1, 16, "工具开关 -> 快速放置模式 功能设置\n每个游戏刻（tick)可放置的最大方块数");
        public static final ConfigInteger       FAST_LEFT_CLICK_COUNT               = new ConfigInteger     ("快速左键次数",  10, 1, 64, "每个游戏刻(tick)左键次数\n工具 -> 快速左键单击 功能配置");
        public static final ConfigInteger       FAST_RIGHT_CLICK_COUNT              = new ConfigInteger     ("快速右键次数", 10, 1, 64, "每个游戏刻(tick)右键次数\n工具 -> 快速右键单击 功能配置");
        public static final ConfigInteger       FILL_CLONE_LIMIT                    = new ConfigInteger     ("fill/clone上限", 10000000, 1, 1000000000, "工具开关 -> 更改fill/clone方块上限 功能配置\n在单人模式更改fill/clone方块上限数量");
        public static final ConfigColor         FLEXIBLE_PLACEMENT_OVERLAY_COLOR    = new ConfigColor       ("叠加方块中当前指向区域颜色", "#C03030F0", "叠加块中当前指向区域的颜色设置");
        public static final ConfigDouble        FLY_SPEED_PRESET_1                  = new ConfigDouble      ("飞行速度预设1", 0.01, 0, 4, "工具开关 -> 飞行速度 功能预设1");
        public static final ConfigDouble        FLY_SPEED_PRESET_2                  = new ConfigDouble      ("飞行速度预设2", 0.064, 0, 4, "工具开关 -> 飞行速度 功能预设2");
        public static final ConfigDouble        FLY_SPEED_PRESET_3                  = new ConfigDouble      ("飞行速度预设3", 0.128, 0, 4, "工具开关 -> 飞行速度 功能预设3");
        public static final ConfigDouble        FLY_SPEED_PRESET_4                  = new ConfigDouble      ("飞行速度预设4", 0.32, 0, 4, "工具开关 -> 飞行速度 功能预设4");
        public static final ConfigBoolean       FREE_CAMERA_MOTION_TOGGLE           = new ConfigBoolean     ("灵魂出窍相关设置", true, "如果启用，则切换开/关“灵魂出窍”模式也将自动切换开/关“灵魂出窍不影响肉体”功能");
        public static final ConfigInteger       GAMMA_OVERRIDE_VALUE                = new ConfigInteger     ("无限夜视覆盖使用伽马值", 16, 0, 1000, "工具开关 -> 无限夜视 功能设置\n在此设置用于覆盖原伽马值的新伽马值");
        public static final ConfigBoolean       HAND_RESTOCK_PRE                    = new ConfigBoolean     ("预先自动补货", true, "如果启用，则在一组物品用完之前会进行自动补货");
        public static final ConfigInteger       HOTBAR_SLOT_CYCLE_MAX               = new ConfigInteger     ("自动切换物品栏最大编号", 2, 1, 9, "工具开关 -> 自动切换物品栏 功能设置\n当当前物品栏超过设置的值时候\n会自动跳回第一个物品栏");
        public static final ConfigInteger       HOTBAR_SLOT_RANDOMIZER_MAX          = new ConfigInteger     ("随机切换物品栏最大编号", 5, 1, 9, "工具开关 -> 随机切换物品栏 功能设置在使用物品后从1到最大编号随机选中一个物品栏");
        public static final ConfigOptionList    HOTBAR_SWAP_OVERLAY_ALIGNMENT       = new ConfigOptionList  ("hotbarSwapOverlayAlignment热键交换", HudAlignment.BOTTOM_RIGHT, "物品栏交换覆盖的位置\n【工具开关->热键交换 相关设置】");
        public static final ConfigInteger       HOTBAR_SWAP_OVERLAY_OFFSET_X        = new ConfigInteger     ("hotbarSwapOverlayOffsetX热键交换", 4, "The horizontal offset of the hotbar swap overlay\n【工具开关->热键交换 相关设置】");
        public static final ConfigInteger       HOTBAR_SWAP_OVERLAY_OFFSET_Y        = new ConfigInteger     ("hotbarSwapOverlayOffsetY热键交换", 4, "The vertical offset of the hotbar swap overlay\n【工具开关->热键交换 相关设置】");
        public static final ConfigInteger       ITEM_SWAP_DURABILITY_THRESHOLD      = new ConfigInteger     ("itemSwapDurabilityThreshold物品交换", 20, 0, 10000, "This is the durability threshold (in uses left)\nfor the low-durability item swap feature.\nNote that items with low total durability will go lower\nand be swapped at 5%% left.\n【工具开关->热键交换 相关设置】");
        public static final ConfigBoolean       LAVA_VISIBILITY_OPTIFINE            = new ConfigBoolean     ("lavaVisibilityOptifineCompat", true, "工具开关 -> 岩浆夜视 的替代版本\n它与Optifine兼容（但有更多代码上的技巧）\nNessie的功劳.");
        public static final ConfigInteger       MAP_PREVIEW_SIZE                    = new ConfigInteger     ("地图预览大小", 160, 16, 512, "工具开关 -> 地图预览 功能设置\n预览地图的渲染大小");
        public static final ConfigInteger       PERIODIC_ATTACK_INTERVAL            = new ConfigInteger     ("定时攻击配置", 20, 0, Integer.MAX_VALUE, "工具开关 -> 定时攻击 功能配置\n在此设置隔多少游戏刻（tick)攻击一次\n注意>1 tick=0.05s");
        public static final ConfigInteger       PERIODIC_USE_INTERVAL               = new ConfigInteger     ("定时使用配置", 20, 0, Integer.MAX_VALUE, "工具开关 -> 定时攻击 功能配置\n在此设置隔多少游戏刻（tick)使用一次\n注意>1 tick=0.05s");
        public static final ConfigBoolean       PERMANENT_SNEAK_ALLOW_IN_GUIS       = new ConfigBoolean     ("permanentSneakAllowInGUIs", false, "[机翻]如果为true，则在打开GUI时，永久性的临时调整也将起作用");
        public static final ConfigInteger       PLACEMENT_GRID_SIZE                 = new ConfigInteger     ("placementGridSize", 3, 1, 1000, "The grid interval size for the grid placement mode.\nTo quickly adjust the value, scroll while\nholding down the tweak toggle keybind.");
        public static final ConfigInteger       PLACEMENT_LIMIT                     = new ConfigInteger     ("placementLimit", 3, 1, 10000, "The number of blocks you are able to place at maximum per\nright click, if tweakPlacementLimit is enabled.\nTo quickly adjust the value, scroll while\nholding down the tweak toggle keybind.");
        public static final ConfigOptionList    PLACEMENT_RESTRICTION_MODE          = new ConfigOptionList  ("placementRestrictionMode", PlacementRestrictionMode.FACE, "[机翻]要使用的展示位置限制模式（热键可选）");
        public static final ConfigBoolean       PLACEMENT_RESTRICTION_TIED_TO_FAST  = new ConfigBoolean     ("placementRestrictionTiedToFast", true, "[机翻]启用后，当您切换“快速放置”模式时，“放置限制”模式将切换开启/关闭状态。");
        public static final ConfigBoolean       POTION_WARNING_BENEFICIAL_ONLY      = new ConfigBoolean     ("仅警告正面药水效果消失", true, "仅警告正面药水效果用尽");
        public static final ConfigInteger       POTION_WARNING_THRESHOLD            = new ConfigInteger     ("药水效果警告值", 600, 1, 1000000, "通用开关 -> 药水效果耗尽警告\n当药水效果的剩余持续时间（以tick为单位）到设置值后将开始显示警告");
        public static final ConfigInteger       RENDER_LIMIT_ITEM                   = new ConfigInteger     ("最大物品渲染数", -1, -1, 10000, "通用开关 -> 限制每帧实体数 功能设置\n限制每帧渲染的物品实体的最大数量.\n请使用-1以禁用此限制。");
        public static final ConfigInteger       RENDER_LIMIT_XP_ORB                 = new ConfigInteger     ("最大经验球渲染数", -1, -1, 10000, "通用开关 -> 限制每帧实体数 功能设置\n限制每帧渲染的经验球实体的最大数量.\n请使用-1以禁用此限制");
        public static final ConfigBoolean       SHULKER_DISPLAY_BACKGROUND_COLOR    = new ConfigBoolean     ("潜影盒预览颜色", true, "使用盒子的染料颜色为潜影盒预览背景/纹理着色");
        public static final ConfigBoolean       SHULKER_DISPLAY_REQUIRE_SHIFT       = new ConfigBoolean     ("潜影盒预览需要按住shift", true, "潜影盒预览是否需要保持按住");
        public static final ConfigBoolean       SLOT_SYNC_WORKAROUND                = new ConfigBoolean     ("slotSyncWorkaround", true, "[机翻]这样可以防止服务器在快速使用的项目（例如快速）上覆盖持久性或堆栈大小。");
        public static final ConfigBoolean       SNAP_AIM_INDICATOR                  = new ConfigBoolean     ("渲染捕捉瞄准指示器", true, "是否渲染捕捉瞄准角指示器");
        public static final ConfigColor         SNAP_AIM_INDICATOR_COLOR            = new ConfigColor       ("对齐目标指示器背景的颜色", "#603030FF", "对齐目标指示器背景的颜色");
        public static final ConfigOptionList    SNAP_AIM_MODE                       = new ConfigOptionList  ("快速对齐模式", SnapAimMode.YAW, "快速对齐模式：偏航或俯仰，或两者");
        public static final ConfigBoolean       SNAP_AIM_PITCH_OVERSHOOT            = new ConfigBoolean     ("snapAimPitchOvershoot", false, "Whether or not to allow overshooting the pitch angle\nfrom the normal +/- 90 degrees up to +/- 180 degrees");
        public static final ConfigDouble        SNAP_AIM_PITCH_STEP                 = new ConfigDouble      ("snapAimPitchStep", 12.5, 0, 90, "The pitch angle step of the snap aim tweak");
        public static final ConfigDouble        SNAP_AIM_YAW_STEP                   = new ConfigDouble      ("snapAimYawStep", 45, 0, 360, "The yaw angle step of the snap aim tweak");
        public static final ConfigInteger       STRUCTURE_BLOCK_MAX_SIZE            = new ConfigInteger     ("结构方块最大保存上限", 128, 1, 256, "结构方块最大保存上限");
        public static final ConfigDouble        ZOOM_FOV                            = new ConfigDouble      ("zoomFov", 30, 0, 600, "The FOV value used for the zoom feature");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                CLIENT_PLACEMENT_ROTATION,
                FREE_CAMERA_MOTION_TOGGLE,
                LAVA_VISIBILITY_OPTIFINE,
                HAND_RESTOCK_PRE,
                PERMANENT_SNEAK_ALLOW_IN_GUIS,
                PLACEMENT_RESTRICTION_TIED_TO_FAST,
                POTION_WARNING_BENEFICIAL_ONLY,
                SHULKER_DISPLAY_BACKGROUND_COLOR,
                SHULKER_DISPLAY_REQUIRE_SHIFT,
                SLOT_SYNC_WORKAROUND,
                SNAP_AIM_INDICATOR,
                SNAP_AIM_PITCH_OVERSHOOT,

                BREAKING_RESTRICTION_MODE,
                ELYTRA_CAMERA_INDICATOR,
                PLACEMENT_RESTRICTION_MODE,
                HOTBAR_SWAP_OVERLAY_ALIGNMENT,
                SNAP_AIM_MODE,

                CHAT_TIME_FORMAT,
                CHAT_BACKGROUND_COLOR,
                FLEXIBLE_PLACEMENT_OVERLAY_COLOR,
                SNAP_AIM_INDICATOR_COLOR,

                AFTER_CLICKER_CLICK_COUNT,
                BLOCK_REACH_DISTANCE,
                BREAKING_GRID_SIZE,
                FAST_BLOCK_PLACEMENT_COUNT,
                FAST_LEFT_CLICK_COUNT,
                FAST_RIGHT_CLICK_COUNT,
                FILL_CLONE_LIMIT,
                FLY_SPEED_PRESET_1,
                FLY_SPEED_PRESET_2,
                FLY_SPEED_PRESET_3,
                FLY_SPEED_PRESET_4,
                GAMMA_OVERRIDE_VALUE,
                HOTBAR_SLOT_CYCLE_MAX,
                HOTBAR_SLOT_RANDOMIZER_MAX,
                HOTBAR_SWAP_OVERLAY_OFFSET_X,
                HOTBAR_SWAP_OVERLAY_OFFSET_Y,
                ITEM_SWAP_DURABILITY_THRESHOLD,
                MAP_PREVIEW_SIZE,
                PERIODIC_ATTACK_INTERVAL,
                PERIODIC_USE_INTERVAL,
                PLACEMENT_GRID_SIZE,
                PLACEMENT_LIMIT,
                POTION_WARNING_THRESHOLD,
                RENDER_LIMIT_ITEM,
                RENDER_LIMIT_XP_ORB,
                SNAP_AIM_PITCH_STEP,
                SNAP_AIM_YAW_STEP,
                STRUCTURE_BLOCK_MAX_SIZE,
                ZOOM_FOV
        );
    }

    public static class Fixes
    {
        public static final ConfigBoolean CLIENT_CHUNK_ENTITY_DUPE          = new ConfigBoolean("客户端实体欺骗修复", false, "修复当接受区块数据包时，客户端实际上复制了区块中的实体的bug");
        public static final ConfigBoolean ELYTRA_FIX                        = new ConfigBoolean("鞘翅修复", false, "Earthcomputer和Nessie对鞘翅使用/落地的修复");
        public static final ConfigBoolean PROFILER_CHART_FIX                = new ConfigBoolean("调试探查器修复", false, "[机翻]添加了针对调试探查器的修复程序，该修复程序在MC 1.14.4中被损坏");
        public static final ConfigBoolean RAVAGER_CLIENT_BLOCK_BREAK_FIX    = new ConfigBoolean("掠夺者破坏方块修复", false, "修复了掠夺者破坏客户端方块的问题，\n这会导致令人讨厌的幽灵方块/方块不同步");
        public static final ConfigBoolean TILE_UNLOAD_OPTIMIZATION          = new ConfigBoolean("方块实体加/卸载修复", false, "优化从>>世界<<列表中删除正在卸载的方块实体的操作.\n如果一次加载和/或卸载很多方块实体的话,\n可以大大提高性能.");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                CLIENT_CHUNK_ENTITY_DUPE,
                ELYTRA_FIX,
                PROFILER_CHART_FIX,
                RAVAGER_CLIENT_BLOCK_BREAK_FIX,
                TILE_UNLOAD_OPTIMIZATION
        );
    }

    public static class Lists
    {
        public static final ConfigOptionList FAST_PLACEMENT_ITEM_LIST_TYPE      = new ConfigOptionList("快速放置模式-限制类型", ListType.BLACKLIST, "快速放置模式的限制类型\nblacklist=禁用黑名单内物品\nwhitelist=仅可用白名单内物品");
        public static final ConfigStringList FAST_PLACEMENT_ITEM_BLACKLIST      = new ConfigStringList("快速放置模式-黑名单", ImmutableList.of("minecraft:ender_chest", "minecraft:white_shulker_box"), "如果快速放置模式限制类型设置为BlackList(黑名单），则不允许将这些项目用于快速放置模式");
        public static final ConfigStringList FAST_PLACEMENT_ITEM_WHITELIST      = new ConfigStringList("快速放置模式-白名单", ImmutableList.of(), "如果快速放置模式限制类型设置为Whitelist(白名单），则仅允许将这些项目用于快速放置模式");
        public static final ConfigOptionList FAST_RIGHT_CLICK_BLOCK_LIST_TYPE   = new ConfigOptionList("快速右键（方块）-限制类型", ListType.BLACKLIST, "快速右键（方块）的限制类型\nblacklist=禁用黑名单内物品\nwhitelist=仅可用白名单内物品");
        public static final ConfigStringList FAST_RIGHT_CLICK_BLOCK_BLACKLIST   = new ConfigStringList("快速右键（方块）-黑名单", ImmutableList.of("minecraft:chest", "minecraft:ender_chest", "minecraft:trapped_chest", "minecraft:white_shulker_box"), "如果快速右键模式限制类型设置为BlackList(黑名单），则不允许将这些项目用于快速右键");
        public static final ConfigStringList FAST_RIGHT_CLICK_BLOCK_WHITELIST   = new ConfigStringList("快速右键（方块）-白名单", ImmutableList.of(), "如果快速放置模式限制类型设置为WhiteList(白名单），则仅允许将这些项目用于快速右键");
        public static final ConfigOptionList FAST_RIGHT_CLICK_ITEM_LIST_TYPE    = new ConfigOptionList("快速右键（物品）-限制类型", ListType.NONE, "快速右键（物品）的限制类型\nblacklist=禁用黑名单内物品\nwhitelist=仅可用白名单内物品");
        public static final ConfigStringList FAST_RIGHT_CLICK_ITEM_BLACKLIST    = new ConfigStringList("快速右键（物品）-黑名单", ImmutableList.of("minecraft:fireworks"), "如果快速右键-限制类型设置为BlackList(黑名单），则不允许将这些物品用于快速右键");
        public static final ConfigStringList FAST_RIGHT_CLICK_ITEM_WHITELIST    = new ConfigStringList("快速右键（物品）-白名单", ImmutableList.of("minecraft:bucket", "minecraft:water_bucket", "minecraft:lava_bucket", "minecraft:glass_bottle"), "如果快速右键-限制类型设置为WhiteList(白名单），则仅允许将这些物品用于快速右键");
        public static final ConfigStringList FLAT_WORLD_PRESETS                 = new ConfigStringList("flatWorldPresets", ImmutableList.of("White Glass;1*minecraft:white_stained_glass;minecraft:plains;;minecraft:white_stained_glass", "Glass;1*minecraft:glass;minecraft:plains;;minecraft:glass"), "Custom flat world preset strings.\nThese are in the format: name;blocks_string;biome;generation_features;icon_item\nThe blocks string format is the vanilla format, such as: 62*minecraft:dirt,minecraft:grass\nThe biome can be the registry name, or the int ID\nThe icon item name format is minecraft:iron_nugget");
        public static final ConfigOptionList POTION_WARNING_LIST_TYPE           = new ConfigOptionList("potionWarningListType", ListType.NONE, "The list type for potion warning effects");
        public static final ConfigStringList POTION_WARNING_BLACKLIST           = new ConfigStringList("potionWarningBlackList", ImmutableList.of("minecraft:hunger", "minecraft:mining_fatigue", "minecraft:nausea", "minecraft:poison", "minecraft:slowness", "minecraft:weakness"), "The potion effects that will not be warned about");
        public static final ConfigStringList POTION_WARNING_WHITELIST           = new ConfigStringList("potionWarningWhiteList", ImmutableList.of("minecraft:fire_resistance", "minecraft:invisibility", "minecraft:water_breathing"), "The only potion effects that will be warned about");
        public static final ConfigStringList REPAIR_MODE_SLOTS                  = new ConfigStringList("repairModeSlots", ImmutableList.of("mainhand", "offhand"), "The slots the repair mode should use\nValid values: mainhand, offhand, head, chest, legs, feet");
        public static final ConfigStringList UNSTACKING_ITEMS                   = new ConfigStringList("unstackingItems", ImmutableList.of("minecraft:bucket", "minecraft:glass_bottle"), "The items that should be considered for the\n'tweakItemUnstackingProtection' tweak");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                FAST_PLACEMENT_ITEM_LIST_TYPE,
                FAST_RIGHT_CLICK_BLOCK_LIST_TYPE,
                FAST_RIGHT_CLICK_ITEM_LIST_TYPE,
                POTION_WARNING_LIST_TYPE,
                FAST_PLACEMENT_ITEM_BLACKLIST,
                FAST_PLACEMENT_ITEM_WHITELIST,
                FAST_RIGHT_CLICK_BLOCK_BLACKLIST,
                FAST_RIGHT_CLICK_BLOCK_WHITELIST,
                FAST_RIGHT_CLICK_ITEM_BLACKLIST,
                FAST_RIGHT_CLICK_ITEM_WHITELIST,
                FLAT_WORLD_PRESETS,
                POTION_WARNING_BLACKLIST,
                POTION_WARNING_WHITELIST,
                REPAIR_MODE_SLOTS,
                UNSTACKING_ITEMS
        );
    }

    public static class Disable
    {
        public static final ConfigBooleanHotkeyed       DISABLE_BLOCK_BREAK_PARTICLES   = new ConfigBooleanHotkeyed("关闭破坏效果",        false, "", "关闭方块破坏粒子效果\n(这最初来自于nessie的有用的mod)");
        public static final ConfigBooleanHotkeyed       DISABLE_DOUBLE_TAP_SPRINT       = new ConfigBooleanHotkeyed("禁用双击快速键加速",               false, "", "禁用双击快速键加速");
        public static final ConfigBooleanHotkeyed       DISABLE_BOSS_FOG                = new ConfigBooleanHotkeyed("消除BOSS造成的粒子效果",                       false, "", "消除BOSS造成的粒子效果");
        public static final ConfigBooleanHotkeyed       DISABLE_CLIENT_ENTITY_UPDATES   = new ConfigBooleanHotkeyed("关闭客户端实体更新",           false, "", "关闭除玩家外一切实体更新\n这可能可以解决你在一些实体过多或者\n有较多实体情况下中出现FPS降低的问题");
        public static final ConfigBooleanHotkeyed       DISABLE_DEAD_MOB_RENDERING      = new ConfigBooleanHotkeyed("屏蔽死亡后变红实体",              false, "", "屏蔽死后变红的实体 (此时ta的生命为0)");
        public static final ConfigBooleanHotkeyed       DISABLE_DEAD_MOB_TARGETING      = new ConfigBooleanHotkeyed("准星穿透死亡动画",              false, "", "准星会透过死亡动画里面的生物\n防止你鞭尸");
        public static final ConfigBooleanHotkeyed       DISABLE_ENTITY_RENDERING        = new ConfigBooleanHotkeyed("禁用客户端实体渲染",               false, "", "禁用除玩家外的所有实体渲染\n如果世界上有大量的实体可以帮助解决问题");
        public static final ConfigBooleanHotkeyed       DISABLE_ENTITY_TICKING          = new ConfigBooleanClient  ("禁用客户端实体运算",                 false, "", "不运算除了玩家以外所有实体");
        public static final ConfigBooleanHotkeyed       DISABLE_FALLING_BLOCK_RENDER    = new ConfigBooleanHotkeyed("禁用掉落方块渲染",   false, "", "禁用掉落的方块的实体渲染（有助于提高混凝土工厂FPS）");
        public static final ConfigBooleanHotkeyed       DISABLE_INVENTORY_EFFECTS       = new ConfigBooleanHotkeyed("禁用药水效果渲染",      false, "", "从GUI移除药水效果渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_ITEM_SWITCH_COOLDOWN    = new ConfigBooleanHotkeyed("禁止快捷栏切换冷却",      false, "", "如果启用，则在切换快捷栏时不会有任何冷却/装备动画");
        public static final ConfigBooleanHotkeyed       DISABLE_MOB_SPAWNER_MOB_RENDER  = new ConfigBooleanHotkeyed("禁止怪物生成器中实体渲染",        false, "", "从怪物生成器（如刷怪笼）中移除实体渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_NETHER_FOG              = new ConfigBooleanHotkeyed("消除地狱红色雾气",                     false, "", "消除地狱的雾气（就是往远处看不会是一片红色的）");
        public static final ConfigBooleanHotkeyed       DISABLE_OBSERVER                = new ConfigBooleanClient  ("禁止侦测器被触发",                      false, "", "禁止侦测器被触发");
        public static final ConfigBooleanHotkeyed       DISABLE_OFFHAND_RENDERING       = new ConfigBooleanHotkeyed("禁用物品实体渲染",              false, "", "关闭物品实体渲染");
        public static final ConfigBooleanHotkeyed       DISABLE_PARTICLES               = new ConfigBooleanHotkeyed("关闭所有粒子效果",                     false, "", "关闭所有粒子效果");
        public static final ConfigBooleanHotkeyed       DISABLE_PORTAL_GUI_CLOSING      = new ConfigBooleanHotkeyed("禁止在地狱门背包无法打开",              false, "", "如果开启，你可以站在地狱门中打开背包");
        public static final ConfigBooleanHotkeyed       DISABLE_RAIN_EFFECTS            = new ConfigBooleanHotkeyed("禁用雨水效果及音效",                   false, "", "关闭下雨时雨水效果及音效");
        public static final ConfigBooleanHotkeyed       DISABLE_SIGN_GUI                = new ConfigBooleanHotkeyed("禁用告示牌编辑GUI",                       false, "", "禁止打开告示牌编辑GUI\n在放置大量告示牌时很有用");
        public static final ConfigBooleanHotkeyed       DISABLE_SLIME_BLOCK_SLOWDOWN    = new ConfigBooleanHotkeyed("关闭在粘液块上减速效果",            false, "", "取消在粘液块上行走时的减速.\n(这是nessie写的没用的mod.)");
        public static final ConfigBooleanHotkeyed       DISABLE_TILE_ENTITY_RENDERING   = new ConfigBooleanHotkeyed("禁用方块实体渲染",           false, "", "禁止所有方块实体渲染（如活塞移动等）");
        public static final ConfigBooleanHotkeyed       DISABLE_TILE_ENTITY_TICKING     = new ConfigBooleanClient  ("禁用方块实体运算",             false, "", "禁止运算所有方块实体");
        public static final ConfigBooleanHotkeyed       DISABLE_VILLAGER_TRADE_LOCKING  = new ConfigBooleanClient  ("防止村民交易锁定",          false, "", "通过始终增加最大使用量来防止村民交易锁定");
        public static final ConfigBooleanHotkeyed       DISABLE_WALL_UNSPRINT           = new ConfigBooleanHotkeyed("防止碰到墙退出加速模式",                  false, "", "碰到墙壁不让你退出加速模式");

        public static final ImmutableList<IHotkeyTogglable> OPTIONS = ImmutableList.of(
                DISABLE_BLOCK_BREAK_PARTICLES,
                DISABLE_DOUBLE_TAP_SPRINT,
                DISABLE_BOSS_FOG,
                DISABLE_CLIENT_ENTITY_UPDATES,
                DISABLE_DEAD_MOB_RENDERING,
                DISABLE_DEAD_MOB_TARGETING,
                DISABLE_ENTITY_RENDERING,
                DISABLE_ENTITY_TICKING,
                DISABLE_FALLING_BLOCK_RENDER,
                DISABLE_INVENTORY_EFFECTS,
                DISABLE_ITEM_SWITCH_COOLDOWN,
                DISABLE_MOB_SPAWNER_MOB_RENDER,
                DISABLE_NETHER_FOG,
                DISABLE_OBSERVER,
                DISABLE_OFFHAND_RENDERING,
                DISABLE_PARTICLES,
                DISABLE_PORTAL_GUI_CLOSING,
                DISABLE_RAIN_EFFECTS,
                DISABLE_SIGN_GUI,
                DISABLE_SLIME_BLOCK_SLOWDOWN,
                DISABLE_TILE_ENTITY_RENDERING,
                DISABLE_TILE_ENTITY_TICKING,
                DISABLE_VILLAGER_TRADE_LOCKING,
                DISABLE_WALL_UNSPRINT
        );
    }

    public static class Internal
    {
        public static final ConfigInteger       FLY_SPEED_PRESET                    = new ConfigInteger     ("飞行速度预设", 0, 0, 3, "这仅用于Mod内部跟踪当前选定的飞行速度预设");
        public static final ConfigDouble        GAMMA_VALUE_ORIGINAL                = new ConfigDouble      ("原始伽马值", 0, 0, 1, "启用无限夜视之前的原始伽玛值");
        public static final ConfigInteger       HOTBAR_SCROLL_CURRENT_ROW           = new ConfigInteger     ("当前快捷栏", 3, 0, 3, "这仅是为了让mod内部跟踪\n>当前快捷栏<以实现 快捷栏滚动 功能");
        public static final ConfigDouble        SLIME_BLOCK_SLIPPERINESS_ORIGINAL   = new ConfigDouble      ("粘液块的原始滑度值", 0.8, 0, 1, "粘液块的原始滑度值");
        public static final ConfigDouble        SNAP_AIM_LAST_PITCH                 = new ConfigDouble      ("最后捕捉到的音调值", 0, -135, 135, "最后捕捉到的音调值");
        public static final ConfigDouble        SNAP_AIM_LAST_YAW                   = new ConfigDouble      ("最后捕捉到的偏航值", 0, 0, 360, "最后捕捉到的偏航值");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                FLY_SPEED_PRESET,
                GAMMA_VALUE_ORIGINAL,
                HOTBAR_SCROLL_CURRENT_ROW,
                SLIME_BLOCK_SLIPPERINESS_ORIGINAL,
                SNAP_AIM_LAST_YAW
        );
    }

    public static ConfigDouble getActiveFlySpeedConfig()
    {
        switch (Configs.Internal.FLY_SPEED_PRESET.getIntegerValue())
        {
            case 0:  return Configs.Generic.FLY_SPEED_PRESET_1;
            case 1:  return Configs.Generic.FLY_SPEED_PRESET_2;
            case 2:  return Configs.Generic.FLY_SPEED_PRESET_3;
            case 3:  return Configs.Generic.FLY_SPEED_PRESET_4;
            default: return Configs.Generic.FLY_SPEED_PRESET_1;
        }
    }

    public static void loadFromFile()
    {
        File configFile = new File(FileUtils.getConfigDirectory(), CONFIG_FILE_NAME);

        if (configFile.exists() && configFile.isFile() && configFile.canRead())
        {
            JsonElement element = JsonUtils.parseJsonFile(configFile);

            if (element != null && element.isJsonObject())
            {
                JsonObject root = element.getAsJsonObject();

                ConfigUtils.readConfigBase(root, "Fixes", Configs.Fixes.OPTIONS);
                ConfigUtils.readConfigBase(root, "Generic", Configs.Generic.OPTIONS);
                ConfigUtils.readConfigBase(root, "GenericHotkeys", Hotkeys.HOTKEY_LIST);
                ConfigUtils.readConfigBase(root, "Internal", Configs.Internal.OPTIONS);
                ConfigUtils.readConfigBase(root, "Lists", Configs.Lists.OPTIONS);
                ConfigUtils.readHotkeyToggleOptions(root, "DisableHotkeys", "DisableToggles", ImmutableList.copyOf(Disable.OPTIONS));
                ConfigUtils.readHotkeyToggleOptions(root, "TweakHotkeys", "TweakToggles", ImmutableList.copyOf(FeatureToggle.values()));
            }
        }

        InventoryUtils.setRepairModeSlots(Lists.REPAIR_MODE_SLOTS.getStrings());
        InventoryUtils.setUnstackingItems(Lists.UNSTACKING_ITEMS.getStrings());

        PlacementTweaks.FAST_RIGHT_CLICK_BLOCK_RESTRICTION.setListType((ListType) Lists.FAST_RIGHT_CLICK_BLOCK_LIST_TYPE.getOptionListValue());
        PlacementTweaks.FAST_RIGHT_CLICK_BLOCK_RESTRICTION.setListContents(
                Lists.FAST_RIGHT_CLICK_BLOCK_BLACKLIST.getStrings(),
                Lists.FAST_RIGHT_CLICK_BLOCK_WHITELIST.getStrings());

        PlacementTweaks.FAST_RIGHT_CLICK_ITEM_RESTRICTION.setListType((ListType) Lists.FAST_RIGHT_CLICK_ITEM_LIST_TYPE.getOptionListValue());
        PlacementTweaks.FAST_RIGHT_CLICK_ITEM_RESTRICTION.setListContents(
                Lists.FAST_RIGHT_CLICK_ITEM_BLACKLIST.getStrings(),
                Lists.FAST_RIGHT_CLICK_ITEM_WHITELIST.getStrings());

        PlacementTweaks.FAST_PLACEMENT_ITEM_RESTRICTION.setListType((ListType) Lists.FAST_PLACEMENT_ITEM_LIST_TYPE.getOptionListValue());
        PlacementTweaks.FAST_PLACEMENT_ITEM_RESTRICTION.setListContents(
                Lists.FAST_PLACEMENT_ITEM_BLACKLIST.getStrings(),
                Lists.FAST_PLACEMENT_ITEM_WHITELIST.getStrings());

        MiscTweaks.POTION_RESTRICTION.setListType((ListType) Lists.POTION_WARNING_LIST_TYPE.getOptionListValue());
        MiscTweaks.POTION_RESTRICTION.setListContents(
                Lists.POTION_WARNING_BLACKLIST.getStrings(),
                Lists.POTION_WARNING_WHITELIST.getStrings());
    }

    public static void saveToFile()
    {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs())
        {
            JsonObject root = new JsonObject();

            ConfigUtils.writeConfigBase(root, "Fixes", Configs.Fixes.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Generic", Configs.Generic.OPTIONS);
            ConfigUtils.writeConfigBase(root, "GenericHotkeys", Hotkeys.HOTKEY_LIST);
            ConfigUtils.writeConfigBase(root, "Internal", Configs.Internal.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Lists", Configs.Lists.OPTIONS);
            ConfigUtils.writeHotkeyToggleOptions(root, "DisableHotkeys", "DisableToggles", ImmutableList.copyOf(Disable.OPTIONS));
            ConfigUtils.writeHotkeyToggleOptions(root, "TweakHotkeys", "TweakToggles", ImmutableList.copyOf(FeatureToggle.values()));

            JsonUtils.writeJsonToFile(root, new File(dir, CONFIG_FILE_NAME));
        }
    }

    @Override
    public void load()
    {
        loadFromFile();
    }

    @Override
    public void save()
    {
        saveToFile();
    }
}
