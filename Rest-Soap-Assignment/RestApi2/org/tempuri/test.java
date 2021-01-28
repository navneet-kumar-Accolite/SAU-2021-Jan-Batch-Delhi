package org.tempuri;

public class test {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		Calculator cal = new Calculator();
		CalculatorSoap soap = cal.getCalculatorSoap();
		
		int add = soap.add(a, b);
		
		System.out.println(add);
	}
}
