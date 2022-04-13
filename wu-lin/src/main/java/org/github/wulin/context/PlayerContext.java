package org.github.wulin.context;

import org.github.wulin.core.person.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jihongyuan
 * @date 2022/4/12 14:50
 */
public class PlayerContext {

    private static final Map<Long, Player> ID_PAYER = new HashMap<>(16);

    public static Player getPlayer(Long id) {
        return ID_PAYER.get(id);
    }

    public static void putPlayer(Long id, Player player) {
        ID_PAYER.put(id, player);
    }
}
