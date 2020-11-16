package com.aor.refactoring.example3;

public class PercentageDiscount implements Discount {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price - price * percentage;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
