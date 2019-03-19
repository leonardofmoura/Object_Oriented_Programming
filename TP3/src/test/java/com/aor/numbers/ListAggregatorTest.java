package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListAggregatorTest {
    private List<Integer> list;

    class stubDeduplicator implements IListDeduplicator {

        @Override
        public List<Integer> deduplicate() {
            List<Integer> res = new ArrayList<>();

            res.add(1);
            res.add(2);
            res.add(4);

            return res;
        }
    }

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void maxNeg() {
        List<Integer> negList = new ArrayList<>();
        negList.add(-1);
        negList.add(-4);
        negList.add(-5);

    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinctBug() {
        List<Integer> bugList = new ArrayList<>();
        bugList.add(1);
        bugList.add(2);
        bugList.add(4);
        bugList.add(2);

        ListAggregator aggregator = new ListAggregator(bugList);

        int distinct = aggregator.distinct(new stubDeduplicator());

        assertEquals(3,distinct);
    }

    @Test
    public void distinctBugMockito() {
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);

        List<Integer> deduplicated = new ArrayList<>();
        deduplicated.add(1);
        deduplicated.add(2);
        deduplicated.add(4);

        Mockito.when(deduplicator.deduplicate()).thenReturn(deduplicated);

        List<Integer> bugList = new ArrayList<>();
        bugList.add(1);
        bugList.add(2);
        bugList.add(4);
        bugList.add(2);

        ListAggregator aggregator = new ListAggregator(bugList);

        int distinct = aggregator.distinct(deduplicator);

        assertEquals(3,distinct);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct();

        assertEquals(4, distinct);
    }
}