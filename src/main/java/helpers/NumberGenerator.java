package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberGenerator {
    private int minNumber;
    private int maxNumber;
    private int drawNumber;
    private List<Integer> randomNumbers = new ArrayList<>();

    public NumberGenerator(int minNumber, int maxNumber, int drawNumber) {
        if (!validDrawNumber(minNumber, maxNumber, drawNumber)) {
            throw new IllegalArgumentException("Draw number must be lower or equal range between min and max number");
        }
        if (maxNumber <= minNumber) {
            throw new IllegalArgumentException("Max number must be greater than min number");
        }
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.drawNumber = drawNumber;
    }

    private boolean validDrawNumber(int minNumber, int maxNumber, int drawNumber) {
        return (drawNumber <= maxNumber - minNumber + 1) ? true : false;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }

    public List<Integer> getRandomNumbers() {
        Stream<Integer> randStream = Stream.generate(
                        () -> generateRandomNumber())
                .distinct()
                .limit(drawNumber);
        List<Integer> randomNumbers = randStream.collect(Collectors.toList());
        return randomNumbers;
    }
}
