package com.nagarro.assignment1.controller;

import java.util.List;

import com.nagarro.assignment1.domain.Bill;
import com.nagarro.assignment1.domain.OrderItem;
import com.nagarro.assignment1.service.BillGenerationService;
import com.nagarro.assignment1.service.BillGenerationServiceImpl;
import com.nagarro.assignment1.view.Input;
import com.nagarro.assignment1.view.Output;

public class Application {

	public static void main(String args[]) {
		final Input input = new Input();
		final List<OrderItem> orderItems = input.takeOrder();

		final BillGenerationService billGenerationService = new BillGenerationServiceImpl();
		final Bill bill = billGenerationService.calculateBill(orderItems);

		final Output output = new Output();
		output.displayBill(bill);
	}
}
