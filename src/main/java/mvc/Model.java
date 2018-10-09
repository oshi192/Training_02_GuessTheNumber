package mvc;

import util.GameConstants;

import java.util.ArrayList;
import java.util.List;

class Model implements GameConstants {
    private int askNumer;
    private int min;
    private int max;
    private int range;
    private int answer;
    private List<String> inputs = new ArrayList();

    Model() {
        min = 0;
        max = 100;
        answer = 0;
        range = max - min;
    }

    Model(int min, int max) {
        this.min = min;
        this.max = max;
        range = max - min;
    }

    boolean isNumberNotEqualsAnswer() {
        return answer != askNumer;
    }

    void setMinOrMax(String value) {
        if (value.equals(IT_SMALLER)) {
            max = answer;
            inputs.add(Integer.toString(answer) + LOWER);
        } else {
            min = answer;
            inputs.add(Integer.toString(answer) + BIGGER);
        }
    }

    List<String> getInputs() {
        return inputs;
    }

    int getAnswer() {
        return answer;
    }

    int getAskNumer() {
        return askNumer;
    }

    int getRange() {
        return range;
    }

    int getMin() {
        return min;
    }

    int getMax() {
        return max;
    }

    void setAskNumer(int askNumer) {
        this.askNumer = askNumer;
    }


    void setAnswer(int answer) {
        this.answer = answer;
    }
}