package marsrover.command;


import marsrover.rover.Rover;

public class SpinRightCommand implements ICommand {

    @Override
    public void execute(Rover rover) {
        rover.spinRight();
    }
}
