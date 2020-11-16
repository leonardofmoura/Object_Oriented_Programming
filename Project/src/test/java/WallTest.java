import GameCore.Position;
import GameCore.MapElements.Wall;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class WallTest {
    @Test
    public void wallPositionConstructorTest() {
        Position pos = new Position(2,3);

        Wall wall = new Wall(2,3);

        assertEquals(pos,wall.getPosition());
    }

    @Test
    public void wallPositionParameterConstructorTest() {
        Wall wall = new Wall(2,3);
        Position pos = new Position(2,3);

        assertEquals(pos,wall.getPosition());
    }

}
