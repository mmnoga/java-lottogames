package pl.minigames.lotto;

import java.io.IOException;

class LottoGameConsoleApplication {
    public static void main(String[] args) throws IOException {
        NumberProvider provider = new NumberProviderScannerImpl();
        MiniLotek miniLotek = new MiniLotek(provider);
        LottoGameResult result = miniLotek.play();

//        System.out.println("MiniLotek numbers: " + result.lottoNumbers);
//        System.out.println("Your numbers: " + userNumbers);
//        System.out.println("Hit number: " + hits + ". " + prize);
    }
}
