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

public class CalculateTest {

	@Test
	public void whenCalculateIsInvokedThenMakesThenPlusOperation() {
		
		Calculator calc = new SimpleCalculator(2, new Sum(), 2);
		
		int result = calc.calculate();
		
		assertEquals(4, result);
	}
	
	@Test
	public void whenCalculateIsInvokedThenMakesTheMinusOperation() {
		
		Calculator calc = new SimpleCalculator(2, new Minus(), 2);
		
		int result = calc.calculate();
		
		assertEquals(0, result);
	}
	
	@Test
	public void whenCalculateIsInvokedThenMakesTheTimesOperation() {
		
		Calculator calc = new SimpleCalculator(2, new Times(), 2);
		
		int result = calc.calculate();
		
		assertEquals(4, result);
	}
	
	@Test
	public void whenCalculateIsInvokedThenMakesTheDividedOperation() {
		
		Calculator calc = new SimpleCalculator(2, new Divide(), 2);
		
		int result = calc.calculate();
		
		assertEquals(1, result);
	}
	
	@Test
	public void whenCalculateIsInvokedForMakesTheDividedByZeroThenThrowsException() {
		
		Calculator calc = new SimpleCalculator(1, new Divide(), 0);
		
		assertThrows(IllegalArgumentException.class, () -> calc.calculate());

	}
}
