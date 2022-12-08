package games;

import java.util.List;

public interface LottoGameInterface {
    List<Integer> generateNumbers();

    String showPrize(int hitNumbers);
}
