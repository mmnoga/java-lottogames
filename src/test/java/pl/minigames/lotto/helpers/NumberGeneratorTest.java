//package pl.minigames.lotto.helpers;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//import pl.minigames.lotto.NumberGenerator;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DisplayName("number generator")
//class NumberGeneratorTest {
//
//    private NumberGenerator nGen;
//
//    private boolean isDuplicate(List<Integer> values) {
//        Set set = new HashSet<>();
//        for (int i : values) {
//            if (set.contains(i)) return true;
//            set.add(i);
//        }
//        return false;
//    }
//
//    @Test
//    @DisplayName("should return ten unique numbers from one to ten")
//    void shouldReturnSixUniqueNumbersFromOneToTen() {
//        nGen = new NumberGenerator(1, 10, 10);
//        for (int i = 0; i < 10000; i++) {
//            assertFalse(isDuplicate(nGen.getRandomNumbers()));
//        }
//        assertTrue(true);
//    }
//
//    @Test
//    @DisplayName("should return exception when draw number is higher than range of numbers")
//    void shouldReturnExceptionWhenDrawNumberIsHigherThanRangeOfNumbers() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            nGen = new NumberGenerator(1, 10, 12);
//        });
//    }
//
//    @Test
//    @DisplayName("should return exception when max number is equal min number")
//    void shouldReturnExceptionWhenMaxNumberIsEqualMinNumber() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            nGen = new NumberGenerator(5, 5, 1);
//        });
//    }
//
//    @Test
//    @DisplayName("should return exception when max number is lower than min number")
//    void shouldReturnExceptionWhenMaxNumberIsLowerThanMinNumber() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            nGen = new NumberGenerator(10, 7, 1);
//        });
//    }
//
//}
