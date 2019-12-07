package day4;

public class Day4 {

    public static void main(String[] args) {

        int inputStart = 109165;
        int inputEnd = 576723;
        int amountOfPasswords = 0;

        for (; inputStart <= inputEnd; inputStart++) {
            if (checkAdjacentDigits(inputStart) && checkIfDigitsNeverDecrease(inputStart)) {
                amountOfPasswords++;
            }
        }

        System.out.println("--- Day 4: Secure Container ---");
        System.out.println(amountOfPasswords + " different passwords within the range given in the puzzle input meet these criteria.");

    }

    private static boolean checkAdjacentDigits(int password) {

        String passwordToString = Integer.toString(password);

        for (int i = 0; i < passwordToString.length() - 1; i++) {
            if (passwordToString.charAt(i) == passwordToString.charAt(i + 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkIfDigitsNeverDecrease(int password) {

        String passwordToString = Integer.toString(password);

        for (int i = 0; i < passwordToString.length() - 1; i++) {
            if (passwordToString.charAt(i) > passwordToString.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
