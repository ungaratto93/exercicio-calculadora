package main.models;

import main.interfaces.Operation;

public class Divide implements Operation {

	@Override
	public int calculate(int valueA, int valueB) {
		int result;
		try {
			result = valueA / valueB;
		} catch (ArithmeticException e) {
			throw new IllegalArgumentException("division by zeo");
		}	
		return result;
	}
	
}
