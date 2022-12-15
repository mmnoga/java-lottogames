package pl.minigames.lotto.exceptions;

public class RepeatedInputException extends Exception{
    public RepeatedInputException(String errorMessage){
        super(errorMessage);
    }
}
