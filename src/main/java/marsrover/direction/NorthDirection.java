package marsrover.direction;


import marsrover.rover.Rover;

public class NorthDirection implements IDirection {

    @Override
    public IDirection spinRight() {
        return new EastDirection();
    }

    @Override
    public IDirection spinLeft() {
        return new WestDirection();
    }

    @Override
    public void moveForward(Rover rover) {
        rover.setCoordinateY(rover.getCoordinateY() + 1);
    }

}
