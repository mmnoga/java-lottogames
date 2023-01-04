package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

class MiniLotek {

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

    public GameResult play() throws IOException {
        List<Integer> userNumbers = userNumberProvider.getNumbers();
        NumberValidator numberValidator = new NumberValidator();
        ValidationResult validationResult = numberValidator.validate(userNumbers);
        if (validationResult.isNotValid()) {
            return new GameResult(null, null, 0, null, validationResult.message(), false);
        }
        List<Integer> lottoNumbers = lottoNumberProvider.getNumbers();
        int hits = numberComparer.getHitsNumber(lottoNumbers, userNumbers);
        String prize = winChecker.getPrize(hits);
        // save for Date X
        return new GameResult(lottoNumbers, userNumbers, hits, prize, validationResult.message(), true);
    }
}
