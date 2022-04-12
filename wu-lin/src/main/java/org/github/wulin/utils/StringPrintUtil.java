package org.github.wulin.utils;

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
                    sb.append("\t|  ").append(arg[j]);
                    if (j == row - 1) {
                        sb.append("  |");
                    }
                    sb.append("\t");
                }
            }
            // 每行结尾换行
            sb.append("\r\n");
        }
        return sb;
    }

}
