package GameCore.Stats;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatTest {

    @Test
    public void getValue() {
        Stat test = new Stat(-1);

        assertEquals(0, test.getValue());
        test = new Stat(4);
        assertEquals(4, test.getValue());
    }

    @Test
    public void setValue() {
        Stat test = new Stat(-1);

        assertEquals(0, test.getValue());
        test.setValue(4);
        assertEquals(4, test.getValue());

    }

    @Test
    public void add_buff() {
        Stat test = new Stat(0);
        int buf = 1;

        assertEquals(0,test.getBuff_buffer().size());

        test.add_buff(buf);

        assertEquals(buf,test.getValue());
        assertEquals(1,test.getBuff_buffer().size());

    }

    @Test
    public void clear_buffs() {
        Stat test = new Stat(0);
        int buf = 1;

        assertEquals(0,test.getBuff_buffer().size());

        test.add_buff(buf);

        assertEquals(buf,test.getValue());
        assertEquals(1,test.getBuff_buffer().size());

        test.clear_buffs();
        assertEquals(0,test.getBuff_buffer().size());
    }
}