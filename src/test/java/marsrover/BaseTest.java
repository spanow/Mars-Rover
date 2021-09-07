package marsrover;


import marsrover.command.ICommand;
import marsrover.direction.IDirection;
import marsrover.landingsurface.Plateau;
import marsrover.landingsurface.Point;
import marsrover.rover.Rover;

public abstract class BaseTest {

    protected final Plateau plateau = new Plateau(new Point(5,5));
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected Point newPoint = new Point(xCoordinate,yCoordinate);
    protected IDirection direction;
    protected Rover rover;
    protected ICommand command;
}
