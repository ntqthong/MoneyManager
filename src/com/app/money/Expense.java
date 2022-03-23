package com.app.money;

import com.app.define.Category;
import com.app.define.Currency;
import com.app.define.Type;

public class Expense implements Money {
    private long amount;
    private String date;
    private Category category;
    private Currency currency;
    private Type type;

    public Expense(long amount, String date, Category category, Currency currency) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.currency = currency;
        this.type = Type.EXPENSE;
    }

    public Expense(long amount, String date, String category, Currency currency) {
        this.amount = amount;
        this.date = date;
        this.category = new Category(category);
        this.currency = currency;
        this.type = Type.EXPENSE;
    }

    public Expense() {
        this.type = Type.EXPENSE;
    }

    public long getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category.toString();
    }

    public Currency getCurrency() {
        return currency;
    }

    public Type getType() {
        return type;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = new Category(category);
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "-" + this.getAmount() + " " + this.getCurrency() + "|" + this.getDate()+ "|" + this.getCategory() + "\n";
    }
}
