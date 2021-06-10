package com.nagarro.assignment1.util;

import com.nagarro.assignment1.domain.ItemType;
import com.nagarro.assignment1.exception.InvalidInputException;

public class ValidationUtil {
	public static String getValidatedName(final String name) throws InvalidInputException {
		if (name.length() < 1) {
			throw new InvalidInputException("Please enter a valid string name:");
		}
		return name;
	}

	public static int getValidatedQuantity(final String inputQuanity) throws InvalidInputException {
		int validatedQuantity = -1;

		try {
			validatedQuantity = Integer.parseInt(inputQuanity);
			if (validatedQuantity <= 0) {
				throw new InvalidInputException("Quantity should be greater than 0: ");
			}
		} catch (NumberFormatException numberFormatException) {
			throw new InvalidInputException("Quantity should be a number: ");
		}

		return validatedQuantity;
	}

	public static double checkDouble(final String isDouble) throws InvalidInputException {
		double validatedDouble = 0.0;

		try {
			validatedDouble = Double.parseDouble(isDouble);
			if (validatedDouble <= 0) {
				throw new InvalidInputException("Price should be greater than 0: ");
			}

		} catch (NumberFormatException numberFormatException) {
			throw new InvalidInputException("Please enter price in double format: ");

		}
		return validatedDouble;
	}

	public static boolean checkType(final ItemType type) {
		boolean isValidType = false;
		switch (type) {
		case RAW:
			isValidType = true;
			break;
		case MANUFACTURED:
			isValidType = true;
			break;
		case IMPORTED:
			isValidType = true;
			break;
		default:
			break;

		}
		return isValidType;

	}

	public static boolean checkAddMoreItem(final String addMoreItem) throws InvalidInputException {
		boolean isValidInput = false;
		if (addMoreItem.equals("y") || addMoreItem.equals("n")) {
			isValidInput = true;
		} else {
			throw new InvalidInputException("Please enter a valid character:  ");
		}
		return isValidInput;
	}
}
