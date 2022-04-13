package org.github.wulin.core.map;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @author jihongyuan
 * @date 2022/4/13 9:48
 */

@AllArgsConstructor
public enum MapMeshType {

    /**
     * 空 占位不显示
     */
    NONE(-1, ""),

    /**
     * npc
     */
    NPC(0, "NPC"),

    /**
     * 玩家
     */
    PLAYER(1, "玩家"),

    /**
     * 怪物
     */
    MONSTER(2, "怪物"),

    // 建筑类型
    /**
     * 武器店
     */
    WEAPON(21, "武器店"),

    /**
     * 防具店
     */
    ARMOR(22, "防具店"),

    /**
     * 铁匠铺
     */
    SMITH(23, "铁匠铺"),

    // 场地类型
    /**
     * 河流
     */
    RIVER(41, "河流"),

    /**
     * 树林
     */
    WOOD(42, "树林");

    @Getter
    private final int code;
    @Getter
    private final String desc;


    @NotNull
    public static MapMeshType getByCode(int code) {
        for (MapMeshType type : MapMeshType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return MapMeshType.NONE;
    }
}
