package day7;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static util.Utilities.getListFromInput;

public class HandyHaversacks {

    private static final String PATH_TO_INPUT_FILE_DAY_7 = "2020/day7/input.txt";
    private static final String SHINY_GOLD = "shiny gold";
    private static final String BAGS_CONTAIN = " bags contain ";
    private static final String SHINY_GOLD_BAGS_CONTAIN = SHINY_GOLD + BAGS_CONTAIN;
    private static final String REGEX_COMMA_SPACE = ", ";

    public static void main(String[] args) {

        List<String> inputList = getListFromInput(PATH_TO_INPUT_FILE_DAY_7);
        removeShinyGoldBag(inputList);
        int listSizeWithoutShinyGoldBag = inputList.size();

        removeBagColorFromList(inputList, SHINY_GOLD);
        int listSizeAfterRemoval = inputList.size();

        int amountOfRemovedElements = listSizeWithoutShinyGoldBag - listSizeAfterRemoval;

        System.out.println("https://adventofcode.com/2020/day/7");
        System.out.println("\nPART 1:\n" + amountOfRemovedElements + " bags colors can eventually contain at least one " + SHINY_GOLD + " bag.");

        // part2
        inputList = getListFromInput(PATH_TO_INPUT_FILE_DAY_7);

        int resultPart2 = countBagsInsideGivenBagColor(inputList, SHINY_GOLD);
        System.out.println("\nPART 2:\n" + resultPart2 + " individual bags are required inside your single " + SHINY_GOLD + " bag.");

    }

    private static int countBagsInsideGivenBagColor(List<String> inputList, String bagColor) {
        int counter = 1;
        String filteredLineIsPresent;

        Optional<String> filteredLine = inputList.stream().filter(s -> s.contains(bagColor + BAGS_CONTAIN)).findFirst();

        if (filteredLine.isEmpty()) {
            return 1;
        } else {
            filteredLineIsPresent = filteredLine.get();
        }

        // don't count "shiny gold bags contain..."
        if (filteredLineIsPresent.contains(SHINY_GOLD_BAGS_CONTAIN)) {
            counter--;
        }

        String[] colorAndContainingArray = filteredLineIsPresent.split(BAGS_CONTAIN);
        String[] containingArray = colorAndContainingArray[1].split(REGEX_COMMA_SPACE);

        for (String stringAfterContain : containingArray) {
            String[] newColorWithBag = stringAfterContain.split(" ");
            String newColor = newColorWithBag[1] + " " + newColorWithBag[2];
            int bagsInside = countBagsInsideGivenBagColor(inputList, newColor);

            int amountOfBags = 0;
            String amountOfBagsString = stringAfterContain.replaceAll("\\D", "");

            if (!amountOfBagsString.isEmpty()) {
                amountOfBags = Integer.parseInt(amountOfBagsString);
            }

            counter += amountOfBags * bagsInside;
        }

        return counter;
    }

    private static void removeShinyGoldBag(List<String> inputList) {
        inputList.removeIf(s -> s.contains(SHINY_GOLD_BAGS_CONTAIN));
    }

    private static void removeBagColorFromList(List<String> inputList, String bagColor) {

        Predicate<String> containBagColor = s -> s.contains(bagColor);
        List<String> listContainingBagColor = inputList.stream().filter(containBagColor).collect(Collectors.toList());

        inputList.removeAll(listContainingBagColor);

        for (String element : listContainingBagColor) {
            int indexOfBagsContains = element.indexOf(BAGS_CONTAIN);
            String subString = element.substring(0, indexOfBagsContains);
            removeBagColorFromList(inputList, subString);
        }
    }
}
