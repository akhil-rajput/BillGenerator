package com.nagarro.assignment1.view;

import java.util.List;
import com.nagarro.assignment1.domain.Bill;
import com.nagarro.assignment1.domain.Item;
import com.nagarro.assignment1.domain.OrderItem;

public class Output {

	public void displayBill(Bill bill) {
		printDottedLine();
		String header = String.format("%-20s%-20s%-20s%-25s%-38s%-25s", "Item name", "Item price", "Type", "Quantity",
				"sales tax liability per item", "Cost to pay");
		System.out.println(header);
		System.out.println();
		printDottedLine();
		displayData(bill);
	}

	public void displayData(Bill bill) {
		List<OrderItem> items = bill.getOrderItems();
		for (OrderItem item : items) {
			Item product = item.getItem();
			String content = String.format("%-20s%-20s%-20s%-25d%-38.3f%-25.3f", product.getName(), product.getPrice(),
					product.getType(), item.getQuantity(), item.getTax(), item.getCostToPay());
			System.out.println(content);
		}
		printDottedLine();
		System.out.print("Total Price:        ");
		String totalPrice = String.format("%-26.3f", bill.getTotalPrice());
		System.out.println(totalPrice);
		printDottedLine();
	}

	public void printDottedLine() {
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------");
	}
}
