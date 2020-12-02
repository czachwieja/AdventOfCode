package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part1PasswordPhilosophy {

    static final String pathToInputFileDay2 = "2020/day2/input.txt";

    public static void main(String[] args) {

        File file = new File(pathToInputFileDay2);

        try (Scanner scanner = new Scanner(file)) {
            int counter = 0;

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("[- ]");

                int lowestNumberOfOccurrences = Integer.parseInt(line[0]);
                int highestNumberOfOccurrences = Integer.parseInt(line[1]);
                char letterToAppear = line[2].charAt(0);
                char[] charsArrayFromPassword = line[3].toCharArray();

                int numberOfOccurrences = 0;

                for (char c : charsArrayFromPassword) {
                    if (c == letterToAppear) {
                        numberOfOccurrences++;
                    }
                }

                if (numberOfOccurrences >= lowestNumberOfOccurrences
                        && numberOfOccurrences <= highestNumberOfOccurrences) {
                    counter++;
                }
            }

            System.out.println(counter);

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToInputFileDay2);
        }
    }
}
