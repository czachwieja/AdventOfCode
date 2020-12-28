package day8;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        HandheldHalting handheldHalting = new HandheldHalting();
        List<String> inputList = handheldHalting.inputList;

        int accumulator = getAccumulator(inputList, 1);
        System.out.println("Loop starts at value = " + accumulator + " in the accumulator.");

        accumulator = getAccumulatorWhenProgramTerminates(inputList);
        System.out.println("Program terminates at value of the accumulator = " + accumulator + ".");

    }

    private static int getAccumulatorWhenProgramTerminates(List<String> inputList) {

        int accumulator = 0;

        for (int i = 0; i < inputList.size(); i++) {
            String instruction = inputList.get(i);

            if (instruction.contains("jmp")) {
                inputList.set(i, instruction.replace("jmp", "nop"));
            } else if (instruction.contains("nop")) {
                inputList.set(i, instruction.replace("nop", "jmp"));
            }

            accumulator = getAccumulator(inputList, 2);
            if (accumulator != -1) {
                break;
            }
            inputList.set(i, instruction);
        }
        return accumulator;
    }

    private static int getAccumulator(List<String> inputList, int part) {

        int accumulator = 0;
        List<Integer> iterationsList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            if (iterationsList.contains(i)) {
                if (part == 2 && i < inputList.size() - 1) {
                    accumulator = -1;
                }
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
