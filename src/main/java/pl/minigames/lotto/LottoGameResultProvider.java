package pl.minigames.lotto;

import java.util.List;

interface LottoGameResultProvider {

    List<Integer> getLottoNumbers();

    List<Integer> getUserNumbers();

    int getHits();

    String getPrize();

}
