package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import main.interfaces.Calculator;
import main.models.SimpleCalculator;

public class CaptureInformationsTest {
	
	@Test
	public void whenUserTypeInfoWithSpaceThenCaptureItAndStoreInObject() {
		/*
		 * Adiciona os dados na entrada do sistema
		 * 
		 * Para que quando o scanner de captura de dados contido na funcao captureInformations
		 * ler desta entrada do sistema, ele ira receber esses bytes adicionados.
		 * 
		 */
		String input = "2 + 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();
		calc.captureInformations();

		assertEquals(2, calc.getValueA());
		assertEquals('+', calc.getOp());
		assertEquals(2, calc.getValueB());
		
	}
	
	@Test
	public void whenUserTypeInfoWithOutSpaceThenCaptureItAndStoreInObject() {
		
		String input = "2+2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();
		calc.captureInformations();

		assertEquals(2, calc.getValueA());
		assertEquals('+', calc.getOp());
		assertEquals(2, calc.getValueB());
		
	}
	
	
	@Test
	public void whenUserTypeInfoWithOutSpaceAndNumbersWith3DigitsThenCaptureItAndStoreInObject() {
		
		String input = "100+100";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();
		calc.captureInformations();

		assertEquals(100, calc.getValueA());
		assertEquals('+', calc.getOp());
		assertEquals(100, calc.getValueB());
		
	}
	
	@Test
	public void whenUserTypeInfoWithSpaceAndInvalidOperatorThenThrowException() {
		
		String input = "2 U 2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();

		assertThrows(IllegalArgumentException.class, () -> calc.captureInformations());
		
	}
	
	@Test
	public void whenUserTypeInfoWithOutSpaceAndInvalidOperatorThenThrowException() {
		
		String input = "2U2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();

		assertThrows(IllegalArgumentException.class, () -> calc.captureInformations());
		
	}
	
	@Test
	public void whenUserTypeInfoWithOutSpaceAndInvalidInputThenThrowException() {
		
		String input = "UUU";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();

		assertThrows(IllegalArgumentException.class, () -> calc.captureInformations());
		
	}
	
	@Test
	public void whenUserTypeInfoWithSpaceAndInvalidInputThenThrowException() {
		
		String input = "U U U";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();

		assertThrows(IllegalArgumentException.class, () -> calc.captureInformations());
		
	}
	
	@Test
	public void whenUserTypeInfoWithSpaceAndValidValuesAndInvalidInputThenThrowException() {
		String input = "U + U";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();

		assertThrows(IllegalArgumentException.class, () -> calc.captureInformations());
		
	}
	
	@Test
	public void whenUserTypeInfoWithOutSpaceAndValidValuesAndInvalidInputThenThrowException() {
		
		String input = "U+U";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
	    Calculator calc = new SimpleCalculator();

		assertThrows(IllegalArgumentException.class, () -> calc.captureInformations());
		
	}
}
