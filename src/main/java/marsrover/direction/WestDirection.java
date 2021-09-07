package marsrover.direction;


import marsrover.rover.Rover;

public class WestDirection implements IDirection {

    @Override
    public IDirection spinRight() {
        return new NorthDirection();
    }

    @Override
    public IDirection spinLeft() {
        return new SouthDirection();
    }

    @Override
    public void moveForward(Rover rover) {
        rover.setCoordinateX(rover.getCoordinateX() - 1);
    }

}
