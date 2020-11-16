package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    private double calculateTotal() {
        double total = 0;

        for (OrderLine line : lines) {
            total += line.getProduct().getPrice() * line.getQuantity();
        }

        return total;
    }

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    public boolean isElegibleForFreeDelivery() {
        double total = calculateTotal();

        if (total > 100) return true;
        else return false;
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line.getInfo());

        double total = calculateTotal();

        printBuffer.append("Total: " + total);

        return printBuffer.toString();
    }
}