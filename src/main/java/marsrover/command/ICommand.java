package marsrover.command;

import marsrover.rover.Rover;

public interface ICommand {

    void execute(Rover rover);
}
