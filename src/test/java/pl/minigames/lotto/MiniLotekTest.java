package pl.minigames.lotto;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class MiniLotekTest {

    @Test
    public void should_return_success_when_user_gave_six_numbers_and_winning_numbers_were_the_same() throws IOException {
        // given
        List<Integer> numbersFromUser = List.of(5, 6, 7, 8, 9, 10);
        NumberProvider provider = new InMemoryNumberProviderImpl(numbersFromUser);
        MiniLotek miniLotek = new MiniLotek(provider);

        // when
        LottoGameResult result = miniLotek.play();

        // then
        assertThat(result.getHits(), equalTo(3));
        assertThat(result.getPrize(), equalTo("You have won $1000000. Congrats!"));
        assertThat(result.getUserNumbers(), contains(5, 6, 7, 8, 9, 10));
        assertThat(result.getLottoNumbers(), contains(5, 6, 7, 1, 2, 3));
    }


    @Test
    public void should_return_validation_message_when_user_gave_less_than_six_numbers() {

    }

    @Test
    public void should_return_validation_message_when_user_gave_more_than_six_numbers() {

    }

    @Test
    public void should_return_failed_message_when_user_lost() {

    }

    @Test
    public void should_return_validation_message_when_user_gave_duplicated_number() {

    }
}
