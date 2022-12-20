package pl.minigames.lotto;

class WinCheckerImpl implements WinCheckerProvider {

    @Override
    public String getPrize(int hits) {
        return (hits >= MIN_HITS_FOR_WIN) ?
                "You have won $1000000. Congrats!" :
                "No winning. Please try again!";
    }
}
