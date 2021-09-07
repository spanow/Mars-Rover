package marsrover.rover;

import com.sun.javafx.scene.traversal.Direction;
import marsrover.BaseTest;
import marsrover.command.ICommand;
import marsrover.command.MoveForwardCommand;
import marsrover.command.SpinLeftCommand;
import marsrover.command.SpinRightCommand;
import marsrover.direction.EastDirection;
import marsrover.direction.NorthDirection;
import marsrover.direction.WestDirection;
import marsrover.landingsurface.Plateau;
import marsrover.landingsurface.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoverTest extends BaseTest {


    @Test
    public void whenRequestedRoverCanSpinRight() throws Exception {
        NorthDirection direction = new NorthDirection();
        Rover rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        rover.spinRight();
        assertEquals(EastDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenRequestedRoverCanSpinLeft() throws Exception {
        NorthDirection direction = new NorthDirection();
        Rover rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        rover.spinLeft();
        assertEquals(WestDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenRequestedRoverCanMoveForward() throws Exception {
        NorthDirection direction = new NorthDirection();
        Rover rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        rover.moveForward();
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }



    @Test
    public void whenRequestedRoverCanPrintCurrentPosition() throws Exception {
        NorthDirection direction = new NorthDirection();
        Rover rover = new Rover(plateau, xCoordinate, yCoordinate, direction);

        assertEquals(xCoordinate + " "
                + yCoordinate + " "
                + direction.getClass().getSimpleName().charAt(0), rover.broadcastLocation());
    }

    @Test
    public void whenRequestedRoverCanExecuteCommandAsAList()  throws NullPointerException {
        NorthDirection direction = new NorthDirection();
        Rover rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        ArrayList<ICommand> commandArrayList = new ArrayList<>();
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinLeftCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinRightCommand());
        rover.executeCommandList(commandArrayList);

        assertEquals(1, rover.getCoordinateX());
        assertEquals(4, rover.getCoordinateY());
        assertEquals(NorthDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenHardCodedTestInputIsRunCorrectOutputIsReturned() {
        // Test Input:
        // 5 5
        Plateau plateau = new Plateau(new Point(5,5));

        // 1 2 N
        Rover roverOne = new Rover(plateau, 1, 2, new NorthDirection());

        // LMLMLMLMM
        ArrayList<ICommand> roverOneCommands = new ArrayList<>();
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOne.executeCommandList(roverOneCommands);

        // 3 3 E
        Rover roverTwo = new Rover(plateau, 3, 3, new EastDirection());

        // MMRMMRMRRM
        ArrayList<ICommand> roverTwoCommands = new ArrayList<>();
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwo.executeCommandList(roverTwoCommands);

        // Expected Output:
        // 1 3 N
        assertEquals(1, roverOne.getCoordinateX());
        assertEquals(3, roverOne.getCoordinateY());
        assertEquals(NorthDirection.class, roverOne.getDirection().getClass());

        // 5 1 E
        assertEquals(5, roverTwo.getCoordinateX());
        assertEquals(1, roverTwo.getCoordinateY());
        assertEquals(EastDirection.class, roverTwo.getDirection().getClass());
    }
}
