package day1;

import java.util.List;

import static day1.Day1Part1ReportRepair.*;

public class Day1Part2ReportRepair {
    public static void main(String[] args) {

        List<Integer> expensesList = getListFromInput();

        int listSize = expensesList.size();

        for (int i = 0; i < listSize; i++) {
            for (int j = 0; j < listSize; j++) {
                for (Integer integer : expensesList) {
                    if (expensesList.get(i) + expensesList.get(j) + integer == 2020) {
                        System.out.println(expensesList.get(i) * expensesList.get(j) * integer);
                        i = listSize;
                        j = expensesList.size();
                        break;
                    }
                }
            }
        }
    }
}