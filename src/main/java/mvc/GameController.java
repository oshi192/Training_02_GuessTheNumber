package mvc;

import util.GameConstants;
import util.Reader;

import java.util.Random;

public class GameController implements GameConstants {

    private Model model;

    public GameController() {
        model = new Model();
    }

    public void start() {
        View.printMessage(View.START);
        View.printMessage(View.THE_NUMBER_BEFORE + model.getMin() + View.AND + model.getMax());
        View.printMessage(View.RULES);
        model.setRangeBarrier(RAND_MIN,RAND_MAX);
        model.generateAskNumer();
        gameLoop();
        View.printMessage(View.CONGRADULATION);
        View.printStatistics(model.getInputs());
    }

    private void gameLoop() {
        while (model.checkValue(getNumberFromUser(model.getMin(),model.getMax())));
       /* while (model.isNumberNotEqualsAnswer()) {//
            View.printStatusBar(model.getMin(), model.getMax(), model.getRange());
            model.setAnswer(getNumberFromUser(model.getMin(), model.getMax()));
            if (model.getAnswer() > model.getAskNumer()) {
                View.printMessage(View.IT_SMALLER);
                model.setMinOrMax(View.IT_SMALLER);
            } else if (model.getAnswer() < model.getAskNumer()) {
                View.printMessage(View.IT_BIGGER);
                model.setMinOrMax(View.IT_BIGGER);
            }
        }
        model.getInputs().add(Integer.toString(model.getAnswer()));*/
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
            model.getInputs().add(View.INVALID + input);
            View.printMessage(View.INVALID_INPUT + min + "-" + max);
        }
    }

}
