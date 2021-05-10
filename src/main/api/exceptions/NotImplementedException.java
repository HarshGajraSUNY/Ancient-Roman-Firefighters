package main.api.exceptions;

public class NotImplementedException extends Exception {
	public NotImplementedException() {
	    super("This method is not implemented. Please implement it.");
	  }
}
