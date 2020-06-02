package com.pawsco.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pawsco.models.User;

class UserTest {
	User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user = new User();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetEmail() {
		String expected = ("test@email.com");
		user.setEmail(expected);
		String actual = user.getEmail();
		assertEquals(expected, actual);
	}

	@Test
	void testSetEmail() {
		String expected = ("test@email.com");
		user.setEmail(expected);
		String actual = user.getEmail();
		assertEquals(expected, actual);
	}

	@Test
	void testGetFirstName() {
		String expected = ("testFName");
		user.setFirstName(expected);
		String actual = user.getFirstName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetFirstName() {
		String expected = ("testFName");
		user.setFirstName(expected);
		String actual = user.getFirstName();
		assertEquals(expected, actual);
	}

	@Test
	void testGetLastName() {
		String expected = ("testLName");
		user.setLastName(expected);
		String actual = user.getLastName();
		assertEquals(expected, actual);
	}

	@Test
	void testSetLastName() {
		String expected = ("testLName");
		user.setLastName(expected);
		String actual = user.getLastName();
		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		user.toString();
		String expected = user.toString();
		String actual = user.toString();
		assertEquals(expected, actual);
	}

}