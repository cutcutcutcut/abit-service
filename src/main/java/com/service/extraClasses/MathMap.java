package com.service.extraClasses;

import java.util.HashMap;
import java.util.Map;

public class MathMap {
    private static final Map<Integer, Integer> map;

    static {
        map = new HashMap<>();
        map.put(1, 5);
        map.put(2, 9);
        map.put(3, 14);
        map.put(4, 14);
        map.put(5, 18);
        map.put(6, 18);
        map.put(7, 23);
        map.put(8, 27);
        map.put(9, 33);
        map.put(10, 39);
        map.put(11, 45);
        map.put(12, 50);
        map.put(13, 50);
        map.put(14, 56);
        map.put(15, 56);
        map.put(16, 62);
        map.put(17, 62);
        map.put(18, 62);
        map.put(19, 68);
        map.put(20, 68);
        map.put(21, 70);
        map.put(22, 70);
        map.put(23, 70);
        map.put(24, 72);
        map.put(25, 72);
        map.put(26, 74);
        map.put(27, 76);
        map.put(28, 78);
        map.put(29, 80);
        map.put(30, 82);
        map.put(31, 84);
        map.put(32, 86);
        map.put(33, 88);
        map.put(34, 90);
        map.put(35, 92);
        map.put(36, 94);
        map.put(37, 96);
        map.put(38, 98);
        map.put(39, 99);
        map.put(40, 100);
    }

    public static Integer getRes(Integer key) {
        if (!map.containsKey(key)) {
            return 0;
        }
        return map.get(key);
    }
}
