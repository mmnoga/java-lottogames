package helpers;

import java.util.ArrayList;
import java.util.List;

public class NumberComparer {
    private List<Integer> lottoNumbers = new ArrayList<>();
    private List<Integer> userNumbers = new ArrayList<>();

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
