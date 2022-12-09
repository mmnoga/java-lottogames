package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Stream<Integer> randStream = Stream.generate(
                        () -> generateRandomNumber())
                .distinct()
                .limit(numberOfDraw);
        List<Integer> randomNumbers = randStream.collect(Collectors.toList());
        return randomNumbers;
    }
}
