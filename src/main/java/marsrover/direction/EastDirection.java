package marsrover.direction;


import marsrover.rover.Rover;

public class EastDirection implements IDirection {

    @Override
    public IDirection spinRight() {
        return new SouthDirection();
    }

    @Override
    public IDirection spinLeft() {
        return new NorthDirection();
    }

    @Override
    public void moveForward(Rover rover) {
        rover.setCoordinateX(rover.getCoordinateX() + 1);
    }

}
