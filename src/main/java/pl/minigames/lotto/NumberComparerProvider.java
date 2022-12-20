package pl.minigames.lotto;

import java.util.List;

interface NumberComparerProvider {

    int getHitsNumber(List<Integer> lottoNumber, List<Integer> userNumber);

}
