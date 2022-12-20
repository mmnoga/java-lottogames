package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

public class InMemoryNumberProviderGeneratorImpl implements NumberProvider{

    private final List<Integer> numbers;

    public InMemoryNumberProviderGeneratorImpl(List<Integer> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    @Override
    public List<Integer> getNumbers() throws IOException {
        return numbers;
    }
}