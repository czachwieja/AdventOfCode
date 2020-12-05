package day4;

import com.google.common.collect.Range;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import static day4.Day4Part1PassportProcessing.pathToInputFileDay4;

public class Day4Part2PassportProcessing {

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
                return areFieldsValid(stringBuilder);
            case 7:
                if (!stringBuilder.toString().contains("cid:")) {
                    return areFieldsValid(stringBuilder);
                }
            default:
                return false;
        }
    }

    private static boolean areFieldsValid(StringBuilder stringBuilder) {
        HashMap<String, String> map = new HashMap<>();
        for (String s : String.valueOf(stringBuilder).split(" ")) {
            String[] e = s.split(":");
            if (map.put(e[0], e[1]) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }

        if (isFieldOutOfRange(Integer.parseInt(map.get("byr")), 1920, 2002)) return false;
        if (isFieldOutOfRange(Integer.parseInt(map.get("iyr")), 2010, 2020)) return false;
        if (isFieldOutOfRange(Integer.parseInt(map.get("eyr")), 2020, 2030)) return false;

        String height = map.get("hgt");
        if (height.contains("cm")) {
            if (isFieldOutOfRange(Integer.parseInt(height.replace("cm", "")), 150, 193)) return false;
        } else if (height.contains("in")) {
            if (isFieldOutOfRange(Integer.parseInt(height.replace("in", "")), 59, 76)) return false;
        } else {
            return false;
        }

        if (!map.get("hcl").matches("#[0-9a-f]{6}")) return false;
        if (!map.get("ecl").matches("amb|blu|brn|gry|grn|hzl|oth")) return false;
        if (!map.get("pid").matches("\\d{9}")) return false;

        return true;
    }

    private static boolean isFieldOutOfRange(int fieldValue, int atLeast, int atMost) {
        Range<Integer> range = Range.closed(atLeast, atMost);
        return !range.contains(fieldValue);
    }
}