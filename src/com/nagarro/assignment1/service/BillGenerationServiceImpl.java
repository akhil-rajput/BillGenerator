package com.nagarro.assignment1.service;

import java.util.*;

import com.nagarro.assignment1.domain.Bill;
import com.nagarro.assignment1.domain.Item;
import com.nagarro.assignment1.domain.ItemType;
import com.nagarro.assignment1.domain.OrderItem;
import com.nagarro.assignment1.util.CommonConstants;

public class BillGenerationServiceImpl implements BillGenerationService {

	public Bill calculateBill(final List<OrderItem> orderItems) {

		double totalPrice = 0.0;
		for (OrderItem orderItem : orderItems) {
			final Item item = orderItem.getItem();
			final double itemTax = calcTax(item);
			final double finalItemPrice = calcFinalItemPrice(item, itemTax);
			orderItem.setTax(itemTax);
			totalPrice += finalItemPrice * orderItem.getQuantity();
			orderItem.setCostToPay(finalItemPrice * orderItem.getQuantity());
		}
		final Bill bill = new Bill();
		bill.setOrderItems(orderItems);
		bill.setTotalPrice(totalPrice);
		return bill;
	}

	public double calRawTax(final Item item) {
		double tax = (item.getPrice() * CommonConstants.RAW_TAX);
		return tax;
	}

	public double calManufacturedTax(final Item item) {
		double tax = CommonConstants.MANUFACTURED_TAX * item.getPrice();
		double finalItemPrice = item.getPrice() + tax;
		tax += (finalItemPrice) * CommonConstants.MANUFACTURED_SURCHARGE;
		return tax;
	}

	public double calImportedTax(final Item item) {
		double tax = CommonConstants.IMPORTED_TAX * item.getPrice();
		double finalItemPrice = item.getPrice() + tax;
		if (finalItemPrice <= 100) {
			tax += CommonConstants.IMPORTED_SURCHARGE_lESSTHAN100;
		} else if (finalItemPrice > 100) {
			tax += CommonConstants.IMPORTED_SURCHARGE_lESSTHAN200;
		} else {
			tax += finalItemPrice * CommonConstants.IMPORTED_SURCHARGE_MORETHAN200;
		}
		return tax;
	}

	private double calcFinalItemPrice(final Item item, final double itemTax) {
		double finalItemPrice = item.getPrice() + itemTax;
		return finalItemPrice;
	}

	public double calcTax(final Item item) {
		final ItemType type = item.getType();
		double tax = 0.0;
		switch (type) {
		case RAW:
			tax = calRawTax(item);
			break;
		case MANUFACTURED:
			tax = calManufacturedTax(item);
			break;
		case IMPORTED:
			tax = calImportedTax(item);
			break;
		default:
			break;
		}
		return tax;
	}

}
