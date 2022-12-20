package pl.minigames.lotto;

public class WinCheckerServiceInjector implements ServiceInjector{

    @Override
    public Consumer getConsumer() {
        return new LottoApplication(new WinCheckerImpl());
    }
}
