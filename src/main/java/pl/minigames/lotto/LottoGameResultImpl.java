package pl.minigames.lotto;

import java.util.List;

class LottoGameResultImpl implements LottoGameResultProvider{

    private final List<Integer> lottoNumbers;
    private final List<Integer> userNumbers;
    private final int hits;
    private final String prize;

    public LottoGameResultImpl(List<Integer> lottoNumbers,
                               List<Integer> userNumbers,
                               int hits,
                               String prize) {
        this.lottoNumbers = lottoNumbers;
        this.userNumbers = userNumbers;
        this.hits = hits;
        this.prize = prize;
    }

    @Override
    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public List<Integer> getUserNumbers() {
        return this.userNumbers;
    }

    @Override
    public int getHits() {
        return this.hits;
    }

    @Override
    public String getPrize() {
        return this.prize;
    }
}
