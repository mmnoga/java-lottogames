package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

public class InMemoryNumberProviderImpl implements NumberProvider {
    private final List<Integer> numbers;

    public InMemoryNumberProviderImpl(List<Integer> numbersFromUser) {
        this.numbers = numbersFromUser;
    }

    @Override
    public List<Integer> getNumbers() throws IOException {
        return numbers;
    }
}
