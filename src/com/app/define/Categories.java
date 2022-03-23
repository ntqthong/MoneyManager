package com.app.define;

import java.util.ArrayList;
import java.util.Objects;

public class Categories {
    private final ArrayList<Category> categories;

    public Categories() {
        this.categories = new ArrayList<Category>();
    }

    public void add(Category category) {
        Objects.requireNonNull(category);
        categories.add(category);
    }

    public void add(String category) {
        Objects.requireNonNull(category);
        categories.add(new Category(category));
    }

    public void remove(String category) {
        Objects.requireNonNull(category);
        categories.remove(category.toUpperCase());
    }

    public void remove(Category category) {
        categories.remove(category);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var category : categories) {
            stringBuilder.append(category).append("\n");
        }
        return stringBuilder.toString();
    }
}