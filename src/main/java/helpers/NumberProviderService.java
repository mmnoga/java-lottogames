package helpers;

import java.util.List;

public class NumberProviderService {

    private NumberProviderRepository numberProviderRepository;

    public NumberProviderService(NumberProviderRepository numberProviderRepository){
        this.numberProviderRepository = numberProviderRepository;
    }

    List<Integer> getUserNumbers() {
        return numberProviderRepository.getUserNumbers();
    }

}
