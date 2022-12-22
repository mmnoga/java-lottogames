package pl.minigames.lotto;

class NumberProviderScannerServiceInjector implements ServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new LottoApplication(new NumberProviderScannerImpl());
    }

}
