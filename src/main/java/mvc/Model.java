package mvc;

import javafx.util.Pair;
import util.GameConstants;

import java.util.ArrayList;
import java.util.List;

class Model implements GameConstants {
    private int askNumer;
    private int min;
    private int max;
    private int range;
    private List<Pair<String, String>> inputs = new ArrayList();

    Model() {
        min = RAND_MIN;
        max = RAND_MAX;
        range = max - min;
    }

    void setRangeBarrier(int min, int max) {
        this.min = min;
        this.max = max;
    }

    List<Pair<String, String>> getInputs() {
        return inputs;
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
        askNumer = (int) Math.ceil(Math.random() *
                (max - min - 1) + min);
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void addToInputList(CompareValues compareValues, String s) {
        inputs.add(new Pair<String, String>(s, compareValues.value));
    }
}
