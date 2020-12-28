package day8;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        HandheldHalting handheldHalting = new HandheldHalting();
        List<String> inputList = handheldHalting.inputList;

        int accumulator = getAccumulator(inputList);
        System.out.println("Loop starts at value = " + accumulator + " in the accumulator.");

    }

    private static int getAccumulator(List<String> inputList) {

        int accumulator = 0;
        List<Integer> iterationsList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            if (iterationsList.contains(i)) {
                break;
            }
            iterationsList.add(i);
            String[] instruction = inputList.get(i).split(" ");
            String operation = instruction[0];
            int argument = Integer.parseInt(instruction[1]);
            switch (operation) {
                case "acc":
                    accumulator += argument;
                    break;
                case "jmp":
                    i += argument - 1;
                    break;
                case "nop":
                    break;
            }
        }
        return accumulator;
    }
}
