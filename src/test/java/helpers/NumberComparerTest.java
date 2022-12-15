package helpers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("number comparer")
class NumberComparerTest {

    @Test
    @DisplayName("should return proper number of hits")
    void shouldReturnProperNumberOfHits() {

        //given
        List<Integer> lottoNumbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> userNumbers = new ArrayList<>(
                Arrays.asList(3, 4, 8, 9, 10, 11)
        );
        NumberComparer nComp = new NumberComparer(lottoNumbers, userNumbers);

        //when
        //then
        assertThat(nComp.numberOfHitNumbers(), equalTo(2));

    }

    @Test
    @DisplayName("should return zero hits if any user number not in lotto numbers ")
    void shouldReturnZeroHitsIfAnyUserNumberNotInLottoNumbers() {

        //given
        List<Integer> lottoNumbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> userNumbers = new ArrayList<>(
                Arrays.asList(7, 8, 9, 10, 11, 12)
        );
        NumberComparer nComp = new NumberComparer(lottoNumbers, userNumbers);

        //when
        //then
        assertThat(nComp.numberOfHitNumbers(), equalTo(0));

    }

}