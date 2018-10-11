package mvc;

import util.GameConstants;

import java.util.List;

class View implements GameConstants {
    private View() {

    }

    static void printMessage(String message) {
        System.out.println(message);
    }

    static void printRangMessage(int min, int max) {
        System.out.println("The number before " + min + " and " + max);
    }

    static void printStatusBar(int min, int max, int range) {
        for (int i = 0; i <= LENGTH_MAX; i++) {
            if (i <= min * LENGTH_MAX / range || i >= max * LENGTH_MAX / range) {
                System.out.print("-");
            } else {
                System.out.print("#");
            }
        }
    }

    static void printStatistics(List<String> inputs) {
        System.out.println("Your statistics: ");
        for (String s : inputs) {
            System.out.println((s.charAt(0) != INVALID.charAt(0)) ? s : "\t" + s);
        }
    }
}
