package mvc;

import javafx.util.Pair;
import util.GameConstants;

import java.util.List;

class View implements GameConstants {
    private static final String YOUR_STATISTICS = "Your statistics: ";
    private static final String STATUS_BAR_OUT_OF_RANGE = "-";
    private static final String STATUS_BAR_IN_RANGE = "#";
    private static final String TAB = "\t";
    static final String INVALID_INPUT = "invalid input , try again. Only numbers: ";
    static final String CONGRADULATION = " Right! it is my number! Congratulations!!";
    static final String START = "I think a number? will you try to guess?";
    static final String RULES = "you will enter the number and I will response: my number it smaller or bigger than yours";
    static final String ENTER_NUMBER = "your number ";
    static final String INVALID = "-";
    static final String IT_SMALLER = " -- smaller -- ";
    static final String IT_BIGGER = " -- bigger --- ";
    static final String AND = " and ";
    static final String THE_NUMBER_BEFORE = "The number before ";


    private View() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of mvc.View");
    }

    static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * displaying available diapason in general
     *
     * @param min   - the lower value of available diapason
     * @param max   - the higher value of available diapason
     * @param range - max length of general diapason on the screen (only for displaying)
     */
    static void printStatusBar(int min, int max, int range) {
        for (int i = 0; i <= STATUS_BAR_DISPLAYING_LENGTH; i++) {
            if (i <= min * STATUS_BAR_DISPLAYING_LENGTH / range || i >= max * STATUS_BAR_DISPLAYING_LENGTH / range) {
                System.out.print(STATUS_BAR_OUT_OF_RANGE);
            } else {
                System.out.print(STATUS_BAR_IN_RANGE);
            }
        }
        System.out.println();
    }

    static void printStatistics(List<Pair<String, String>> inputs) {
        System.out.println(YOUR_STATISTICS);
        for (Pair<String, String> pair : inputs) {
            System.out.println((pair.getValue() + TAB + pair.getKey()));
        }
    }
}
