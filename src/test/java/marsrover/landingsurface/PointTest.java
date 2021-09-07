package marsrover.landingsurface;

import marsrover.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest extends BaseTest {

    @Test
    public void setXTest() {
        newPoint.setX(6);
        assertEquals(6, newPoint.getX());
    }

    @Test
    public void setYTest() {
        newPoint.setY(6);
        assertEquals(6, newPoint.getY());
    }
}
