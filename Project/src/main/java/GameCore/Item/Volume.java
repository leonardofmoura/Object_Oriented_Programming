package GameCore.Item;

import java.util.Objects;

public class Volume {
    private int volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume1 = (Volume) o;
        return getVolume() == volume1.getVolume();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVolume());
    }

    public Volume(int volume){
        if(volume > 0){
            this.volume = volume;
        } else{
            this.volume = 0;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void increase(int i){
        this.volume += i;
    }

    public void decrease(int i){
        this.volume -= i;
    }


}
