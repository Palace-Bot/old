package org.github.palace.bot.core.service;

import net.mamoe.mirai.contact.Member;

/**
 * @author JHY
 * @date 2022/3/23 14:42
 */
public interface IMemberService {

    /**
     * 默认禁言30分钟
     *
     * @param members 群组成员
     */
    void mute(Member... members);

    /**
     * 禁言
     *
     * @param durationSeconds 禁言秒数
     * @param members         群组成员
     */
    void mute(int durationSeconds, Member... members);

    /**
     * 解除禁言
     *
     * @param members 群组成员
     */
    void unmute(Member... members);

    /**
     * 移除
     *
     * @param members 群组成员
     */
    void kick(Member... members);

}
