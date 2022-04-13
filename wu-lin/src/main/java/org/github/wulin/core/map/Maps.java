package org.github.wulin.core.map;

import lombok.Data;

/**
 * @author jihongyuan
 * @date 2022/4/13 9:47
 */
@Data
public class Maps {
    private String mapId;
    private int[] playerInitPos;
    private int[][] value;

    public Maps(String mapId) {
        this.mapId = mapId;
    }

    @Override
    protected Maps clone(){
        Maps maps = new Maps(this.getMapId());
        maps.setPlayerInitPos(new int[]{this.getPlayerInitPos()[0], this.getPlayerInitPos()[1]});

        int[][] arrays = new int[this.getValue().length][this.getValue()[0].length];

        for (int i = 0; i < this.getValue().length; i++) {
            int[] array = this.getValue()[i];
            arrays[i] = array.clone();
        }
        maps.setValue(arrays);
        return maps;
    }
}
