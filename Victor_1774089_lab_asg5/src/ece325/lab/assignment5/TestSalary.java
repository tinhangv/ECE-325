package ece325.lab.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestSalary{
	@Test
	void commonCaseTest() {
		assertEquals(55.0, Salary.pay(100d, 50d, 10),0.001d);
	}
	@Test
	void commonCase2Test() {
		assertEquals(265.907, Salary.pay(345.67, 89.99, 4),0.001d);
	}
	@Test
	void maxSalaryTest() {
		assertEquals(952.652, Salary.pay(1000d, 56.78, 1),0.001d);
	}
	@Test
	void maxBonusTest() {
		assertEquals(165.0, Salary.pay(200d, 50d, 10),0.001d);
	}
	@Test
	void maxAllTest() {
		assertEquals(0.0, Salary.pay(1000d, 1000d, 10),0.001d);
	}
	@Test
	void snacksEqualSalaryTest() {
		assertEquals(0.0, Salary.pay(234.56, 234.56, 3),0.001d);
	}
	@Test
	void zeroSalaryTest() {
		assertEquals(0.0, Salary.pay(0d, 0d, 7),0.001d);
	}
	@Test
	void zeroSnacksTest() {
		assertEquals(483.439, Salary.pay(473.96, 0d, 2),0.001d);
	}
	@Test
	void zeroBonusTest() {
		assertEquals(745.33, Salary.pay(999.99, 254.66, 0),0.001d);
	}
	@Test
	void negativeSalaryTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(-0.01, 2d, 2);});
	}
	@Test
	void negativeSnacksTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(3d, -0.01, 3);});
	}
	@Test
	void negativeBonusTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(4d, 4d, -1);});
	}
	@Test
	void salaryOutOfBoundsTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(1000.01, 55d, 6);});
	}
	@Test
	void bonusOutOfBoundsTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(77d, 76d, 11);});
	}
	@Test
	void snacksMoreThanSalaryTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(100d, 101d, 2);});
	}
	@Test
	void nullSalaryTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(null, 23d, 3);});
	}
	@Test
	void nullSnacksTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(45d, null, 3);});
	}
	@Test
	void nullBonusTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(45d, 23d, null);});
	}
	@Test
	void multipleNullInputsTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(null, null, 3);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(null, 23d, null);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(45d, null, null);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(null, null, null);});
	}
	@Test
	void salaryExtremeValuesTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(Double.MAX_VALUE, 23d, 3);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(-Double.MAX_VALUE, 23d, 3);});
	}
	@Test
	void snacksExtremeValuesTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(45d, Double.MAX_VALUE, 3);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(45d, -Double.MAX_VALUE, 3);});
	}
	@Test
	void bonusExtremeValuesTest() {
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(45d, 23d, Integer.MAX_VALUE);});
		assertThrows(IllegalArgumentException.class, ()-> {Salary.pay(45d, 23d, -Integer.MAX_VALUE);});
	}
}
