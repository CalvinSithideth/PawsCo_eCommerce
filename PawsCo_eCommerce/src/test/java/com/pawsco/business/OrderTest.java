package com.pawsco.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {
	Order order;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		order = new Order();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetOrderID() {
		int expected = 1;
		order.setOrderID(expected);
		int actual = order.getOrderID();
		assertEquals(expected, actual);
	}

	@Test
	void testSetOrderID() {
		int expected = 1;
		order.setOrderID(expected);
		int actual = order.getOrderID();
		assertEquals(expected, actual);
	}

	@Test
	void testGetEmail() {
		String expected = "email@email.com";
		order.setEmail(expected);
		String actual = order.getEmail();
		assertTrue(actual.equals(expected));
	}

	@Test
	void testGetEmailNegative() {
		String expected = "string";
		order.setEmail(expected);
		String actual = order.getEmail();
		assertFalse(expected != actual);
	}

	@Test
	void testSetEmail() {
		String expected = "email@email.com";
		order.setEmail(expected);
		String actual = order.getEmail();
		assertTrue(expected.equals(actual));
	}

	@Test
	void testGetDate() {
		Date date = Date.valueOf(LocalDate.now());
		Date expected = date;
		order.setDate(date);
		Date actual = order.getDate();
		assertEquals(expected, actual);
	}

	@Test
	void testSetDate() {
		Date date = Date.valueOf(LocalDate.now());
		Date expected = date;
		order.setDate(date);
		Date actual = order.getDate();
		assertEquals(expected, actual);
	}

	@Test
	void testGetLineItems(Product product) {
		List<LineItem> expected = new ArrayList<LineItem>();
		LineItem lineItem = new LineItem(new Product(), 3);
		expected.add(lineItem);

		List<LineItem> actual = new ArrayList<LineItem>();
		LineItem lineItem2 = new LineItem(new Product(), 3);
		actual.add(lineItem2);
		order.setLineItems(actual);
		actual = order.getLineItems();
		assertEquals(expected, actual);
	}

	@Test
	void testSetLineItems() {
		List<LineItem> expected = new ArrayList<LineItem>();
		LineItem lineItem = new LineItem(new Product(), 3);
		expected.add(lineItem);

		List<LineItem> actual = new ArrayList<LineItem>();
		LineItem lineItem2 = new LineItem(new Product(), 3);
		actual.add(lineItem2);
		order.setLineItems(actual);
		actual = order.getLineItems();
		assertEquals(expected, actual);
	}

}
