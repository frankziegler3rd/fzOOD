/**
 * HW 3
 * OOD; Professor Chu
 * @author Frank Ziegler
 * @version 1.0.0
 */

import java.util.List;
import java.util.ArrayList;

public class LicensePlate {

    private String plateNum;
    private List<String> wordsDisplayed;

    public LicensePlate(String plateNum) {
        this.plateNum = plateNum;
        wordsDisplayed = new ArrayList<String>();
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public List<String> getWordsDisplayed() {
        return wordsDisplayed;
    }

    public void setWordsDisplayed(List<String> wordsDisplayed) {
        this.wordsDisplayed = wordsDisplayed;
    }
}