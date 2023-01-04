package pl.minigames.lotto;

import java.io.IOException;

public class LottoGameConsoleApplication {

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

        GameResult result = miniLotek.play();
        displayMessage(result);

    }

    private static void displayMessage(GameResult result) {
        if (result.isValid()) {
            System.out.println("MiniLotek numbers: " + result.lottoNumbers());
            System.out.println("Your numbers: " + result.userNumbers());
            System.out.println("Hit number: " + result.hits() + ". " + result.prize());
        } else {
            System.out.println("Error: " + result.message());
        }
    }

}
