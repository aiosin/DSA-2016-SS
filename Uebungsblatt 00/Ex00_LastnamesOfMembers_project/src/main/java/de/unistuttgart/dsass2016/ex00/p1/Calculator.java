package de.unistuttgart.dsass2016.ex00.p1;

/**
 * 
 * @author zython5
 *
 */
public class Calculator implements ICalculator {

	@Override
	public int add(int a, int b) {
		int x = a+ b;
		return x;
		
	}

	@Override
	public int subtract(int a, int b) {
		int x = a - b;
		return x;
	}

	@Override
	public int multiply(int a, int b) {
		int x = a*b;
		return x;
		
	}

	@Override
	public int max(int a, int b) {
		if(a>b){
			return a;
		}else {
			return b;
		}
	}


}