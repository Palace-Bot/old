package org.github.palace.bot.core.utils;

import org.github.palace.bot.constant.BaseConstant;

/**
 * @author JHY
 * @date 2022/3/23 23:48
 */
public final class MiraiCodeUtil {
    private static final String AT_ME_MIRAI_CODE = "mirai:at:" + BaseConstant.QQ;

    private MiraiCodeUtil() {
    }

    public static boolean isAtMe(String mraiCode) {
        return mraiCode.contains("[" + AT_ME_MIRAI_CODE + "]");
    }

    public static boolean isCommandLine(String mraiCode) {
        return true;
    }

}
