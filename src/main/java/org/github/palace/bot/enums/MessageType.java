package org.github.palace.bot.enums;

import com.google.common.base.CaseFormat;

/**
 * 消息类型 (当然我不会支持这么多类型)
 *
 * @author JHY
 * @date 2022/3/23 15:16
 * @see net.mamoe.mirai.message.data.PlainText 纯文本
 * @see net.mamoe.mirai.message.data.At At 一个群成员.
 * @see net.mamoe.mirai.message.data.AtAll At 全体成员
 * @see net.mamoe.mirai.message.data.HummerMessage 一些特殊消息: [戳一戳][PokeMessage], [闪照][FlashImage]
 * @see net.mamoe.mirai.message.data.Image 图片
 * @see net.mamoe.mirai.message.data.RichMessage 富文本
 * @see net.mamoe.mirai.message.data.ServiceMessage 服务消息, 如 JSON/XML
 * @see net.mamoe.mirai.message.data.Face 原生表情
 * @see net.mamoe.mirai.message.data.ForwardMessage 合并转发
 * @see net.mamoe.mirai.message.data.Voice 语音
 * @see net.mamoe.mirai.message.data.MarketFace 商城表情
 * @see net.mamoe.mirai.message.data.MusicShare 音乐分享
 */
public enum MessageType {

    /**
     * 消息来源
     */
    MESSAGE_SOURCE,

    /**
     * 纯文本
     */
    PLAIN_TEXT,

    /**
     * At 一个群成员
     */
    AT,

    /**
     * 图片
     */
    IMAGES,

    /**
     * 原生表情
     */
    FACE;

    /**
     * 将字符串转为消息类型
     *
     * @param code code
     * @return no support type result no
     */
    public static MessageType get(String code) {
        code = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, code).toUpperCase();
        for (MessageType value : values()) {
            if (value.toString().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
