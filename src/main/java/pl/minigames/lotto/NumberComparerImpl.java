package pl.minigames.lotto;

import java.util.List;

class NumberComparerImpl implements NumberComparerProvider {

    @Override
    public int getHitsNumber(List<Integer> lottoNumbers, List<Integer> userNumbers) {
        int hits;
        hits = (int) userNumbers.stream()
                .filter(number -> lottoNumbers.contains(number))
                .count();
        return hits;
    }

}
