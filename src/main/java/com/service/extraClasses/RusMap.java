package com.service.extraClasses;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс со статической структурой данных - Map и методом для получения значения по ключу
 * Класс соответствует вступительному испытанию по русскому языку
 * @author Алексей Бехтерев
 * @version 1.0
 */

public class RusMap {
    private static final Map<Integer, Integer> map;

    static {
        map = new HashMap<>();
        map.put(1, 3);
        map.put(2, 5);
        map.put(3, 8);
        map.put(4, 10);
        map.put(5, 12);
        map.put(6, 15);
        map.put(7, 17);
        map.put(8, 20);
        map.put(9, 22);
        map.put(10, 24);
        map.put(11, 30);
        map.put(12, 34);
        map.put(13, 38);
        map.put(14, 41);
        map.put(15, 43);
        map.put(16, 44);
        map.put(17, 46);
        map.put(18, 50);
        map.put(19, 53);
        map.put(20, 54);
        map.put(21, 56);
        map.put(22, 59);
        map.put(23, 61);
        map.put(24, 65);
        map.put(25, 69);
        map.put(26, 72);
        map.put(27, 76);
        map.put(28, 78);
        map.put(29, 80);
        map.put(30, 82);
        map.put(31, 85);
        map.put(32, 87);
        map.put(33, 89);
        map.put(34, 94);
        map.put(35, 96);
        map.put(36, 100);
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
