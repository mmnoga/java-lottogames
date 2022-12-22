package pl.minigames.lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

class LottoGameApplicationTest {

    public ServiceInjector injector;

    @BeforeEach
    public void setUp() {
        injector = new ServiceInjector() {
            @Override
            public Consumer getConsumer() {
                return new LottoApplication(new NumberProvider() {
                    @Override
                    public List<Integer> getNumbers() {
                        return List.of(1, 2, 3, 4, 5, 6);
                    }
                });
            }
        };
    }

    @Test
    @DisplayName("should return user numbers")
    public void shouldReturnUserNumbers() throws IOException {
        //given
        Consumer app = injector.getConsumer();

        //when
        //then
        List<Integer> userNumbers = app.getUserNumbers();
        assertThat(userNumbers, equalTo(List.of(1,2,3,4,5,6)));

    }

    @AfterEach
    public void tear() {
        injector = null;
    }

}