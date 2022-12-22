package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiniLotekTest {

    @Test
    public void should_return_success_when_user_gave_six_numbers_and_winning_numbers_were_the_same() throws IOException {
        // given
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 14, 15, 16);
        NumberProvider userNumberProvider = new InMemoryNumberProviderScannerImpl(numbersFromUser);
        NumberProvider lottoNumberProvider = new InMemoryNumberProviderGeneratorImpl(lottoNumbers);
        NumberComparerProvider numberComparerProvider = new NumberComparerImpl();
        WinCheckerProvider winCheckerProvider = new WinCheckerImpl();
        MiniLotek miniLotek = new MiniLotek(
                userNumberProvider,
                lottoNumberProvider,
                numberComparerProvider,
                winCheckerProvider);

        // when
        LottoGameResultImpl result = miniLotek.play();

        // then
        assertThat(result.getHits(), equalTo(3));
        assertThat(result.getPrize(), equalTo("You have won $1000000. Congrats!"));
        assertThat(result.getUserNumbers(), contains(1, 2, 3, 4, 5, 6));
        assertThat(result.getLottoNumbers(), contains(1, 2, 3, 14, 15, 16));
    }


//    @Test
//    public void should_return_validation_message_when_user_gave_less_than_six_numbers() {
//
//    }
//
//    @Test
//    public void should_return_validation_message_when_user_gave_more_than_six_numbers() {
//
//    }

    @Test
    public void should_return_failed_message_when_user_lost() throws IOException {
        // given
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(10, 2, 3, 14, 15, 16);
        NumberProvider userNumberProvider = new InMemoryNumberProviderScannerImpl(numbersFromUser);
        NumberProvider lottoNumberProvider = new InMemoryNumberProviderGeneratorImpl(lottoNumbers);
        NumberComparerProvider numberComparerProvider = new NumberComparerImpl();
        WinCheckerProvider winCheckerProvider = new WinCheckerImpl();
        MiniLotek miniLotek = new MiniLotek(
                userNumberProvider,
                lottoNumberProvider,
                numberComparerProvider,
                winCheckerProvider);

        // when
        LottoGameResultImpl result = miniLotek.play();

        // then
        assertThat(result.getPrize(), equalTo("No winning. Please try again!"));
    }

    @Test
    public void should_return_validation_message_when_user_gave_duplicated_number() throws IOException {
//        //given
//        List<Integer> numbersFromUser = List.of(1, 1, 3, 4, 5, 6);
//        NumberProvider userNumberProvider = new InMemoryNumberProviderScannerImpl(numbersFromUser);
//        userNumberProvider.getNumbers();
//        Exception exception = assertThrows(IOException.class, () ->{
//            userNumberProvider.getNumbers();
//        });
//        // when
//        // then
//        String expectedMessage = "Already entered number. Try again.";
//        String actualMessage = exception.getMessage();
//        assertTrue(actualMessage.contains(expectedMessage));
    }
}
