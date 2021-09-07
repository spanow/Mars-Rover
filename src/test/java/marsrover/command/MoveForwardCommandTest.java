package marsrover.command;

import marsrover.BaseTest;
import marsrover.direction.NorthDirection;
import marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoveForwardCommandTest extends BaseTest {

    @Before
    public void setUp() {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        command = new MoveForwardCommand();
    }

    @Test
    public void whenMoveForwardCommandIsExecutedRoverMovesForward() {
        command.execute(rover);
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }
}
