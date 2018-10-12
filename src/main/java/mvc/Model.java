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

    void setRangeBarrier(int min,int max) {
        this.min = min;
        this.max =max;
    }

    boolean isNumberNotEqualsAnswer() {
        return answer != askNumer;
    }

    /**
     * set min or max value depending on the 'value' strings
     * @param value - string that the answer number higher or less
     */
    void setMinOrMax(String value) {
        if (value.equals(View.IT_SMALLER)) {
            max = answer;
            inputs.add(Integer.toString(answer) + View.IT_SMALLER);
        } else {
            min = answer;
            inputs.add(Integer.toString(answer) + View.IT_BIGGER);
        }
    }
    boolean checkValue(int value){
        boolean isNotEquals = true;
        if (value > askNumer) {
            max = value;
            inputs.add(Integer.toString(answer) + View.IT_SMALLER);
        } else if (value < askNumer) {
            min =value ;
            inputs.add(Integer.toString(answer) + View.IT_BIGGER);
        } else {
            isNotEquals = false;
            inputs.add(Integer.toString(answer));
        }
        return isNotEquals;
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

    void generateAskNumer() {
        askNumer = (int)Math.ceil(Math.random()*
                (max- min - 1) + min);
    }

    void setAnswer(int answer) {
        this.answer = answer;
    }
}
