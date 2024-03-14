package com.Beom.app.lambda;
@FunctionalInterface //단 한개의 추상메서드가 있는 것을 보장 <- 메서드가 두개있을시 에러

public interface TestInterface {

	public abstract int t1(int n1, int n2);
	
	default void test() {
		TestInterface.t2();		
	}
	
	private static void t2() {
		
	}
	
}
