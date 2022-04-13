package org.github.wulin.core.person;

import lombok.Getter;
import lombok.Setter;
import org.github.wulin.core.map.Maps;

import java.util.Random;

/**
 * @author jihongyuan
 * @date 2022/4/12 11:26
 */
@Getter
@Setter
public class Player {

    /**
     * 名称
     */
    private String name;

    /**
     * 属性
     */
    private Property property;

    /**
     * 当前处于的地图
     */
    private String mapId;

    /**
     * 当前地图结构
     */
    private Maps maps;

    /**
     * 当前地图所需
     * example: currentMapIndex[0] X轴坐标, currentMapIndex[1] Y轴坐标
     */
    private int[] currentMapIndex;

    private final Random random = new Random();

    public Player(String name) {
        this.name = name;
    }

    /**
     * 分配属性
     */
    public void allocateProperty() {
        this.property = new Property(random.nextInt(10), random.nextInt(10), random.nextInt(10));
    }

    /**
     * 加载地图
     */
    public void initMap(Maps maps) {
        this.maps = maps;
        this.currentMapIndex = maps.getPlayerInitPos();
    }

}
