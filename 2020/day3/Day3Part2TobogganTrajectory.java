package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static day3.Day3Part1TobogganTrajectory.pathToInputFileDay3;

public class Day3Part2TobogganTrajectory {

    public static void main(String[] args) {

        long numberOfTreesOnSlope1 = countNumberOfTrees(1, 1);
        long numberOfTreesOnSlope2 = countNumberOfTrees(3, 1);
        long numberOfTreesOnSlope3 = countNumberOfTrees(5, 1);
        long numberOfTreesOnSlope4 = countNumberOfTrees(7, 1);
        long numberOfTreesOnSlope5 = countNumberOfTrees(1, 2);

        System.out.println(numberOfTreesOnSlope1
                * numberOfTreesOnSlope2
                * numberOfTreesOnSlope3
                * numberOfTreesOnSlope4
                * numberOfTreesOnSlope5);
    }

    private static int countNumberOfTrees(int shiftRight, int shiftDown) {

        File file = new File(pathToInputFileDay3);
        int treesCount = 0;

        try (Scanner scanner = new Scanner(file)) {

            int numberOfColumns = scanner.nextLine().length();
            int positionX = 0;

            while (scanner.hasNextLine()) {
                for (int i = 1; i < shiftDown; i++) {
                    scanner.nextLine();
                }
                String line = scanner.nextLine();
                positionX += shiftRight;
                char position = line.charAt(positionX % numberOfColumns);
                if (position == '#') treesCount++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToInputFileDay3);
        }

        return treesCount;
    }
}
