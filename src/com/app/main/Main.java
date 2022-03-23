package com.app.main;

import com.app.define.Categories;
import com.app.define.Category;
import com.app.define.Currency;
import com.app.money.*;
import com.app.manager.MoneyManager;


public class Main {
    public static void main(String[] args) {
        Categories categories = new Categories();
        categories.add(new Category("food"));
        categories.add("beverage");
        categories.add(new Category("salary"));
        categories.add("bonus");
        MoneyManager transactions = new MoneyManager(Currency.VND, 100000);
        Money money = new Expense(299000, "22/03/2022", "food", Currency.VND);
        Money money1 = new Expense();
        Money money2 = new Income(50000, "22/03/2022", "bonus", Currency.VND);

        money1.setAmount(86000);
        money1.setDate("22/03/2022");
        money1.setCategory("beverage");
        money1.setCurrency(Currency.VND);

        transactions.add(money);
        transactions.add(money1);
        transactions.add(money2);

        System.out.println(transactions);

        System.out.println(transactions.getTotalExpense());
        System.out.println(transactions.getTotalIncome());

        transactions.remove(money1);
        System.out.println(transactions);
    }
}
