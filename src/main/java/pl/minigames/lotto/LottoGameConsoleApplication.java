package pl.minigames.lotto;

import java.io.IOException;

class LottoGameConsoleApplication {
    public static void main(String[] args) throws IOException {

        NumberProvider userNumberProvider = new NumberProviderScannerImpl();
        NumberProvider lottoNumberProvider = new NumberProviderGeneratorImpl();
        NumberComparerProvider numberComparer = new NumberComparerImpl();
        WinCheckerProvider winChecker = new WinCheckerImpl();

        MiniLotek miniLotek = new MiniLotek(
                userNumberProvider,
                lottoNumberProvider,
                numberComparer,
                winChecker);

        LottoGameResult result = miniLotek.play();

        System.out.println("MiniLotek numbers: " + result.getLottoNumbers());
        System.out.println("Your numbers: " + result.getUserNumbers());
        System.out.println("Hit number: " + result.getHits() + ". " + result.getPrize());
        System.out.println("Prize: " + result.getPrize());
    }

}
