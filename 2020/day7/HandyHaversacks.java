package day7;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static util.Utilities.getListFromInput;

public class HandyHaversacks {

    public static final String PATH_TO_INPUT_FILE_DAY_7 = "2020/day7/input.txt";
    public static final String SHINY_GOLD = "shiny gold";
    public static final String BAGS_CONTAIN = " bags contain ";
    public static final String SHINY_GOLD_BAGS_CONTAIN = SHINY_GOLD + BAGS_CONTAIN;

    static List<String> inputList = getListFromInput(PATH_TO_INPUT_FILE_DAY_7);

    public static void main(String[] args) {

        removeShinyGoldBag();
        int listSizeWithoutShinyGoldBag = inputList.size();

        removeBagColorFromList(inputList, SHINY_GOLD);
        int listSizeAfterRemoval = inputList.size();

        int amountOfRemovedElements = listSizeWithoutShinyGoldBag - listSizeAfterRemoval;

        System.out.println(amountOfRemovedElements + " bags colors can eventually contain at least one " + SHINY_GOLD + " bag.");
    }

    private static void removeShinyGoldBag() {
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
