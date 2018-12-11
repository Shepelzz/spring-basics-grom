package com.lesson7.homework7_1.model;

public enum Subcategory {
    SUBCATEGORY_1 {
        public Category getCategory() {
            return Category.CATEGORY_1;
        }
    },
    SUBCATEGORY_2 {
        public Category getCategory() {
            return Category.CATEGORY_1;
        }
    },
    SUBCATEGORY_3 {
        public Category getCategory() {
            return Category.CATEGORY_1;
        }
    },
    SUBCATEGORY_4 {
        public Category getCategory() {
            return Category.CATEGORY_2;
        }
    },
    SUBCATEGORY_5 {
        public Category getCategory() {
            return Category.CATEGORY_3;
        }
    },
    SUBCATEGORY_6 {
        public Category getCategory() {
            return Category.CATEGORY_3;
        }
    };

    public abstract Category getCategory();
}