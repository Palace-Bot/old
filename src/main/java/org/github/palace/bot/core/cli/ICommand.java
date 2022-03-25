package org.github.palace.bot.core.cli;

/**
 * @author JHY
 * @date 2022/3/23 14:52
 */
public interface ICommand {

    /**
     * 执行命令
     *
     * @param miraiCode 序列化mirai码
     */
    void invoke(String miraiCode);

    /**
     * 支持命令
     *
     * @param miraiCode 序列化mirai码
     */
    boolean support(String miraiCode);

}
