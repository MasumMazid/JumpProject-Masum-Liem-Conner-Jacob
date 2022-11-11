package exceptions;

public class DuplicateUserException extends Exception {
    public DuplicateUserException(String errorMessage) {
      super(errorMessage);
    }
}
