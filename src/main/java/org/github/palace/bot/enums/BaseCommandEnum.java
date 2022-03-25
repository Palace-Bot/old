package org.github.palace.bot.enums;

import lombok.Getter;
import net.mamoe.mirai.contact.MemberPermission;

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
    HELP("help", MemberPermission.MEMBER, MemberPermission.ADMINISTRATOR, MemberPermission.OWNER),

    /**
     * 禁言
     */
    MUTE("mute", MemberPermission.ADMINISTRATOR, MemberPermission.OWNER),

    /**
     * 解禁言
     */
    UNMUTE("unmute", MemberPermission.ADMINISTRATOR, MemberPermission.OWNER),

    /**
     * 移除
     */
    KICK("kick", MemberPermission.ADMINISTRATOR, MemberPermission.OWNER),

    ;
    @Getter
    private final String code;

    /**
     * 区分目标权限
     */
    @Getter
    private final MemberPermission[] roleType;

    BaseCommandEnum(String code, MemberPermission... roleType) {
        this.code = code;
        this.roleType = roleType;
    }

    public static BaseCommandEnum get(String code) {
        code = code.toUpperCase();
        for (BaseCommandEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }

    public static boolean hasMemberPermission(BaseCommandEnum commandEnum, MemberPermission permission) {
        for (MemberPermission memberPermission : commandEnum.getRoleType()) {
            if (permission == memberPermission) {
                return true;
            }
        }
        return false;
    }

}
