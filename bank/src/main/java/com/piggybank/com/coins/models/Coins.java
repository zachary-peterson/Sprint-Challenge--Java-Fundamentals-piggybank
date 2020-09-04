package com.piggybank.com.coins.models;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coins
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coinid;
    private String name;
    private String nameplural;
    private double value;
    private int quantity;

    public Coins(String name, String nameplural, double value, int quantity)
    {
        this.name = name;
        this.nameplural = nameplural;
        this.value = value;
        this.quantity = quantity;
    }

    public Coins()
    {
    }

    public int getCoinid()
    {
        return coinid;
    }

    public void setCoinid(int coinid)
    {
        this.coinid = coinid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNameplural()
    {
        return nameplural;
    }

    public void setNameplural(String nameplural)
    {
        this.nameplural = nameplural;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getTotalValue()
    {
        double totalValue = this.value * (int)this.quantity;
        return totalValue;
    }

    public boolean needPluralNames()
    {
        boolean plural = quantity > 1;
        return plural;
    }

    @Override
    public String toString()
    {
        if(needPluralNames())
        {
            return quantity + " " + nameplural;
        }
        else
        {
            return quantity + " " + name;
        }
    }
}
