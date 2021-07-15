package com.service.extraClasses;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс со статической структурой данных - Map и методом для получения значения по ключу
 * Класс соответствует вступительному испытанию по физике
 * @author Алексей Бехтерев
 * @version 1.0
 */

public class PhysMap {
    private static final Map<Integer, Integer> map;

    static {
        map = new HashMap<>();
        map.put(1, 4);
        map.put(2, 7);
        map.put(3, 10);
        map.put(4, 14);
        map.put(5, 17);
        map.put(6, 20);
        map.put(7, 23);
        map.put(8, 27);
        map.put(9,30);
        map.put(10, 33);
        map.put(11, 36);
        map.put(12, 39);
        map.put(13, 41);
        map.put(14, 44);
        map.put(15, 46);
        map.put(16, 48);
        map.put(17, 51);
        map.put(18, 52);
        map.put(19, 54);
        map.put(20, 55);
        map.put(21, 57);
        map.put(22, 59);
        map.put(23, 61);
        map.put(24, 64);
        map.put(25, 68);
        map.put(26, 70);
        map.put(27, 72);
        map.put(28, 74);
        map.put(29, 76);
        map.put(30, 78);
        map.put(31, 82);
        map.put(32, 86);
        map.put(33, 90);
        map.put(34, 96);
        map.put(35, 100);
    }

    /**
     * Статический метод по получению значения по ключу, принимаемому в параметрах
     * Если такого ключа нет - возвращается 0
     * @param key - ключ
     * @return Integer
     */
    public static Integer getRes(Integer key) {
        if (!map.containsKey(key)) {
            return 0;
        }
        return map.get(key);
    }
}
