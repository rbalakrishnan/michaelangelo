package com.vmware;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeTest {

	private Employee employee;

	@BeforeMethod
	public void setUp() {
		employee = new Employee();
		System.out.println("Construct a new employee per test");
	}

	@Test
	public void createEmployeeAndGetName() {

		String name = "Ricardo Montalban";
		employee.setName(name);
		assertEquals(employee.getName(), name);
	}

	@Test
	public void addASocialSecurityNumber() {

		employee.setSocialSecurityNumber("123-45-6789");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6789");
	}

	@Test
	public void addAnotherSocialSecurityNumber() {

		employee.setSocialSecurityNumber("123-45-6710");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6710");
	}

	@Test
	public void fixDE30201_SocialSecurityMustBeACertainFormat() {
		String badSSN = "RamLikesThe49s";
		Employee employee = new Employee();

		try {
			employee.setSocialSecurityNumber(badSSN);
			fail("This line should have never been reached");

		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "RamLikesThe49s is not a valid SSN");
		}
	}

}
