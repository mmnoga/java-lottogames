package helpers;

import java.util.List;

public class NumberComparer {
    private List<Integer> lottoNumbers;
    private List<Integer> userNumbers;

    public NumberComparer(List<Integer> lottoNumbers, List<Integer> userNumbers){
        this.lottoNumbers = lottoNumbers;
        this.userNumbers = userNumbers;
    }

    public int numberOfHitNumbers(){
        int hits;
        hits = (int) userNumbers.stream()
                .filter(number -> lottoNumbers.contains(number))
                .count();
        return hits;
    }
}
