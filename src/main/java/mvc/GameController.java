package mvc;

import util.GameConstants;
import util.Reader;

import java.util.Random;

public class GameController implements GameConstants {
    private static Random random = new Random();

    private Model model;

    public GameController() {
        model = new Model();
    }

    public void start() {
        View.printMessage(MESSAGE_START);
        View.printRangMessage(model.getMin(), model.getMax());
        View.printMessage(MESSAGE_RULES);
        model.setAskNumer(rand(model.getMin(), model.getMax()));
        gameLoop();
        View.printMessage(MESSAGE_CONGRADULATION);
        View.printStatistics(model.getInputs());
    }

    private void gameLoop() {
        while (model.isNumberNotEqualsAnswer()) {//
            View.printStatusBar(model.getMin(), model.getMax(), model.getRange());
            model.setAnswer(getNumberFromUser(model.getMin(), model.getMax()));
            if (model.getAnswer() > model.getAskNumer()) {
                View.printMessage(IT_SMALLER);
                model.setMinOrMax(IT_SMALLER);
            } else if (model.getAnswer() < model.getAskNumer()) {
                View.printMessage(IT_BIGGER);
                model.setMinOrMax(IT_BIGGER);
            }
            model.getInputs().add(Integer.toString(model.getAnswer()));
        }
    }

    /**
     * reads number from console in range from min value to max
     * if invalid entering - Viev displayed error message
     * @param min - the lower value of range
     * @param max - the higher value of range
     * @return - valid value from range from min to max
     */
    private int getNumberFromUser(int min, int max) {
        String input;
        View.printMessage(MESSAGE_ENTER_NUMBER + min + " - " + max + " :");
        while (true) {
            input = Reader.getString();
            if (input.matches("\\d+")) {
                if (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max) {
                    return Integer.parseInt(input);
                }
            }
            model.getInputs().add(INVALID + input);
            View.printMessage(INVALID_INPUT_MESSAGE + min + "-" + max);
        }
    }

    private int rand(int min, int max) {
        int answer;
        if (max > min) {
            answer = random.nextInt(max - min) + min;
        } else if (min > max) {
            answer = random.nextInt(min - max) + max;
        } else {
            answer = rand();
        }
        return answer;
    }

    public int rand() {
        return random.nextInt(RAND_MAX);
    }

}
