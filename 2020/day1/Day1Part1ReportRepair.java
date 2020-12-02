package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Part1ReportRepair {
    protected static final String pathToInputFileDay1 = "2020/day1/input.txt";

    public static void main(String[] args) {

        List<Integer> expensesList = getListFromInput();

        for (int i = 0; i < expensesList.size(); i++) {
            for (Integer integer : expensesList) {
                if (expensesList.get(i) + integer == 2020) {
                    System.out.println(expensesList.get(i) * integer);
                    i = expensesList.size();
                    break;
                }
            }
        }

    }

    static List<Integer> getListFromInput() {
        File file = new File(pathToInputFileDay1);

        List<Integer> integerList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                integerList.add(Integer.valueOf(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToInputFileDay1);
        }

        return integerList;
    }
}