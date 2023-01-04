package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
        GameResult result = miniLotek.play();

        // then
        assertThat(result.hits(), equalTo(3));
        assertThat(result.prize(), equalTo("You have won $1000000. Congrats!"));
        assertThat(result.userNumbers(), contains(1, 2, 3, 4, 5, 6));
        assertThat(result.lottoNumbers(), contains(1, 2, 3, 14, 15, 16));
    }

    @Test
    public void should_return_validation_message_when_user_gave_less_than_six_numbers() throws IOException {
        // given
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5);
        NumberProvider userNumberProvider = new InMemoryNumberProviderScannerImpl(numbersFromUser);
        NumberComparerProvider numberComparerProvider = new NumberComparerImpl();
        WinCheckerProvider winCheckerProvider = new WinCheckerImpl();
        MiniLotek miniLotek = new MiniLotek(
                userNumberProvider,
                new NumberProviderGeneratorImpl(),
                numberComparerProvider,
                winCheckerProvider);

        // when
        GameResult result = miniLotek.play();

        // then
        assertThat(result.message(), containsString("less than six numbers"));
    }

    @Test
    public void should_return_validation_message_when_user_gave_more_than_six_numbers() throws IOException {
        // given
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6, 7);
        NumberProvider userNumberProvider = new InMemoryNumberProviderScannerImpl(numbersFromUser);
        NumberComparerProvider numberComparerProvider = new NumberComparerImpl();
        WinCheckerProvider winCheckerProvider = new WinCheckerImpl();
        MiniLotek miniLotek = new MiniLotek(
                userNumberProvider,
                new NumberProviderGeneratorImpl(),
                numberComparerProvider,
                winCheckerProvider);

        // when
        GameResult result = miniLotek.play();

        // then
        assertThat(result.message(), containsString("more than six numbers"));
    }

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
        GameResult result = miniLotek.play();

        // then
        assertThat(result.prize(), equalTo("No winning. Please try again!"));
    }

    @Test
    public void should_return_validation_message_when_user_gave_duplicated_number() throws IOException {

        // given
        List<Integer> numbersFromUser = List.of(1, 1, 1000, 4, 5, 6);
        NumberProvider userNumberProvider = new InMemoryNumberProviderScannerImpl(numbersFromUser);
        NumberComparerProvider numberComparerProvider = new NumberComparerImpl();
        WinCheckerProvider winCheckerProvider = new WinCheckerImpl();
        MiniLotek miniLotek = new MiniLotek(
                userNumberProvider,
                new NumberProviderGeneratorImpl(),
                numberComparerProvider,
                winCheckerProvider);

        // when
        GameResult result = miniLotek.play();

        // then
        assertThat(result.message(), containsString("repeated number"));
        assertThat(result.message(), containsString("out of range number"));
    }

}
