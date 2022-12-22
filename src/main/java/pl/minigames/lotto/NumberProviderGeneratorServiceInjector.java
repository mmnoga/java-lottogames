package pl.minigames.lotto;

class NumberProviderGeneratorServiceInjector implements ServiceInjector{

    @Override
    public Consumer getConsumer() {
        return new LottoApplication(new NumberProviderGeneratorImpl());
    }

}
