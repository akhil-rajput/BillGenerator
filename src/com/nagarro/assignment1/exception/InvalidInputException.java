package com.nagarro.assignment1.exception;

/**
 * When user input is found to be invalid, objects of this class are created and
 * thrown, and appropriate error messages are displayed to the user.
 * 
 */
public class InvalidInputException extends Throwable {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String message) {
		super(message);
	}
}
