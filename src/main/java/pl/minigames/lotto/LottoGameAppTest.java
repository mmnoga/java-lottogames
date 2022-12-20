package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

public class LottoGameAppTest {

    public static void main(String[] args) throws IOException {
        List<Integer> userNumbers;
        List<Integer> lottoNumbers;
        int hits;
        String price;

        ServiceInjector injector = null;
        Consumer app = null;

        // get user numbers
        injector = new NumberProviderScannerServiceInjector();
        app = injector.getConsumer();
        userNumbers = app.getUserNumbers();

        // generate lotto numbers
        injector = new NumberProviderGeneratorServiceInjector();
        app = injector.getConsumer();
        lottoNumbers = app.getLottoNumbers();

        // compare list numbers
        injector = new NumberComparerServiceInjector();
        app = injector.getConsumer();
        hits = app.getHitsNumber(lottoNumbers, userNumbers);

        // get prize
        injector = new WinCheckerServiceInjector();
        app = injector.getConsumer();
        price = app.getPrize(hits);

        System.out.println("MiniLotek numbers: " + lottoNumbers);
        System.out.println("Your numbers: " + userNumbers);
        System.out.println("Hit number: " + hits + ". " + price);

    }

}
