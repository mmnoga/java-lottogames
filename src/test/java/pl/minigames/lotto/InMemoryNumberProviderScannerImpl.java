package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

public class InMemoryNumberProviderScannerImpl implements NumberProvider {

    private final List<Integer> numbers;

    public InMemoryNumberProviderScannerImpl(List<Integer> numbersFromUser) {
        this.numbers = numbersFromUser;
    }

    @Override
    public List<Integer> getNumbers() throws IOException {
        return numbers;
    }
}
