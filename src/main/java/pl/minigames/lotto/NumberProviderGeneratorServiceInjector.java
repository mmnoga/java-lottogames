package pl.minigames.lotto;

public class NumberProviderGeneratorServiceInjector implements ServiceInjector{

    @Override
    public Consumer getConsumer() {
        return new LottoApplication(new NumberProviderGeneratorImpl());
    }
}
