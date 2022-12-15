package helpers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("number provider")
class NumberProviderTest {

    @Test
    @DisplayName("should return list of entered user numbers")
    void getUserNumbers() throws IOException {

        //given
        List<Integer> numbers = prepareUserNumbers();
        NumberProviderRepository numberProviderRepository = mock(NumberProviderRepository.class);
        NumberProviderService numberProviderService = new NumberProviderService(numberProviderRepository);
        given(numberProviderRepository.getUserNumbers()).willReturn(numbers);

        //when
        List<Integer> numberList = numberProviderService.getUserNumbers();

        //then
        assertThat(numberList, hasSize(6));
    }

    private List<Integer> prepareUserNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}