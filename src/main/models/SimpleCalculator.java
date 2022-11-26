package main.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.security.auth.Subject;

import main.interfaces.Calculator;
import main.interfaces.Operation;

public class SimpleCalculator implements Calculator {

	ArrayList<Character> operations = new ArrayList<Character>(List.of('+', '-', 'x', '/'));
	HashMap<Character, Operation> operation = new HashMap<Character, Operation>(
			Map.of(
					'+', new Sum(), 
					'-', new Minus(), 
					'x', new Times(), 
					'/', new Divide()
				)
			);
	
	private int valueA;
	private int valueB;
	private Operation op;

	public SimpleCalculator() {
	}

	public SimpleCalculator(int valueA, Operation op, int valueB) {
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
		if (!operation.containsKey(op)) {
			throw new IllegalArgumentException("Operacao invalida");
		}
		operation.containsKey(op);
		this.op = operation.get(op);

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
	public Operation getOp() {
		return this.op;
	}

	@Override
	public int getValueB() {
		return this.valueB;
	}

	@Override
	public int calculate() {
		return this.op.calculate(this.valueA, this.valueB);
	}

	@Override
	public Integer show(int result) {
		return result;
	}

}
