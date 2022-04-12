package org.github.wulin.core.person;

import lombok.Getter;
import lombok.Setter;

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

    public Player(String name) {
        this.name = name;
    }

    public void init(int strength, int agility, int intelligence){
        this.property = new Property(strength,agility,intelligence);
    }
}
