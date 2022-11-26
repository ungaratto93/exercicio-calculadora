package main.interfaces;

public interface Calculator {

	void captureInformations();

	int getValueA();

	Operation getOp();

	int getValueB();

	int calculate();

	Integer show(int result);

}
