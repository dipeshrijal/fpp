package lesson7.java8interface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartGoldMember implements ShoppingCart {
	private String name;
	private List<Item> items = new ArrayList<>();
	private LocalDate dateOfPurchase;
	private double discount;
	public ShoppingCartGoldMember(String name, 
		LocalDate d, double discount) {
		this.name = name;
		dateOfPurchase = d;
		this.discount = discount;
	}
	public ShoppingCartGoldMember(String name, List<Item> items, 
		LocalDate d, double discount) {
		this(name, d, discount);	
		this.items = items;
	}
	public void addItem(Item item) {
		items.add(item);
	}
	public String getName() { 
		return name;
	}
	public List<Item> getItems() {
		return items;
	}
	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}
	@Override
	public double getDiscount() {
		return discount;
	}
}
