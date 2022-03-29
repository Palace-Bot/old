package org.github.palace.bot.data.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.github.palace.bot.data.entity.MessageDO;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JHY
 * @date 2022/3/29 9:24
 */
@Mapper
public interface MessageMapper {
    Set<Long> MESSAGE_TABLE_SET = new HashSet<>();

    /**
     * 分表插入数据库
     *
     * @param groupId   群号
     * @param messageDO do
     */
    default void insert(Long groupId, MessageDO messageDO) {
        messageDO.setGroupId(groupId);
        if (!MESSAGE_TABLE_SET.contains(groupId)) {
            MESSAGE_TABLE_SET.add(groupId);
            String sql = selectCreateTable("t_message");
            sql = sql.replace("t_message", "t_message_" + groupId);
            exec(sql);
        }
        insert(messageDO);
    }

    @Insert("insert into t_message_${groupId} (member_id, message, create_at) values (#{memberId}, #{message}, #{createAt})")
    void insert(MessageDO message);

    @Select("select sql from sqlite_master where type = 'table' and name = #{tableName}")
    String selectCreateTable(String tableName);

    @Select("${sql}")
    void exec(String sql);

}
