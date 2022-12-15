package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

class MiniLotek {
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 99;
    private final int NUMBER_OF_DRAW = 6;

    List<Integer> lottoNumbers;
    List<Integer> userNumbers;

    NumberGenerator numberGenerator;
    NumberProvider userNumberProvider;
    NumberComparer numberComparer;
    WinChecker winChecker;

    MiniLotek(NumberProvider userNumberProvider) {
        this.userNumberProvider = userNumberProvider;
    }

    public LottoGameResult play() throws IOException {
        userNumbers = receiveUserNumbers();
        lottoNumbers = generateNumbers();
        int hits = hitNumbers();
        String prize = showPrize(hits);

        return new LottoGameResult(lottoNumbers, userNumbers, hits, prize);
    }

    public List<Integer> receiveUserNumbers() throws IOException {
        List<Integer> userNumbers;
//        userNumberProvider = new NumberProvider(MIN_VALUE, MAX_VALUE, NUMBER_OF_DRAW);
        userNumbers = userNumberProvider.getUserNumbers();
        return userNumbers;
    }

    public List<Integer> generateNumbers() {
        List<Integer> lottoNumbers;
        numberGenerator = new NumberGenerator(MIN_VALUE, MAX_VALUE, NUMBER_OF_DRAW);
        lottoNumbers = numberGenerator.getRandomNumbers();
        return lottoNumbers;
    }

    public int hitNumbers() {
        numberComparer = new NumberComparer(lottoNumbers, userNumbers);
        int hits = numberComparer.numberOfHitNumbers();
        return hits;
    }


    public String showPrize(int hitNumbers) {
        winChecker = new WinChecker(hitNumbers);
        return winChecker.getPrize();
    }
}
