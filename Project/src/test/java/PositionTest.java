import GameCore.Position;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void moveTestEmptyConstructor() {
        Position pos = new Position();

        assertEquals(0,pos.getX());
        assertEquals(0,pos.getY());

        pos.move(3,4);

        assertEquals(3,pos.getX());
        assertEquals(4,pos.getY());
    }

    @Test
    public void moveTestConstructor() {
        Position pos = new Position(3,3);

        assertEquals(3,pos.getX());
        assertEquals(3,pos.getY());

        pos.move(3,4);

        assertEquals(6,pos.getX());
        assertEquals(7,pos.getY());
    }

    @Test
    public void setTest() {
        Position pos = new Position();

        pos.setX(12);
        pos.setY(41);

        assertEquals(12,pos.getX());
        assertEquals(41,pos.getY());
    }

    @Test
    public void equalsTest() {
        Position pos1 = new Position(1,2);
        Position pos2 = new Position(1,2);

        assertEquals(pos1,pos2);
    }
}
