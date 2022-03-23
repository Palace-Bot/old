package org.github.palace.bot.core.command;

/**
 * @author JHY
 * @date 2022/3/23 14:52
 */
public interface ICommand {

    /**
     * 执行命令
     *
     * @param miraiCode 序列化mirai 码
     */
    void invoke(String miraiCode);

}
