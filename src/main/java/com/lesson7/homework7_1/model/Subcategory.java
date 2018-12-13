package com.lesson7.homework7_1.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum Subcategory {
    SUBCATEGORY_1(Category.CATEGORY_1),
    SUBCATEGORY_2(Category.CATEGORY_1),
    SUBCATEGORY_3(Category.CATEGORY_1),
    SUBCATEGORY_4(Category.CATEGORY_2),
    SUBCATEGORY_5(Category.CATEGORY_2),
    SUBCATEGORY_6(Category.CATEGORY_2),
    SUBCATEGORY_7(Category.CATEGORY_3),
    SUBCATEGORY_8(Category.CATEGORY_3);
    private Category category;

    Subcategory(Category category) {
        this.category = category;
        Set<Subcategory> subcategorySet = MapHolder.map.computeIfAbsent(category, k -> new HashSet<Subcategory>());
        subcategorySet.add(this);
    }

    public static Set<Subcategory> getByCategory(Category category) {
        return MapHolder.map.getOrDefault(category, new HashSet<Subcategory>());
    }

    private static class MapHolder {
        static Map<Category, Set<Subcategory>> map = new HashMap<Category, Set<Subcategory>>();
    }
}