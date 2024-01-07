package com.example.tryaround.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@Component
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionID;
	private double balance;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	private List<Product> products = new ArrayList<Product>();
	
	public Transaction() {
		super();
	}
	
	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public long getTransactionID() {
		return transactionID;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	

	public void addProduct(Product product){
		products.add(product);
	}
	
	public List<Product> showListProduct(){
		return products;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public double calculateTotal() {
		double total=0;
		for (Product product : products){
		    total= total+product.getProductPrice();
		}
		return total;
	}
	
}
