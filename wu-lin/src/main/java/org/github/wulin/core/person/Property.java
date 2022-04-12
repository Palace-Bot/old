package org.github.wulin.core.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 人物属性
 *
 * @author jihongyuan
 * @date 2022/4/12 11:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    /**
     * 力量
     */
    private int strength;

    /**
     * 敏捷
     */
    private int agility;

    /**
     * 智力
     */
    private int intelligence;

}
