package com.pawsco.models;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Order {

	private int orderID;
	private String email;
	private Date date;
	private List<LineItem> lineItems;
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", email=" + email + ", date=" + date + ", lineItems=" + lineItems + "]";
	}
	
}
