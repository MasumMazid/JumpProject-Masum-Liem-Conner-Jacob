package exceptions;

public class InvalidTvShowException extends Exception {
    public InvalidTvShowException(String errorMessage) {
        super(errorMessage);
    }
}
