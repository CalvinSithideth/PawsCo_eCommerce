package com.pawsco.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineItemTest {
	LineItem lineItem;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		lineItem = new LineItem();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetProduct() {
		Product expected = new Product();
		lineItem.setProduct(expected);
		Product actual = lineItem.getProduct();
		assertEquals(expected, actual);
	}

	@Test
	void testSetProduct() {
		Product expected = new Product();
		lineItem.setProduct(expected);
		Product actual = lineItem.getProduct();
		assertEquals(expected, actual);
	}

	@Test
	void testGetQuantity() {
		int expected = 2;
		lineItem.setQuantity(expected);
		int actual = lineItem.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	void testSetQuantity() {
		int expected = 2;
		lineItem.setQuantity(expected);
		int actual = lineItem.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		String expected = new String();
		lineItem.toString();
		String actual = lineItem.toString();
		assertEquals(expected, actual);
	}
}