import mvc.Model;
import org.junit.Before;
import org.junit.Test;
import util.GameConstants;

import static org.junit.Assert.assertTrue;

public class ModelTest implements GameConstants {
    Model model;

    @Before
    public void createModel() {
        model = new Model();
        model.setRangeBarrier(RAND_MIN, RAND_MAX);
    }

    @Test
    public void checkGenerateValues() {
        boolean checkResult = true;
        int number = 0;
        for (int i = 0; i < 10000; i++) {
            model.generateAskNumer();
            number = model.getAskNumer();
            if (number <= model.getMin() || number >= model.getMax()) {
                checkResult = false;
                break;
            }
        }
        assertTrue("test checking range fails: " + number, checkResult);
    }

    @Test
    public void checkBarriers() {
        boolean checkResult = true;
        int number = 0;
        for (int i = 0; i < 10000; i++) {
            model.generateAskNumer();
            number = model.getAskNumer();
            if (number == RAND_MIN || number == RAND_MAX) {
                checkResult = false;
                break;
            }
        }
        assertTrue("test checking range value fails. number: "
                + number
                + "in range: ]"
                + RAND_MIN
                + ":"
                + RAND_MAX
                + "[",
                checkResult);
    }
}
