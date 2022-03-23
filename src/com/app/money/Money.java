package com.app.money;

import com.app.define.Currency;
import com.app.define.Type;

public interface Money {
    public String toString();

    void setAmount(long i);

    void setDate(String s);

    void setCategory(String beverage);

    void setCurrency(Currency Currency);

    public long getAmount();

    public String getDate();

    public String getCategory();

    public Currency getCurrency();

    public Type getType();
}
