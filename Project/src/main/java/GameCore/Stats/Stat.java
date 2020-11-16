package GameCore.Stats;

import java.util.ArrayList;
import java.util.List;

public class Stat {
    int value;


    private List<Integer> buff_buffer = new ArrayList<> ();
    Stat(int value){
        this.value = (value >= 0) ? value : 0;
    }

    public int getValue() {
        int tmp = value;
        for (int val: buff_buffer) {
            tmp += val;
        }
        return (tmp >= 0) ? tmp : 0;
    }

    public void setValue(int value) {
        this.value = (value >= 0) ? value : 0;
    }

    void add_buff(int value){
        this.buff_buffer.add(value);
    }

    void clear_buffs(){
        this.buff_buffer.clear();
    }

    public List<Integer> getBuff_buffer() {
        return buff_buffer;
    }
}
