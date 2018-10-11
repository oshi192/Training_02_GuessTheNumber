package mvc;

import util.GameConstants;

import java.util.List;

class View implements GameConstants {
    private View() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of mvc.View");
    }

    static void printMessage(String message) {
        System.out.println(message);
    }

    static void printRangMessage(int min, int max) {
        System.out.println("The number before " + min + " and " + max);
    }

    /**
     * displaying available diapason in general
     * @param min - the lower value of available diapason
     * @param max - the higher value of available diapason
     * @param range - max length of general diapason on the screen (only for displaying)
     */
    static void printStatusBar(int min, int max, int range) {
        for (int i = 0; i <= LENGTH_MAX; i++) {
            if (i <= min * LENGTH_MAX / range || i >= max * LENGTH_MAX / range) {
                System.out.print("-");
            } else {
                System.out.print("#");
            }
        }
        System.out.println();
    }

    static void printStatistics(List<String> inputs) {
        System.out.println("Your statistics: ");
        for (String s : inputs) {
            System.out.println((s.charAt(0) != INVALID.charAt(0)) ? s : "\t" + s);
        }
    }
}
