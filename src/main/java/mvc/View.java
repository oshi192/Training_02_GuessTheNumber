package mvc;

import util.ConsoleColors;
import util.GameConstants;

import java.util.List;

public class View implements ConsoleColors, GameConstants {
    private View() {

    }

    static void printMessage(String message) {
        System.out.println(message);
    }

    static void printRangMessage(int min, int max) {
        System.out.println("The number before " + min + " and " + max);
    }

    static void printPointersBar(int min, int max, int range) {
        for (int i = 0; i < min * LENGTH_MAX / range; i++) {
            System.out.print(" ");
        }
        System.out.print("V");
        for (int i = min * LENGTH_MAX / range + 1; i < max * LENGTH_MAX / range; i++) {
            System.out.print(" ");
        }
        System.out.println("V");

        printStatusBar(min,max,range);
    }

    private static void printStatusBar(int min, int max, int range) {
        for (int i = 0; i <= LENGTH_MAX; i++) {
            if (i <= min * LENGTH_MAX / range | i >= max * LENGTH_MAX / range) {
                System.out.print(GREEN + "#");
            } else {
                System.out.print(RED + "#");
            }
        }
        System.out.println(RESET);
    }

    static void printStatistics(List<String> inputs) {
        System.out.println("Your statistics: ");
        for (String s : inputs) {
            if (s.charAt(0) != INVALID.charAt(0)) {
                System.out.println(GREEN + s);
            } else {
                System.out.println(RED + "\t" + s);
            }
            System.out.println(RESET);
        }
    }
}
