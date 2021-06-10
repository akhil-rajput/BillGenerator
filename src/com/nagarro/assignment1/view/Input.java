package com.nagarro.assignment1.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.nagarro.assignment1.domain.Item;
import com.nagarro.assignment1.domain.ItemType;
import com.nagarro.assignment1.domain.OrderItem;
import com.nagarro.assignment1.exception.InvalidInputException;
import com.nagarro.assignment1.util.ValidationUtil;

public class Input {
	public List<OrderItem> takeOrder() {
		final List<OrderItem> orderItems = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Enter item details: ");
			final Item item = new Item();
			final OrderItem orderItem = new OrderItem();
			flag = takeInput(item, orderItem, scanner);
			orderItem.setItem(item);
			orderItems.add(orderItem);
		}
		scanner.close();
		return orderItems;
	}

	public boolean takeInput(final Item item, final OrderItem orderItem, final Scanner scanner) {
		setName(item, orderItem, scanner);
		setPrice(item, orderItem, scanner);
		setType(item, orderItem, scanner);
		setQuantity(item, orderItem, scanner);
		boolean flag = addMoreItem(scanner);
		return flag;
	}

	public void setName(final Item item, final OrderItem orderItem, final Scanner scanner) {
		System.out.print("Enter name :");
		boolean isValidInput = false;
		do {
			String name = scanner.nextLine();
			try {
				name = ValidationUtil.getValidatedName(name);
				item.setName(name);
				isValidInput=true;
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
				isValidInput = false;
			}
		} while (!isValidInput);
	}

	public void setPrice(final Item item, final OrderItem orderItem, final Scanner scanner) {
		System.out.print("Enter Price: ");
		boolean isValidPrice = false;
		do {
			String validatedPrice = scanner.nextLine();
			try {
				double price = ValidationUtil.checkDouble(validatedPrice);
				item.setPrice(price);
				isValidPrice = true;
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
			}
		} while (!isValidPrice);
	}

	public void setType(final Item item, final OrderItem orderItem, final Scanner scanner) {
		System.out.print("Enter type: ");
		boolean isValidType = false;
		do {
			try {
				final ItemType type;
				type = ItemType.valueOf(scanner.nextLine().toUpperCase());
				isValidType = ValidationUtil.checkType(type);
				item.setType(type);
			} catch (IllegalArgumentException illegalArgumentException) {
				System.err.print("Please enter the type in specified format : (raw, manufactured,imported)");
			}
		} while (!isValidType);
	}

	public void setQuantity(final Item item, final OrderItem orderItem, final Scanner scanner) {
		System.out.print("Enter Quantity: ");
		boolean isQunatityValid = false;
		do {
			final String inputQuantity = scanner.nextLine();
			try {
				final int validatedQuantity = ValidationUtil.getValidatedQuantity(inputQuantity);
				orderItem.setQuantity(validatedQuantity);
				isQunatityValid = true;
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
			}
		} while (!isQunatityValid);
	}

	public boolean addMoreItem(final Scanner scanner) {
		String addMoreItem;
		boolean hasItems = true;
		System.out.print("Do you want to enter details of any other item (y/n): ");
		boolean isValidInput = false;
		do {
			addMoreItem = scanner.nextLine().toLowerCase();
			try {
				isValidInput = ValidationUtil.checkAddMoreItem(addMoreItem);
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
			}
		} while (!isValidInput);
		if (addMoreItem.equals("n")) {
			hasItems = false;
		}
		return hasItems;
	}

}
