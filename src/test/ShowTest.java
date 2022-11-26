package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import main.interfaces.Calculator;
import main.models.Divide;
import main.models.Minus;
import main.models.SimpleCalculator;
import main.models.Sum;
import main.models.Times;

public class ShowTest {

	@Test
	public void whenInvokeShowMethodWithPlusThenResultOfOperationsIsDisplayed() {
		
		Calculator calc = new SimpleCalculator(1, new Sum(), 1);
		assertEquals(2, calc.show(calc.calculate()));
		
	}

	@Test
	public void whenInvokeShowMethodWithMinusThenResultOfOperationsIsDisplayed() {
		
		Calculator calc = new SimpleCalculator(1, new Minus(), 1);
		assertEquals(0, calc.show(calc.calculate()));
		
	}
	
	@Test
	public void whenInvokeShowMethodWithTimesThenResultOfOperationsIsDisplayed() {
		
		Calculator calc = new SimpleCalculator(1, new Times(), 1);
		assertEquals(1, calc.show(calc.calculate()));
		
	}
	
	@Test
	public void whenInvokeShowMethodWithDividedThenResultOfOperationsIsDisplayed() {
		
		Calculator calc = new SimpleCalculator(1, new Divide(), 1);
		assertEquals(1, calc.show(calc.calculate()));
		
	}
	
	@Test
	public void whenInvokeShowMethodWithDividedWithLeftZeroThenResultOfOperationsIsDisplayed() {
		
		Calculator calc = new SimpleCalculator(0, new Divide(), 1);
		assertEquals(0, calc.show(calc.calculate()));
		
	}
	
	@Test
	public void whenInvokeShowMethodWithDividedByZeroThenThrowsException() {
		
		Calculator calc = new SimpleCalculator(1, new Divide(), 0);
		assertThrows(IllegalArgumentException.class, () -> calc.show(calc.calculate()));

	}
}
