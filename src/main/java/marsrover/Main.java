package marsrover;

import marsrover.command.ICommand;
import marsrover.landingsurface.Plateau;
import marsrover.rover.Rover;
import marsrover.utils.InputUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {

            ArrayList<String> inputFileAsList = InputUtil.parseInputFromFile(Main.class.getResourceAsStream("/input.txt"));

            List<String> roverInput = inputFileAsList.subList(1, inputFileAsList.size());

            System.out.println("Fichier d'entrée:" + "\n");
            for (String line : inputFileAsList)
                System.out.println(line);

            System.out.println("\n" + "Sortie:" + "\n");
            Plateau plateau = InputUtil.parsePlateauInput(inputFileAsList.get(0));



            for (int i = 0; i < roverInput.size(); i += 2) {
                Rover rover = InputUtil.parsePositionInput(roverInput.get(i), plateau);

                ArrayList<ICommand> commands = InputUtil.parseCommandInput(roverInput.get(i + 1));

                rover.executeCommandList(commands);
            }

    }
}
