package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

public interface Consumer {

    List<Integer> getUserNumbers() throws IOException;
    List<Integer> getLottoNumbers() throws IOException;
    int getHitsNumber(List<Integer> lottoNumbers, List<Integer> userNumbers);
    String getPrize(int hits);

}
