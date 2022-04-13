package org.github.wulin.utils;

import org.github.wulin.core.map.Maps;
import org.github.wulin.core.map.MapMeshType;
import org.github.wulin.core.person.Player;

/**
 * @author jihongyuan
 * @date 2022/4/12 15:07
 */
public final class StringPrintUtil {

    public static StringBuilder print(Object[][] args) {
        StringBuilder sb = new StringBuilder();

        int col = args.length;
        int row = args[0].length;


        for (int i = 0; i < col; i++) {
            Object[] arg = args[i];
            for (int j = 0; j < row; j++) {
                if (arg[j] != null) {
                    sb.append("| ").append(arg[j]);
                    if (j == row - 1) {
                        sb.append(" |");
                    }
                    sb.append(" ");
                }
            }
            // 每行结尾换行
            sb.append("\r\n");
        }
        return sb;
    }

    public static StringBuilder printfMap(Player player) {
        Maps maps = player.getMaps();
        int[][] value = maps.getValue();

        String[][] args = new String[value.length + 1][value[0].length];

        for (int i = 0; i < value.length; i++) {
            int[] arg = value[i];
            for (int j = 0; j < arg.length; j++) {
                MapMeshType byCode = MapMeshType.getByCode(value[i][j]);
                args[i + 1][j] = byCode.getDesc();
            }
        }

        int[] index = player.getCurrentMapIndex();
        args[index[0]][index[1]] = "角色";

        return print(args);
    }

}
