package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1Part1ReportRepair {
    public static void main(String[] args) {

        String pathToFile = "2020/day1/input.txt";
        File file = new File(pathToFile);

        List<Integer> expensesList = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                expensesList.add(Integer.valueOf(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }

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
}