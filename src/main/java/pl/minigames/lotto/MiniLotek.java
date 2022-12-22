package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

class MiniLotek {

    List<Integer> lottoNumbers;
    List<Integer> userNumbers;

    NumberProvider userNumberProvider;
    NumberProvider lottoNumberProvider;
    NumberComparerProvider numberComparer;
    WinCheckerProvider winChecker;

    MiniLotek(NumberProvider userNumberProvider,
              NumberProvider lottoNumberProvider,
              NumberComparerProvider numberComparer,
              WinCheckerProvider winChecker
    ) {
        this.userNumberProvider = userNumberProvider;
        this.lottoNumberProvider = lottoNumberProvider;
        this.numberComparer = numberComparer;
        this.winChecker = winChecker;
    }

    public LottoGameResultImpl play() throws IOException {
        userNumbers = receiveUserNumbers();
        lottoNumbers = generateNumbers();
        int hits = getHitsNumber();
        String prize = showPrize(hits);
        return new LottoGameResultImpl(lottoNumbers, userNumbers, hits, prize);
    }

    public List<Integer> receiveUserNumbers() throws IOException {
        List<Integer> userNumbers;
        userNumbers = userNumberProvider.getNumbers();
        return userNumbers;
    }

    public List<Integer> generateNumbers() throws IOException {
        List<Integer> lottoNumbers;
        lottoNumbers = lottoNumberProvider.getNumbers();
        return lottoNumbers;
    }

    public int getHitsNumber() {
        return numberComparer.getHitsNumber(lottoNumbers, userNumbers);
    }


    public String showPrize(int hits) {
        return winChecker.getPrize(hits);
    }
}
