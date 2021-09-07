package marsrover.command;


import marsrover.rover.Rover;

public class MoveForwardCommand implements ICommand {

    @Override
    public void execute(Rover rover) {
        rover.moveForward();
    }
}
