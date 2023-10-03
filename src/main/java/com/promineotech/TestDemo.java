package com.promineotech;

import java.util.Random;

public class TestDemo { 
	
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return (a+b);
		}else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	public boolean isDivisibleByTen(int number) {
		return number % 10 == 0;
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	public int randomNumberSquared() {
		int number = getRandomInt();
		return number * number;
	}
	
}
