package marsrover.direction;


import marsrover.BaseTest;
import marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WestDirectionTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new WestDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
    }

    @Test
    public void whenWestDirectionTurnsRightNewDirectionIsNorth() {
        assertEquals(direction.spinRight().getClass(), NorthDirection.class);
    }

    @Test
    public void whenWestDirectionTurnsLeftNewDirectionIsSouth() {
        assertEquals(direction.spinLeft().getClass(), SouthDirection.class);
    }

    @Test
    public void whenWestDirectionMovesForwardCoordinateXDecrements() {
        direction.moveForward(rover);
        assertEquals(--xCoordinate, rover.getCoordinateX());
    }


}
