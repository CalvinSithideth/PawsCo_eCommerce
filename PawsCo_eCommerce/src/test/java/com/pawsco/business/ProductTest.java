package com.pawsco.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	Product product;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		product = new Product();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetProductID() {
		int expected = 1;
		product.setProductID(expected);
		int actual = product.getProductID();
		assertEquals(expected, actual);
	}

	@Test
	void testSetProductID() {
		int expected = 1;
		product.setProductID(expected);
		int actual = product.getProductID();
		assertEquals(expected, actual);
	}

	@Test
	void testGetCategory() {
		String expected = "Testing";
		product.setCategory(expected);
		String actual = product.getCategory();
		assertEquals(expected, actual);
	}

	@Test
	void testSetCategory() {
		String expected = "Testing";
		product.setCategory(expected);
		String actual = product.getCategory();
		assertEquals(expected, actual);
	}

	@Test
	void testGetName() {
		String expected = "Test Name";
		product.setName(expected);
		String actual = product.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetName() {
		String expected = "Test Name";
		product.setName(expected);
		String actual = product.getName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetDescription() {
		String expected = "Test description";
		product.setDescription(expected);
		String actual = product.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	void testSetDescription() {
		String expected = "Test description";
		product.setDescription(expected);
		String actual = product.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	void testGetPrice() {
		double expected = 999.99;
		product.setPrice(expected);
		double actual = product.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	void testSetPrice() {
		double expected = 999.99;
		product.setPrice(expected);
		double actual = product.getPrice();
		assertEquals(expected, actual);
	}

	@Test
	void testGetImageFileName() {
		String expected = "Test file name";
		product.setImageFileName(expected);
		String actual = product.getImageFileName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetImageFileName() {
		String expected = "Test file name";
		product.setImageFileName(expected);
		String actual = product.getImageFileName();
		assertEquals(expected, actual);
	}

}
