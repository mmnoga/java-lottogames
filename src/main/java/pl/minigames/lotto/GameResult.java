package pl.minigames.lotto;

import java.util.List;

public record GameResult(List<Integer> lottoNumbers,
                         List<Integer> userNumbers,
                         int hits,
                         String prize,
                         String message) {
}
