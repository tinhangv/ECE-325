package ece325.lab.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestSalary{
	
	@Test
	void testPay() {
		assertEquals(55, Salary.pay(100d, 50d, 10),0.001d);
	}
	@Test
	void snacksLessThanSalaryTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(100d, 101d, 2);});
	}
	@Test
	void nullInputTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(null, 23d, 34);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(12d, null, 34);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(45d, 23d, null);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(null, null, 34);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(12d, null, null);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(null, 23d, null);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(null, null, null);});
	}
}
