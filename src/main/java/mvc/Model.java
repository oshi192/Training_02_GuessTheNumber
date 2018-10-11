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
        min = RAND_MIN;
        max = RAND_MAX;
        answer = 0;
        range = max - min;
    }

    Model(int min, int max) {
        if (min < max) {
            this.min = min;
            this.max = max;
            range = max - min;
        } else {
            this.min = max;
            this.max = min;
            range = min - max;
        }

    }

    boolean isNumberNotEqualsAnswer() {
        return answer != askNumer;
    }

    void setMinOrMax(String value) {
        if (value.equals(IT_SMALLER)) {
            max = answer;
            inputs.add(Integer.toString(answer) + IT_SMALLER);
        } else {
            min = answer;
            inputs.add(Integer.toString(answer) + IT_BIGGER);
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
