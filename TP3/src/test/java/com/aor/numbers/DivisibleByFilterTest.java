package com.aor.numbers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DivisibleByFilterTest {
    @Test
    public void accept() {
        DivisibleByFilter filter3 = new DivisibleByFilter(3);
        DivisibleByFilter filter1 = new DivisibleByFilter();

        boolean first = filter3.accept(9);
        boolean second = filter3.accept(11);
        boolean third = filter1.accept(12);
        boolean fourth = filter1.accept(23432);
        boolean fifth = filter3.accept(61);

        assertEquals(true,first);
        assertEquals(false,second);
        assertEquals(true,third);
        assertEquals(true,fourth);
        assertEquals(false,fifth);
    }

}
