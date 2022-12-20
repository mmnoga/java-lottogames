package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

public class LottoApplication implements Consumer{

    private NumberProvider numbersProvider;
    private NumberComparerProvider numberComparerProvider;
    private WinCheckerProvider winCheckerProvider;

    public LottoApplication(NumberProvider numbersProvider){
        this.numbersProvider = numbersProvider;
    }
    public LottoApplication(NumberComparerProvider numberComparerProvider){
        this.numberComparerProvider = numberComparerProvider;
    }
    public LottoApplication(WinCheckerProvider winCheckerProvider){
        this.winCheckerProvider = winCheckerProvider;
    }


    @Override
    public List<Integer> getUserNumbers() throws IOException {
        return numbersProvider.getNumbers();
    }

    @Override
    public List<Integer> getLottoNumbers() throws IOException {
        return numbersProvider.getNumbers();
    }

    @Override
    public int getHitsNumber(List<Integer> lottoNumbers, List<Integer> userNumbers) {
        return numberComparerProvider.getHitsNumber(lottoNumbers, userNumbers);
    }

    @Override
    public String getPrize(int hits) {
        return winCheckerProvider.getPrize(hits);
    }

}
