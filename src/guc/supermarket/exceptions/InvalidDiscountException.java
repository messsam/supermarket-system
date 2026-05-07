package guc.supermarket.exceptions;

public class InvalidDiscountException extends IllegalArgumentException {
    public InvalidDiscountException() { super(); }
    public InvalidDiscountException(String message) { super(message); }
}