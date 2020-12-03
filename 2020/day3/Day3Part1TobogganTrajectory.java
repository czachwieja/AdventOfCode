package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3Part1TobogganTrajectory {

    static final String pathToInputFileDay3 = "2020/day3/input.txt";

    public static void main(String[] args) {

        File file = new File(pathToInputFileDay3);

        try (Scanner scanner = new Scanner(file)) {

            int numberOfColumns = scanner.nextLine().length();
            int positionX = 0;
            int treesCounter = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                positionX += 3;
                char position = line.charAt(positionX % numberOfColumns);
                if (position == '#') treesCounter++;
            }

            System.out.println(treesCounter);

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToInputFileDay3);
        }
    }
}
