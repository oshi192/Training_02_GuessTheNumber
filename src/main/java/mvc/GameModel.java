package mvc;

import util.GameConstants;
import util.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel implements GameConstants {
    private static int askNumer;
    private static Random random = new Random();
    private int min;
    private int max;
    private int range;
    private int answer;
    List<String> inputs = new ArrayList();

    GameModel() {
        min = 0;
        max = 100;
        answer = 0;
        range = max - min;
    }

    public int rand(int min, int max) {
        int answer;
        if (max >= min) {
            answer = random.nextInt(max - min) + min;
        } else {
            answer = random.nextInt(min - max) + max;
        }
        return answer;
    }

    public void createNumber() {
        askNumer = rand(min, max);
        if (answer == askNumer) {
            answer++;
        }
    }

    public int rand() {
        return random.nextInt(RAND_MAX);
    }

    public int getNumber(String whatNeedToDo, int min, int max) {
        String input;
        System.out.print(whatNeedToDo);
        while (true) {
            input = Reader.getString();
            if (input.matches("\\d+")) {
                if (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max) {
                    return Integer.parseInt(input);
                }
            }
            inputs.add(INVALID + input + ERROR);
            System.out.println(INVALID_INPUT_MESSAGE + min + "-" + max);
        }
    }

    public void compareNumbers() {
        answer = getNumber("your number : ", min, max);
        if (answer > askNumer) {
            System.out.println(IT_SMALLER);
            max = answer;
            inputs.add(Integer.toString(answer) + LOWER);
        } else if (answer < askNumer) {
            System.out.println(IT_BIGGER);
            min = answer;
            inputs.add(Integer.toString(answer) + BIGGER);
        } else {
            inputs.add(Integer.toString(answer));
        }

    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public int getAnswer() {
        return answer;
    }

    public static int getAskNumer() {
        return askNumer;
    }

    public int getRange() {
        return range;
    }
}
