package com.nagarro.assignment1.domain;

public class OrderItem {

	private Item item;

	private int quantity;

	private double tax;

	private double costToPay;

	public double getCostToPay() {
		return costToPay;
	}

	public void setCostToPay(double costToPay) {
		this.costToPay = costToPay;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public int getQuantity() {
		return quantity;
	}

	public Item getItem() {
		return this.item;
	}

	public double getTax() {

		return tax;
	}

}
