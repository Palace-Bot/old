package org.github.wulin.gui;

import org.github.palace.bot.core.annotation.CommandHandler;
import org.github.palace.bot.core.cli.CommandSender;
import org.github.palace.bot.core.cli.SimpleCommand;
import org.github.wulin.gui.main.CloseCommand;
import org.github.wulin.gui.main.CreateRoleCommand;
import org.github.wulin.gui.main.LoadRoleCommand;
import org.github.wulin.gui.map.*;
import org.github.wulin.gui.menu.StatusCommand;
import org.github.wulin.utils.StringPrintUtil;

/**
 * @author jihongyuan
 * @date 2022/4/8 21:50
 */
public class MainCommand extends SimpleCommand {

    public MainCommand() {
        super("武林", null, false, "打开武林游戏");
        // 主菜单
        this.register(new CreateRoleCommand());
        this.register(new LoadRoleCommand());
        this.register(new CloseCommand());

        // 人物状态
        this.register(new StatusCommand());

        // 地图相关操作
        this.register(new MapCommand());
        this.register(new EastCommand());
        this.register(new NorthCommand());
        this.register(new SouthCommand());
        this.register(new WestCommand());
    }

    @CommandHandler
    public void handler(CommandSender commandSender) {
        StringBuilder sb = StringPrintUtil.print(new String[][]{
                {"创建角色"},
                {"读取角色"},
                {"关闭游戏"},
        });
        commandSender.sendMessage(sb.toString());
    }

}
