package com.example.tryaround.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userID;
	@Column(unique=true)
	private String username;
	private String password;
	private String address;
	private double balance;
		
	@OneToMany(mappedBy="user")
	private List<Transaction> transactionUser= new ArrayList<Transaction>();
	
	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addToTransactionList(Transaction transaction){
		transactionUser.add(transaction);
	}
	
	public List<Transaction> getTransactionList(){
		return transactionUser;
	}	
}
