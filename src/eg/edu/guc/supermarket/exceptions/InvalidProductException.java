package eg.edu.guc.supermarket.exceptions;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException() { super(); }
    public InvalidProductException(String message) { super(message); }
}