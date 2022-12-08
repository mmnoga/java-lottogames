package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NumberProvider {
    private List<Integer> userNumbers = new ArrayList<>();
    private int minNumber;
    private int maxNumber;
    private int numberOfRandomNumbers;
    private int inputNumber;

    public NumberProvider(int minNumber, int maxNumber, int numberOfRandomNumbers) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.numberOfRandomNumbers = numberOfRandomNumbers;
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
                    inputNumber = Integer.parseInt(in.readLine());
                    userNumbers.add(inputNumber);
            }
        }
    }

    public List<Integer> getUserNumbers() throws IOException {
        parseUserNumbers();
        return userNumbers;
    }
}
