package marsrover.exceptions;

import marsrover.BaseTest;
import marsrover.direction.NorthDirection;
import marsrover.landingsurface.Plateau;
import marsrover.landingsurface.Point;
import marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

public class InvalideCoordinateExceptionTest extends BaseTest {
    @Before
    public void setUp() throws Exception {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
    }

    @Test(expected = InvalideCoordinateException.class)
    public void whenRoverIsCreatedWithANegativeXCoordinateValueExceptionIsThrown() {
        new Rover(plateau, -5, yCoordinate, direction);
    }

    @Test(expected = InvalideCoordinateException.class)
    public void whenRoverIsCreatedWithANegativeYCoordinateValueExceptionIsThrown() {
        new Rover(plateau, xCoordinate, -5, direction);
    }

    @Test(expected = InvalideCoordinateException.class)
    public void whenPlateauIsCreatedWithANegativeYCoordinateValueExceptionIsThrown() {
        Plateau plateau= new Plateau(new Point(5,-5));
    }

    @Test(expected = InvalideCoordinateException.class)
    public void whenPlateauIsCreatedWithANegativeXCoordinateValueExceptionIsThrown() {
        Plateau plateau= new Plateau(new Point(-5,5));
    }

}
