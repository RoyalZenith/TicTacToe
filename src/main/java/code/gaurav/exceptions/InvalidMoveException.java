package code.gaurav.exceptions;

public class InvalidMoveException extends Exception {
    public InvalidMoveException(String invalidMove) {
        super(invalidMove);
    }
}
