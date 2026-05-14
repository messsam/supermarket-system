package eg.edu.guc.supermarket.exceptions;

public class NotEnoughProductException extends Exception {
	public NotEnoughProductException() { super(); }
	public NotEnoughProductException(String msg) { super(msg); }
}