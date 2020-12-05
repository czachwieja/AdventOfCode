package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4Part1PassportProcessing {

    static final String pathToInputFileDay4 = "2020/day4/input.txt";

    public static void main(String[] args) {

        File file = new File(pathToInputFileDay4);

        try (Scanner scanner = new Scanner(file)) {

            StringBuilder stringBuilder = new StringBuilder();
            int validPassports = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilder.append(line).append(" ");
                if (line.isEmpty()) {
                    if (isPassportValid(stringBuilder)) {
                        validPassports++;
                    }
                    stringBuilder = new StringBuilder();
                }
            }

            // last password
            if (isPassportValid(stringBuilder)) {
                validPassports++;
            }

            System.out.println(validPassports);

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToInputFileDay4);
        }
    }

    private static boolean isPassportValid(StringBuilder stringBuilder) {
        int counter = (int) stringBuilder.toString().chars()
                .filter(ch -> ch == ':').count();
        switch (counter) {
            case 8:
                return true;
            case 7:
                if (!stringBuilder.toString().contains("cid:")) {
                    return true;
                }
            default:
                return false;
        }
    }
}
