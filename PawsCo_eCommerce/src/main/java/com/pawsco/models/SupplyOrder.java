package com.pawsco.models;

public class SupplyOrder {

	private int orderID;
	private int productID;
	private int quantity;
	private boolean fulfilledStatus;
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isFulfilledStatus() {
		return fulfilledStatus;
	}
	public void setFulfilledStatus(boolean fulfilledStatus) {
		this.fulfilledStatus = fulfilledStatus;
	}
	
	@Override
	public String toString() {
		return "SupplyOrder [orderID=" + orderID + ", productID=" + productID + ", quantity=" + quantity
				+ ", fulfilledStatus=" + fulfilledStatus + "]";
	}
}
