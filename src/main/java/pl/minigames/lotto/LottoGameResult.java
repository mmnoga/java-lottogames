package pl.minigames.lotto;

import java.util.List;

class LottoGameResult {
    private final List<Integer> lottoNumbers;
    private final List<Integer> userNumbers;
    private final int hits;
    private final String prize;

    public LottoGameResult(List<Integer> lottoNumbers, List<Integer> userNumbers, int hits, String prize) {
        this.lottoNumbers = lottoNumbers;
        this.userNumbers = userNumbers;
        this.hits = hits;
        this.prize = prize;
    }

    List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    List<Integer> getUserNumbers() {
        return userNumbers;
    }

    int getHits() {
        return hits;
    }

    String getPrize() {
        return prize;
    }
}
