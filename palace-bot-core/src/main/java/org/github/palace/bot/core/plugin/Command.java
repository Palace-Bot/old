package org.github.palace.bot.core.plugin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.mamoe.mirai.contact.MemberPermission;

import java.util.Objects;

/**
 * 命令基本信息
 *
 * @author JHY
 * @date 2022/3/27 9:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Command {

    /**
     * 主指令名. 将会参与构成 [Permission.id].
     * <p>
     * 不允许包含 [空格][Char.isWhitespace], '.', ':'.
     */
    private String primaryName;

    /**
     * 为此指令分配的权限.
     */
    private MemberPermission permission;

    /**
     * 为 true 时, 需要 Y/n 确定
     */
    private boolean determine;

    /**
     * 描述, 用于显示在 [BuiltInCommands.HelpCommand]
     */
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return determine == command.determine && Objects.equals(primaryName, command.primaryName) && permission == command.permission && Objects.equals(description, command.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryName, permission, determine, description);
    }

}