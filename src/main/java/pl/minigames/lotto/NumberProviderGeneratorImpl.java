package pl.minigames.lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NumberProviderGeneratorImpl implements NumberProvider{

    @Override
    public List<Integer> getNumbers() {
        List<Integer> lottoNumbers;
        lottoNumbers = getRandomNumbers();
        return lottoNumbers;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
    }

    private List<Integer> getRandomNumbers() {
        Stream<Integer> randStream = Stream.generate(
                        this::generateRandomNumber)
                .distinct()
                .limit(NUMBER_OF_DRAW);
        return randStream.collect(Collectors.toList());
    }
}
