package day6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Day6CustomCustoms {
    public static void main(String[] args) {

        String pathToInputFileDay6 = "2020/day6/input.txt";
        List<String> inputList = getListFromInput(pathToInputFileDay6);

        int counterAnyoneYes = 0;
        StringBuilder sb = new StringBuilder();

        for (String s : inputList) {
            sb.append(s);
            if (s.isEmpty()) {
                counterAnyoneYes += countUniqueCharsInStringBuilder(sb);
                sb = new StringBuilder();
            }
        }

        // last sb
        counterAnyoneYes += countUniqueCharsInStringBuilder(sb);
        System.out.println(counterAnyoneYes);
    }

    private static List<String> getListFromInput(String pathToInputFileDay6) {
        List<String> inputList = new ArrayList<>();
        try {
            inputList = Files.lines(Path.of(pathToInputFileDay6)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    private static int countUniqueCharsInStringBuilder(StringBuilder sb) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < sb.length(); i++) {
            characterSet.add(sb.charAt(i));
        }
        return characterSet.size();
    }
}