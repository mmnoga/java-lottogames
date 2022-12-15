package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

public interface NumberProvider {

    List<Integer> getUserNumbers() throws IOException;
}
