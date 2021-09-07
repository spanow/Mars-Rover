package marsrover.direction;


import marsrover.rover.Rover;

public interface IDirection {

    IDirection spinRight();

    IDirection spinLeft();

    void moveForward(Rover rover);

}
