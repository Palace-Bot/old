package org.github.wulin.core.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jihongyuan
 * @date 2022/4/13 10:54
 */
public final class MapData {

    private static final Map<String, Maps> CACHE = new HashMap<>(16);

    static {
        Maps maps = new Maps("第一关");
        maps.setValue(new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        });
        maps.setPlayerInitPos(new int[]{1, 1});
        CACHE.put(maps.getMapId(), maps);
    }

    public static Maps get(String mapId) {
        Maps maps = CACHE.get(mapId);
        return maps.clone();
    }

}
