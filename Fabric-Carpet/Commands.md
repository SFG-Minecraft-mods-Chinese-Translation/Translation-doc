这里是指令帮助界面，所有指令用法均给出

# 命令

## 常规地毯命令 (需要默认OP权限-等级为4的OP权限)

### 使用方法: /carpet

在聊天框里显示当前的Carpet MOD版本及功能列表

### 使用方法: /carpet list defaults

列出储存在 `carpet.conf` 文件中的默认地毯设置

### 使用方法: /carpet list

列出所有地毯功能

### 使用方法: /carpet list [标签]

列出所有带指定标签的地毯功能

### 使用方法: /carpet removeDefault [规则名]

移除[规则]的默认设置，并恢复为初始设置

### 使用方法: /carpet setDefault [规则名] <值>

将[规则]默认设置为[值],并保存在carpet.conf里

### 使用方法: /carpet [规则名] [值]

将[规则]设置为[值]


## 旁观模式 [Camera Mode]

### 使用方法: /c

将玩家设置为旁观模式(具有夜视和潮涌能量效果)

### 使用方法: /s

将玩家设置为生存模式(状态效果将被移除)

### 已在1.16+的Carpet被移除

## 距离 [Distance]

### 使用方法: /distance from [起点] to [终点]?

返回指定坐标之间的球面，圆柱面和曼哈顿距离。如果`to`未指定，则使用当前执行者位置

### 使用方法: /distance from [起点]?

记住起点坐标. 如果起点未指定，则使用当前执行者位置

### 使用方法: /distance to [终点]?

输出已储存的起点坐标至终点坐标的球面，圆柱面和曼哈顿距离. 如果终点未指定，则使用当前执行者位置

## 画 [Draw]

### 使用方法: /draw sphere [中心] [半径] [方块]

使用指定方块并使用指定的中心坐标和半径创建一个球体

### 使用方法: /draw sphere [中心] [半径] [方块] replace [方块/标签]

使用指定方块并使用指定的中心坐标和半径创建一个球体,但仅替换具有指定标签的一个或多个指定方块

## 信息 [Info]

### 使用方法: /info block [坐标]

获取指定坐标方块信息

### 使用方法: /info entity [选择器]

获取指定实体信息

### 使用方法: /info block [坐标] grep

获取由表达式指定的坐标内方块的特定信息

### 使用方法: /info entity [选择器] grep

获取由表达式指定的实体的特定信息

## 日志 [Log]

### 使用方法: /log

在聊天栏列出所有日志记录选项

### 使用方法: /log clear

取消订阅所有记录器

### 使用方法 /log counter [颜色]

订阅[颜色]的漏斗计数器,并显示在玩家列表中(默认TAB键)

### 使用方法: /log counter clear

取消订阅所有漏斗计数器

### 使用方法: /log fallingBlocks [brief/full]

This wiki is incomplete. You can help by expanding it.

### 使用方法: /log fallingBlocks clear

Unsubscibes the player from the fallingBlocks log

### 使用方法: /log mobcaps [维度]

订阅指定[维度]的怪物情况，并显示在玩家列表中(默认TAB键)

### 使用方法: /log mobcaps clear

取消订阅mobcaps记录器

### 使用方法: /log packets

订阅数据包传输情况，并显示在玩家列表中(默认TAB键)

### 使用方法: /log packets clear

取消订阅数据包情况

### 使用方法: /log pathfinding [2/5/10]

This wiki is incomplete. You can help by expanding it.

### 使用方法: /log pathfinding clear

Unsubscibes the player from the pathfinding log

### 使用方法: /log projectiles [brief/full]

This wiki is incomplete. You can help by expanding it.

### 使用方法: /log projectiles clear

Unsubscibes the player from the projectiles log

### 使用方法: /log tnt [brief/full]

当TNT爆炸的时候，告诉你在什么时间、什么地点、什么人、为什么和怎么爆炸的

### 使用方法: /log tnt clear

取消订阅TNT爆炸日志

### 使用方法: /log tps

在玩家列表显示TPS,MSPT(默认TAB键)

## 周长 [Perimeter Info]

### 使用方法: /perimeterinfo [坐标]

返回指定[坐标]周围128格半径内的怪物生成空间

### 使用方法: /perimeterinfo [坐标] [生物]

返回指定[坐标]周围128格半径内的怪物生成空间,以及指定[生物]的生成空间

## 延迟检测 [Ping]

### 使用方法: /ping

返回服务器与客户端之间的网络延迟