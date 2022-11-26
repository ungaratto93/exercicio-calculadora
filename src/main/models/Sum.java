package main.models;

import main.interfaces.Operation;

public class Sum implements Operation {

	@Override
	public int calculate(int valueA, int valueB) {
		return valueA + valueB;
	}
	
}
