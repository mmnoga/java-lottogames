package pl.minigames.lotto;

class NumberComparerServiceInjector implements ServiceInjector{

    @Override
    public Consumer getConsumer() {
        return new LottoApplication(new NumberComparerImpl());
    }

}
