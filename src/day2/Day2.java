package day2;

import java.util.Arrays;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {

        System.out.println("--- Day 2: 1202 Program Alarm ---\n");

        List<Integer> input = inputAsAList();
        input.set(1, 12);
        input.set(2, 2);
        int opcode = 1;

        for (int i = 0; opcode != 99; i += 4) {

            opcode = input.get(i);
            int number1 = input.get(i + 1);
            int number2 = input.get(i + 2);
            int output = input.get(i + 3);

            if (opcode == 1) {
                input.set(output, input.get(number1) + input.get(number2));
            } else if (opcode == 2) {
                input.set(output, input.get(number1) * input.get(number2));
            } else if (opcode == 99) {
                System.out.println("Program is finished.");
            } else {
                System.out.println("Something went wrong! -_-");
            }
        }

        System.out.println("Value at position 0 is: " + input.get(0));

    }

    private static List<Integer> inputAsAList() {
        Integer[] inputTable = new Integer[]{1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 6, 1, 19, 1, 19, 9, 23, 1, 23, 9, 27, 1, 10, 27, 31, 1, 13, 31, 35, 1, 35, 10, 39, 2, 39, 9, 43, 1, 43, 13, 47, 1, 5, 47, 51, 1, 6, 51, 55, 1, 13, 55, 59, 1, 59, 6, 63, 1, 63, 10, 67, 2, 67, 6, 71, 1, 71, 5, 75, 2, 75, 10, 79, 1, 79, 6, 83, 1, 83, 5, 87, 1, 87, 6, 91, 1, 91, 13, 95, 1, 95, 6, 99, 2, 99, 10, 103, 1, 103, 6, 107, 2, 6, 107, 111, 1, 13, 111, 115, 2, 115, 10, 119, 1, 119, 5, 123, 2, 10, 123, 127, 2, 127, 9, 131, 1, 5, 131, 135, 2, 10, 135, 139, 2, 139, 9, 143, 1, 143, 2, 147, 1, 5, 147, 0, 99, 2, 0, 14, 0};
        return Arrays.asList(inputTable);
    }

}