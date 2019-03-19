package com.aor.numbers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PositiveFilterTest {
    @Test
    public void accept() {
        PositiveFilter filter = new PositiveFilter();

        boolean first = filter.accept(1);
        boolean second = filter.accept(33);
        boolean third = filter.accept(-54);
        boolean fourth = filter.accept(-34242);

        assertEquals(true,first);
        assertEquals(true,second);
        assertEquals(false,third);
        assertEquals(false,fourth);
    }
}
