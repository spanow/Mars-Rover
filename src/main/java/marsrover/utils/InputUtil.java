package marsrover.utils;


import marsrover.command.CommandEnum;
import marsrover.command.ICommand;
import marsrover.direction.DirectionEnum;
import marsrover.direction.IDirection;
import marsrover.landingsurface.Plateau;
import marsrover.landingsurface.Point;
import marsrover.rover.Rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputUtil {

    public static ArrayList<String> parseInputFromFile(InputStream fileLocation) throws IOException {
        ArrayList<String> inputsFromFile = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileLocation));
        String fileLine;

        while ((fileLine = bufferedReader.readLine()) != null)
            inputsFromFile.add(fileLine);

        bufferedReader.close();
        return inputsFromFile;
    }

    public static Plateau parsePlateauInput(String plateauInput) {
        String[] inputArray = plateauInput.split(" ");
        int plateauUpperBoundCoordinateX = Integer.parseInt(inputArray[0]);
        int plateauUpperBoundCoordinateY = Integer.parseInt(inputArray[1]);
        Point upperBound = new Point(plateauUpperBoundCoordinateX,plateauUpperBoundCoordinateY);
        return new Plateau(upperBound);
    }

    public static Rover parsePositionInput(String positionInput, Plateau plateau) {
        String[] inputArray = positionInput.split(" ");
        int roverLandingCoordinateX = Integer.parseInt(inputArray[0]);
        int roverLandingCoordinateY = Integer.parseInt(inputArray[1]);
        IDirection direction = DirectionEnum.valueOf(inputArray[2]).getDirection();
        return new Rover(plateau, roverLandingCoordinateX, roverLandingCoordinateY, direction);
    }

    public static ArrayList<ICommand> parseCommandInput(String command) {
        char[] inputArray = command.toCharArray();
        ArrayList<ICommand> commandArrayList = new ArrayList<>();

        for (char character : inputArray) {
            ICommand currentCommand = CommandEnum.valueOf(Character.toString(character)).getCommand();
            commandArrayList.add(currentCommand);
        }

        return commandArrayList;
    }
}
