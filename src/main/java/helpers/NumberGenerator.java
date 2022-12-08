package helpers;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private int minNumber;
    private int maxNumber;
    private int numberOfDraw;
    private List<Integer> randomNumbers = new ArrayList<>();

    public NumberGenerator(int minNumber, int maxNumber, int numberOfRandomNumbers) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.numberOfDraw = numberOfRandomNumbers;
    }

    private int generateRandomNumber() {
        return (int) ((Math.random() * (maxNumber - minNumber)) + minNumber);
    }

    public List<Integer> getRandomNumbers() {
        for (int i = 0; i < numberOfDraw; i++) {
            randomNumbers.add(generateRandomNumber());
        }
        return randomNumbers;
    }
}
