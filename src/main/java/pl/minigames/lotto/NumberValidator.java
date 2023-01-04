package pl.minigames.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.minigames.lotto.NumberProvider.MAX_VALUE;
import static pl.minigames.lotto.NumberProvider.MIN_VALUE;
import static pl.minigames.lotto.ValidationError.*;

class NumberValidator {

    ValidationResult validate(List<Integer> userNumbers) {
        List<ValidationError> errors = new ArrayList<>();
        if (isAtLeastOneNumberOutOfRange(userNumbers)) {
            errors.add(OUT_OF_RANGE);
        }
        Set<Integer> collect = new HashSet<>(userNumbers);
        if (collect.size() != 6) {
            errors.add(REPEATED);
        }
        if (userNumbers.size() > 6) {
            errors.add(MORE_THAN_SIX_NUMBERS);
        }
        if (userNumbers.size() < 6) {
            errors.add(LESS_THAN_SIX_NUMBERS);
        }
        if (errors.isEmpty()) {
            return new ValidationResult(true, "all good");
        }
        String errorsMessage = errors.stream()
                .map(enumError -> enumError.message)
                .collect(Collectors.joining(","));
        return new ValidationResult(false, errorsMessage);
    }

    private boolean isAtLeastOneNumberOutOfRange(List<Integer> userNumbers) {
        return userNumbers.stream()
                .anyMatch(number -> number < MIN_VALUE || number > MAX_VALUE);
    }

    private List<Integer> repeatedNumbers(List<Integer> numbers) {
        Set<Integer> duplicatedNumbersRemovedSet = new HashSet<>();
        Set<Integer> duplicatedNumbers = numbers.stream()
                .filter(n -> !duplicatedNumbersRemovedSet.add(n))
                .collect(Collectors.toSet());
        return duplicatedNumbers.stream()
                .collect(Collectors.toList());
    }
}
