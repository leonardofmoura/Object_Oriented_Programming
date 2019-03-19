package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private Integer num;

    public DivisibleByFilter(Integer num) {
        this.num = num;
    }

    public DivisibleByFilter() {
        this.num = 1;
    }

    @Override
    public boolean accept(Integer number) {
        if (number % num == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
