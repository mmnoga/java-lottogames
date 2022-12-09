package helpers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    NumberGenerator nGen = new NumberGenerator(1, 10, 6);

    @Test
    void shouldReturnSixUniqueNumbersFromOneToTen() {
        int i = 0;
        do {
            List<Integer> testNumbers = nGen.getRandomNumbers();
            List<Integer> uniqueNumbers = testNumbers.stream()
                    .distinct()
                    .collect(Collectors.toList());
            assertFalse(testNumbers.size() != uniqueNumbers.size());
            i++;
        } while (i < 10000);
        assertTrue(true);
    }

}