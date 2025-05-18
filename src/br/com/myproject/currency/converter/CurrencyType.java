package br.com.myproject.currency.converter;

public class CurrencyType {
    private String name;
    private double value;

    public CurrencyType(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + "(" + value + ")";
    }
}
