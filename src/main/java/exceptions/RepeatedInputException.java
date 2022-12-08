package exceptions;

public class RepeatedInputException extends Exception{
    public RepeatedInputException(String errorMessage){
        super(errorMessage);
    }
}
