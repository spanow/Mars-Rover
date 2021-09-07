package marsrover.command;


import marsrover.BaseTest;
import marsrover.direction.NorthDirection;
import marsrover.direction.WestDirection;
import marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpinLeftCommandTest extends BaseTest {

    @Before
    public void setUp() {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        command = new SpinLeftCommand();
    }

    @Test
    public void whenSpinLeftCommandIsExecutedRoverSpinsLeft() {
        command.execute(rover);
        assertEquals(WestDirection.class, rover.getDirection().getClass());
    }
}
