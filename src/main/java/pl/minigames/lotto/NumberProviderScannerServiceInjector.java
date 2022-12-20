package pl.minigames.lotto;

public class NumberProviderScannerServiceInjector implements ServiceInjector{

    @Override
    public Consumer getConsumer() {
        return new LottoApplication(new NumberProviderScannerImpl());
    }
}
