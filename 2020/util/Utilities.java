package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Utilities {

    // Private constructor to prevent instantiation
    private Utilities() {
        throw new UnsupportedOperationException();
    }

    public static List<String> getListFromInput(String pathToInputFileDay6) {
        List<String> inputList = new ArrayList<>();
        try {
            inputList = Files.lines(Path.of(pathToInputFileDay6)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

}
