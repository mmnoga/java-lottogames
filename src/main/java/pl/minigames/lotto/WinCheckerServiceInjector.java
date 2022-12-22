package pl.minigames.lotto;

class WinCheckerServiceInjector implements ServiceInjector{

    @Override
    public Consumer getConsumer() {
        return new LottoApplication(new WinCheckerImpl());
    }

}
