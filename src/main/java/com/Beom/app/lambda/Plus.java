package com.Beom.app.lambda;

public class Plus implements TestInterface{
	
	@Override
	public int t1(int n1, int n2) {
		System.out.println(n1+n2);
		
		return n1+n2;
	}
}
