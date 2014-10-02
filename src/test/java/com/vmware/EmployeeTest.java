package com.vmware;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class EmployeeTest {

	@Test
	public void createEmployeeAndGetName() {
		Employee employee = new Employee();
		String name = "Ricardo Montalban";
		employee.setName(name);
		assertEquals(employee.getName(), name);
	}
}
