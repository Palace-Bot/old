package org.github.palace.bot.core.service.impl;

import net.mamoe.mirai.contact.Member;
import org.github.palace.bot.core.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JHY
 * @date 2022/3/23 14:42
 */
public class MemberServiceImpl implements IMemberService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Override
    public void mute(Member... members) {

    }

    @Override
    public void mute(int durationSeconds, Member... members) {

    }

    @Override
    public void unmute(Member... members) {

    }

    @Override
    public void kick(Member... members) {

    }
}
