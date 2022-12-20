package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

interface NumberProvider {

    int MIN_VALUE = 1;
    int MAX_VALUE = 99;
    int NUMBER_OF_DRAW = 6;

    List<Integer> getNumbers() throws IOException;

}
