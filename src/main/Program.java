package main;

import main.interfaces.Calculator;
import main.models.SimpleCalculator;

public class Program {

	public static void main(String[] args) {
		Calculator calc = new SimpleCalculator();
		
		while (true) {
			try {
				run(calc);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
	}

	private static void run(Calculator calc) {
		calc.captureInformations();
		System.out.println(calc.show(calc.calculate()) + "\n");
	}

}
