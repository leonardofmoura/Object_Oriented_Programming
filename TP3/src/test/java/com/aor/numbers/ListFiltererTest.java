package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFiltererTest {
    class FilterSub implements IListFilter {

        @Override
        public boolean accept(Integer number) { //accepts even numbers
            if (number % 2 == 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    @Test
    public void filter() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        ListFilterer filterer = new ListFilterer(nums);

        FilterSub filterSub = new FilterSub();
        List<Integer> filtered = filterer.filter(filterSub);

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(4);

        assertEquals(expected,filtered);
    }
}
