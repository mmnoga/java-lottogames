package pl.minigames.lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import pl.minigames.lotto.exceptions.OutOfRangeException;
import pl.minigames.lotto.exceptions.RepeatedInputException;

class NumberProviderScannerImpl implements NumberProvider {
    private List<Integer> userNumbers = new ArrayList<>();
    private int minNumber;
    private int maxNumber;
    private int numberOfRandomNumbers;
    private int inputNumber;

    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 99;
    private final int NUMBER_OF_DRAW = 6;

    public NumberProviderScannerImpl() {
        this.minNumber = MIN_VALUE;
        this.maxNumber = MAX_VALUE;
        this.numberOfRandomNumbers = NUMBER_OF_DRAW;
    }

    public List<Integer> getUserNumbers() throws IOException {
        parseUserNumbers();
        return userNumbers;
    }

    private void parseUserNumbers() throws IOException {
        BufferedReader in;
        in = new BufferedReader((new InputStreamReader(System.in)));

        for (int i = 1; i < numberOfRandomNumbers + 1; i++) {

            while (true) {
                System.out.print(
                        String.format(
                                "Enter %d of %d number (range %d to %d): ",
                                i, numberOfRandomNumbers, minNumber, maxNumber));
                try {
                    inputNumber = Integer.parseInt(in.readLine());
                    if (inputNumber < minNumber || inputNumber > maxNumber) {
                        throw new OutOfRangeException("out of range number");
                    }
                    if (userNumbers.contains(inputNumber)) {
                        throw new RepeatedInputException("repeated number");
                    }
                    userNumbers.add(inputNumber);
                    break;
                } catch (NumberFormatException nfe) {
                    System.out.println("Not a number. Try again.");
                } catch (OutOfRangeException ex) {
                    System.out.println("Number out of range. Try again.");
                } catch (RepeatedInputException ex) {
                    System.out.println("Already entered number. Try again.");
                }
            }
        }
    }
}