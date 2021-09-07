package marsrover.direction;


import marsrover.rover.Rover;

public class SouthDirection implements IDirection {

    @Override
    public IDirection spinRight() {
        return new WestDirection();
    }

    @Override
    public IDirection spinLeft() {
        return new EastDirection();
    }

    @Override
    public void moveForward(Rover rover) {
        rover.setCoordinateY(rover.getCoordinateY() - 1);
    }

}
