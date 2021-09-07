package marsrover.command;


import marsrover.rover.Rover;

public class SpinLeftCommand implements ICommand {

    @Override
    public void execute(Rover rover) {
        rover.spinLeft();
    }
}
