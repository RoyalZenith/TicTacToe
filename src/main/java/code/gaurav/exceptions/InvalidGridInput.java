package code.gaurav.exceptions;

public class InvalidGridInput extends Exception {
    public InvalidGridInput(String invalidGridInput) {
        super(invalidGridInput);
    }
}
