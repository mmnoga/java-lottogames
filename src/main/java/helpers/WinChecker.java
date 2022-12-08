package helpers;

public class WinChecker {
    private final int MIN_HITS_FOR_WIN = 3;
    private int numberOfHits;

    public WinChecker(int numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public String getPrize() {
        if (numberOfHits >= MIN_HITS_FOR_WIN) {
            return "You have won $1000000. Congrats!";
        } else {
            return "No winning. Please try again!";
        }
    }
}
