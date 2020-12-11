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
        int counterEveryoneYes = 0;
        int lineCounter = 0;
        
        StringBuilder sb = new StringBuilder();

        for (String s : inputList) {
            sb.append(s);
            if (s.isEmpty()) {
                counterAnyoneYes += countUniqueCharsInStringBuilder(sb);
                counterEveryoneYes += countEveryOneSaidYes(sb, lineCounter);
                sb = new StringBuilder();
                lineCounter = 0;
            } else {
                lineCounter++;
            }
        }

        // last sb
        //part 1
        counterAnyoneYes += countUniqueCharsInStringBuilder(sb);
        System.out.println(counterAnyoneYes);

        // part 2
        counterEveryoneYes += countEveryOneSaidYes(sb, lineCounter);
        System.out.println(counterEveryoneYes);
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

    private static int countEveryOneSaidYes(StringBuilder sb, int lineCounter) {

        int countEveryOneSaidYes = 0;
        List<Character> characterList = new ArrayList<>();
        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < sb.length(); i++) {
            char charAt = sb.charAt(i);
            characterList.add(charAt);
            characterSet.add(charAt);
        }

        for (Character character : characterSet) {
            if (Collections.frequency(characterList, character) == lineCounter) {
                countEveryOneSaidYes++;
            }
        }
        return countEveryOneSaidYes;
    }
}