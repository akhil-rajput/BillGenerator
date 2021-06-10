package com.nagarro.assignment1.domain;

public class Item {

	private String name;

	private double price;

	private ItemType type;

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
