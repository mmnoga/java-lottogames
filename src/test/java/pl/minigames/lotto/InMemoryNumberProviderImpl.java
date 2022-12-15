package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

public class InMemoryNumberProviderImpl implements NumberProvider {
    private final List<Integer> numbersFromUser;

    public InMemoryNumberProviderImpl(List<Integer> numbersFromUser) {
        this.numbersFromUser = numbersFromUser;
    }

    @Override
    public List<Integer> getUserNumbers() throws IOException {
        return numbersFromUser;
    }
}
