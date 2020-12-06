package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5BinaryBoarding {

    private static final String pathToInputFileDay5 = "2020/day5/input.txt";

    public static void main(String[] args) {

        File file = new File(pathToInputFileDay5);

        try (Scanner scanner = new Scanner(file)) {

            List<Integer> integerList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String frontBack = line.substring(0, 7).replaceAll("F", "0").replaceAll("B", "1");
                String leftRight = line.substring(7).replaceAll("L", "0").replaceAll("R", "1");

                String binary = frontBack + leftRight;

                integerList.add(Integer.parseInt(binary, 2));
            }

            // part1
            int max = Collections.max(integerList);
            int maxSeatId = getSeatId(max);
            System.out.println(maxSeatId);

            // part2
            List<Integer> listOfAllId = IntStream.rangeClosed(Collections.min(integerList), Collections.max(integerList))
                    .boxed().collect(Collectors.toList());

            listOfAllId.removeAll(integerList);
            System.out.println(listOfAllId);

        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToInputFileDay5);
        }
    }

    private static int getSeatId(int binaryInteger) {
        String binaryMax = Integer.toBinaryString(binaryInteger);
        String frontBackFromMax = binaryMax.substring(0, 7);
        String leftRightFromMax = binaryMax.substring(7);
        if (leftRightFromMax.equals("")) {
            leftRightFromMax = "0";
        }
        return Integer.parseInt(frontBackFromMax, 2) * 8 + Integer.parseInt(leftRightFromMax, 2);
    }

}
