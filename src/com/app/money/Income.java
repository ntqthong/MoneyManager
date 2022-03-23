package com.app.money;

import com.app.define.Category;
import com.app.define.Currency;
import com.app.define.Type;

public class Income extends Expense implements Money {
    private Type type;
    public Income(long amount, String date, Category category, Currency currency) {
        super(amount, date, category, currency);
        this.type = Type.INCOME;
    }

    public Income(long amount, String date, String category, Currency currency) {
        super(amount, date, category, currency);
        this.type = Type.INCOME;
    }

    public Income() {
        this.type = Type.INCOME;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "+" + this.getAmount() + " " + this.getCurrency() + "|" + this.getDate() + "|" + this.getCategory() + "\n";
    }
}
