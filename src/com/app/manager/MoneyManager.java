package com.app.manager;

import com.app.define.Currency;
import com.app.money.Money;
import com.app.define.Type;

import java.util.ArrayList;
import java.util.Objects;

public class MoneyManager {
    private final ArrayList<Money> transactions;
    private final Currency currency;
    private long budget;

    public MoneyManager(Currency currency, long budget) {
        this.transactions = new ArrayList<Money>();
        this.currency = currency;
        this.budget = budget;
    }

    public void add(Money transaction) {
        Objects.requireNonNull(transaction);
        if (!transaction.getCurrency().equals(this.currency)) {
            throw new IllegalArgumentException("Currency does not match: " + transaction.getCurrency() + ". " + "Currency must be: " + this.getCurrency());
        }
        this.transactions.add(transaction);
    }

    public void remove(Money transaction) {
        Objects.requireNonNull(transaction);
        this.transactions.remove(transaction);
    }

    public void setBudget(long newBudget) {
        this.budget = newBudget;
    }

    public long getTotalExpense() {
        long expenses = 0;
        for (var transaction : transactions) {
            if (transaction.getType().equals(Type.EXPENSE)) {
                expenses += transaction.getAmount();
            }
        }
        return expenses;
    }

    public long getTotalIncome() {
        long incomes = 0;
        for (var transaction : transactions) {
            if (transaction.getType().equals(Type.INCOME)) {
                incomes += transaction.getAmount();
            }
        }
        return incomes;
    }

    public long getBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getBudget() {
        return budget;
    }

    public long getBudgetStatus() {
        return getBudget() - getTotalExpense();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---Transactions List---\n");
        for (var transaction : transactions) {
            stringBuilder.append(transaction).append("\n");
        }
        stringBuilder.append("-----------------------\n");
        if (this.getBudgetStatus() >= 0) {
            stringBuilder.append(this.getBudgetStatus() + "/" + budget).append(" rest\n");
        }
        else {
            stringBuilder.append(this.getBudgetStatus() + "/" + budget).append(" out of budget\n");
        }
        stringBuilder.append("-----------------------\n");
        return stringBuilder.toString();
    }
}
