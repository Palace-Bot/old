package org.github.palace.bot.enums;

import lombok.Getter;

/**
 * 基本功能之类
 *
 * @author JHY
 * @date 2022/3/22 13:59
 */
public enum BaseCommandEnum {

    /**
     * 帮助
     */
    HELP("-help", RoleType.ALL),

    /**
     * 禁言
     */
    MUTE("-mute", RoleType.ADMIN, RoleType.CREATOR),

    /**
     * 解禁言
     */
    UNMUTE("-unmute", RoleType.ADMIN, RoleType.CREATOR),

    /**
     * 移除
     */
    KICK("-kick", RoleType.ADMIN, RoleType.CREATOR),

    ;
    @Getter
    private final String code;

    /**
     * 区分目标权限
     */
    @Getter
    private final RoleType[] roleType;

    BaseCommandEnum(String code, RoleType... roleType) {
        this.code = code;
        this.roleType = roleType;
    }

}
