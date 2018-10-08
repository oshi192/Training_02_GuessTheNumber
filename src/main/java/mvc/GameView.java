package mvc;

import util.ConsoleColors;
import util.GameConstants;

import java.util.List;

class GameView implements ConsoleColors, GameConstants {
    void printStartMessage(int min, int max) {
        System.out.println("I think a number? will you try to guess?");
        System.out.println("The number before " + min + " and " + max);
        System.out.println("you will enter the number and I will response: my number it smaller or bigger than yours");
    }

    void printFinishMessage() {
        System.out.println(" Right! it is my number! Congratulations!!");
    }

    void printStatistics(List<String> inputs) {
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

    void printStatusBar(int min, int max, int range) {
        for (int i = 0; i < min * LENGTH_MAX / range; i++) {
            System.out.print(" ");
        }
        System.out.print("V");
        for (int i = min * LENGTH_MAX / range + 1; i < max * LENGTH_MAX / range; i++) {
            System.out.print(" ");
        }
        System.out.println("V");
        for (int i = 0; i <= LENGTH_MAX; i++) {
            if (i <= min * LENGTH_MAX / range | i >= max * LENGTH_MAX / range) {
                System.out.print(GREEN + "#");
            } else {
                System.out.print(RED + "#");
            }
        }
        System.out.println(RESET);
    }

}
