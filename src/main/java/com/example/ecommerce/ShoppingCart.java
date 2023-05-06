package com.example.ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER
    )

	private List<Item> items = new ArrayList<>();
	
	@Column(
            name = "shopping_cart_customer_name",
            nullable = false
    )
	private String customerName;
	
	@Column(
			name = "shopping_cart_discount",
			nullable = false
	)
	private double discount;
	
	public ShoppingCart () {}

	public ShoppingCart(String customerName, double discount) {
		//this.items = items;
		this.id = Long.valueOf(0);
		this.customerName = customerName;
		this.discount = discount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items +", id=" + id + ", customerName=" + customerName + ", discount="
				+ discount + "]";
	}

}
