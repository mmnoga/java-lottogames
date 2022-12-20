package pl.minigames.lotto;

public class NumberComparerServiceInjector implements ServiceInjector{

    @Override
    public Consumer getConsumer() {
        return new LottoApplication(new NumberComparerImpl());
    }
}
