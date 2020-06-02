package com.supplyworld.models;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderModel {

	private int orderID;
	private String customer;
	private Date date;
	private int productID;
	private int quantity;
	private boolean fulfilledStatus;
	public int getOrderID()
	{
		return orderID;
	}
	public void setOrderID(int orderID)
	{
		this.orderID = orderID;
	}
	public String getCustomer()
	{
		return customer;
	}
	public void setCustomer(String customer)
	{
		this.customer = customer;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public int getProductID()
	{
		return productID;
	}
	public void setProductID(int productID)
	{
		this.productID = productID;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public boolean isFulfilledStatus()
	{
		return fulfilledStatus;
	}
	public void setFulfilledStatus(boolean fulfilledStatus)
	{
		this.fulfilledStatus = fulfilledStatus;
	}
	@Override
	public String toString()
	{
		return "OrderModel [orderID=" + orderID + ", customer=" + customer + ", date=" + date + ", productID="
				+ productID + ", quantity=" + quantity + ", fulfilledStatus=" + fulfilledStatus + "]";
	}
	

	
}
