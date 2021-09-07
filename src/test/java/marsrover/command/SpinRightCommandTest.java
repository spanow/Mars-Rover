package marsrover.command;


import marsrover.BaseTest;
import marsrover.direction.EastDirection;
import marsrover.direction.NorthDirection;
import marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpinRightCommandTest extends BaseTest {

    @Before
    public void setUp() {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        command = new SpinRightCommand();
    }

    @Test
    public void whenSpinRightCommandIsExecutedRoverSpinsRight() {
        command.execute(rover);
        assertEquals(EastDirection.class, rover.getDirection().getClass());
    }
}
