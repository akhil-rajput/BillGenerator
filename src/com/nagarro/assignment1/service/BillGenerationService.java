package com.nagarro.assignment1.service;

import java.util.List;

import com.nagarro.assignment1.domain.Bill;
import com.nagarro.assignment1.domain.OrderItem;

public interface BillGenerationService {

	public Bill calculateBill(final List<OrderItem> orderItems);
}
