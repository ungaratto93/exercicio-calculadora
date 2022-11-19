package main.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.interfaces.Calculator;

public class SimpleCalculator implements Calculator {

	ArrayList<Character> operations = new ArrayList<Character>(List.of('+', '-', 'x', '/'));

	private int valueA;
	private int valueB;
	private char op;

	public SimpleCalculator() {
	}

	public SimpleCalculator(int valueA, char op, int valueB) {
		this.valueA = valueA;
		this.op = op;
		this.valueB = valueB;
	}

	@Override
	public void captureInformations() {

		String input = new Scanner(System.in).nextLine();
		String[] arrayOfInput = input.contains(" ") ? input.split(" ") : handle(input);

		try {
			this.valueA = Integer.parseInt(arrayOfInput[0]);
			this.valueB = Integer.parseInt(arrayOfInput[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Valor invalido");
		}

		char op = arrayOfInput[1].charAt(0);
		if (!operations.contains(op)) {
			throw new IllegalArgumentException("Operacao invalida");
		}
		this.op = op;

	}

	private String[] handle(String input) {
		String[] newInp = new String[3];
		operations.forEach(o -> {
			if(input.contains(o.toString())) {
				String operation = o.toString();
				String tmpInp  = input.replace(operation, " ");
				String[] tmp = tmpInp.split(" ");
				newInp[0] = tmp[0];
				newInp[1] = operation;
				newInp[2] = tmp[1];
			};
		});
		return newInp;
	}

	@Override
	public int getValueA() {
		return this.valueA;
	}

	@Override
	public char getOp() {
		return this.op;
	}

	@Override
	public int getValueB() {
		return this.valueB;
	}

	@Override
	public int calculate() {
		int result = 0;
		switch (this.op) {
		case '+':
			result = this.valueA + this.valueB;
			break;
		case '-':
			result = this.valueA - this.valueB;
			break;
		case 'x':
			result = this.valueA * this.valueB;
			break;
		case '/':
			try {
				result = this.valueA / this.valueB;
				break;
			} catch (ArithmeticException e) {
				throw new IllegalArgumentException("division by zeo");
			}
		}
		return result;
	}

	@Override
	public Integer show(int result) {
		return result;
	}

}
