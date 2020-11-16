package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final List<Integer> list;


    public ListFilterer(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> filter(IListFilter filter) {
        List<Integer> res = new ArrayList<>();

        for (Integer elem :list) {
            if (filter.accept(elem)) {
                res.add(elem);
            }
        }

        return res;
    }
}
