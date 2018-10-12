package mvc;

import enums.CompareValues;
import util.GameConstants;
import util.Reader;

public class GameController implements GameConstants {

    private Model model;

    public GameController() {
        model = new Model();
    }

    public void start() {
        View.printMessage(View.START);
        View.printMessage(View.THE_NUMBER_BEFORE + model.getMin() + View.AND + model.getMax());
        View.printMessage(View.RULES);
        model.setRangeBarrier(RAND_MIN, RAND_MAX);
        model.generateAskNumer();
        gameLoop();
        View.printStatistics(model.getInputs());
    }

    private void gameLoop() {
        while (compareValue(getNumberFromUser(model.getMin(), model.getMax()))) {
            View.printStatusBar(model.getMin(), model.getMax(), model.getRange());
        }
    }

    /**
     * compare parameter value to askNumber in model
     * and add values to models.inputList
     *
     * @param value - value to compare
     * @return - if they not equals return true
     */
    private boolean compareValue(int value) {
        boolean isNotEquals = true;
        if (value > model.getAskNumer()) {
            View.printMessage(View.IT_SMALLER);
            model.setMax(value);
            model.addToInputList(CompareValues.LOWER, Integer.toString(value));
        } else if (value < model.getAskNumer()) {
            View.printMessage(View.IT_BIGGER);
            model.setMin(value);
            model.addToInputList(CompareValues.BIGGER, Integer.toString(value));
        } else {
            View.printMessage(View.CONGRADULATION);
            isNotEquals = false;
            model.addToInputList(CompareValues.EQUALS, Integer.toString(value));
        }
        return isNotEquals;
    }

    /**
     * reads number from console in range from min value to max
     * if invalid entering - Viev displayed error message
     *
     * @param min - the lower value of range
     * @param max - the higher value of range
     * @return - valid value from range from min to max
     */
    private int getNumberFromUser(int min, int max) {
        String input;
        View.printMessage(View.ENTER_NUMBER + min + " - " + max + " :");
        while (true) {
            input = Reader.getString();
            if (input.matches("\\d+")) {
                if (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max) {
                    return Integer.parseInt(input);
                }
            }
            model.addToInputList(CompareValues.NOT_A_NUMBER, input);
            View.printMessage(View.INVALID_INPUT + min + View.INVALID + max);
        }
    }

}
