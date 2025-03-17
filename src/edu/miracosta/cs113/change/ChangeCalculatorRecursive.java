package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

public class ChangeCalculatorRecursive extends ChangeCalculator {

    /**
     * Recursive method to calculate all unique combinations of coins that sum up to the given amount.
     *
     * @param cents the amount in cents
     * @return a list of all unique combinations of coins
     */
    public static List<String> calculateRecursive(int cents) {
        List<String> combinations = new ArrayList<>();
        calculateRecursiveHelper(cents, 0, 0, 0, cents, combinations);
        return combinations;
    }

    /**
     * Helper method for recursive calculation of coin combinations.
     *
     * @param cents     the remaining amount in cents
     * @param quarters  the number of quarters used so far
     * @param dimes     the number of dimes used so far
     * @param nickels   the number of nickels used so far
     * @param pennies   the number of pennies used so far
     * @param combinations the list to store valid combinations
     */
    private static void calculateRecursiveHelper(int cents, int quarters, int dimes, int nickels, int pennies, List<String> combinations) {

        if (cents == 0) {
            combinations.add(combinationToString(quarters, dimes, nickels, pennies));
            return;
        }

        if (cents >= COINS[Quarter]) {
            calculateRecursiveHelper(cents - COINS[Quarter], quarters + 1, dimes, nickels, pennies, combinations);
        }

        if (cents >= COINS[Dime]) {
            calculateRecursiveHelper(cents - COINS[Dime], quarters, dimes + 1, nickels, pennies, combinations);
        }

        if (cents >= COINS[Nickel]) {
            calculateRecursiveHelper(cents - COINS[Nickel], quarters, dimes, nickels + 1, pennies, combinations);
        }

        if (cents >= COINS[Penny]) {
            calculateRecursiveHelper(cents - COINS[Penny], quarters, dimes, nickels, pennies + 1, combinations);
        }
    }
}