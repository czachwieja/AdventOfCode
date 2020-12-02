package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static day2.Day2Part1PasswordPhilosophy.pathToInputFileDay2;

public class Day2Part2PasswordPhilosophy {

    public static void main(String[] args) {

        File file = new File(pathToInputFileDay2);

        try (Scanner scanner = new Scanner(file)) {
            int counter = 0;

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("[- ]");

                int firstPosition = Integer.parseInt(line[0]) - 1;
                int secondPosition = Integer.parseInt(line[1]) - 1;
                char letterToAppear = line[2].charAt(0);
                String password = line[3];

                if (password.charAt(firstPosition) == letterToAppear
                        ^ password.charAt(secondPosition) == letterToAppear) {
                    counter++;
                }
            }

            System.out.println(counter);

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToInputFileDay2);
        }
    }
}
