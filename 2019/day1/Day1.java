package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {

        double sum = 0.0;
        double sumOfAllModules = 0.0;

        File file = new File("src/day1/input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            double sumPerModule = 0.0;
            double mass = scanner.nextInt();
            double fuel = Math.floor(mass / 3) - 2;
            sum += fuel;
            while (fuel > 0) {
                sumPerModule += fuel;
                fuel = Math.floor(fuel / 3) - 2;
            }
            sumOfAllModules += sumPerModule;
        }

        System.out.println("--- Day 1: The Tyranny of the Rocket Equation ---\n");
        System.out.println("The sum of the fuel requirements for all of the modules on my spacecraft is " + (int) (sum));
        System.out.println("The sum of the fuel requirements for all of the modules on my spacecraft when also taking into account the mass of the added fuel is " + (int) (sumOfAllModules));

    }

}