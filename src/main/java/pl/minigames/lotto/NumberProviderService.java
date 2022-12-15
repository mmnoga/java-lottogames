package pl.minigames.lotto;

import java.util.List;

class NumberProviderService {

    private NumberProviderRepository numberProviderRepository;

    public NumberProviderService(NumberProviderRepository numberProviderRepository){
        this.numberProviderRepository = numberProviderRepository;
    }

    List<Integer> getUserNumbers() {
        return numberProviderRepository.getUserNumbers();
    }

}
