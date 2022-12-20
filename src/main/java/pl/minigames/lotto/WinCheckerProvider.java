package pl.minigames.lotto;

interface WinCheckerProvider {

    int MIN_HITS_FOR_WIN = 3;

    String getPrize(int hits);

}
