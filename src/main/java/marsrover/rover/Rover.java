package marsrover.rover;


import marsrover.command.ICommand;
import marsrover.direction.IDirection;
import marsrover.exceptions.InvalideCoordinateException;
import marsrover.exceptions.RoverOutOfBoundsException;
import marsrover.landingsurface.Plateau;
import marsrover.landingsurface.Point;

import java.util.ArrayList;

public class Rover {

    private final Plateau plateau;
    private Point coordinates = new Point(0,0);
    private IDirection direction;

    public Rover(Plateau plateau, int coordinateX, int coordinateY, IDirection direction) {
        if (coordinateX<0||coordinateY<0) throw new InvalideCoordinateException();
        if (plateau == null) throw new NullPointerException("The plateau can't be null");
        if (direction == null) throw new NullPointerException("The direction can't be null");

        this.plateau = plateau;
        this.coordinates.setX(coordinateX);
        this.coordinates.setY(coordinateY);
        this.direction = direction;
        validateLocation();
    }

    private Plateau getPlateau() {
        return plateau;
    }

    public int getCoordinateX() {
        return coordinates.getX();
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinates.setX(coordinateX);
    }

    public int getCoordinateY() {
        return coordinates.getY();
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinates.setY(coordinateY);
    }

    public IDirection getDirection() {
        return direction;
    }

    public void setDirection(IDirection direction) {
        this.direction = direction;
    }

    public void executeCommandList(ArrayList<ICommand> commands) {
        for (ICommand command : commands)
            command.execute(this);
    }

    public void spinRight() {
        direction = getDirection().spinRight();
    }

    public void spinLeft() {
        direction = getDirection().spinLeft();
    }

    public void moveForward() {
        getDirection().moveForward(this);
        validateLocation();
    }


    public String broadcastLocation() {
        return coordinates.getX() + " "
                + coordinates.getY() + " "
                + getDirection().getClass().getSimpleName().charAt(0);
    }

    private void validateLocation() {
        if (this.getCoordinateX() > this.getPlateau().getUpperBoundCoordinateX()
                || this.getCoordinateY() > this.getPlateau().getUpperBoundCoordinateY()
                || this.getCoordinateX() < this.getPlateau().getLowerBoundCoordinateX()
                || this.getCoordinateY() < this.getPlateau().getLowerBoundCoordinateY()
        )
            throw new RoverOutOfBoundsException();
    }
}
