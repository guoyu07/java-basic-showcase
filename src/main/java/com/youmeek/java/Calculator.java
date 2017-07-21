package com.youmeek.java;

/**
 * 一个简单的计算器工具类
 */
public class Calculator {
	
	public static int add(int a, int b) {
		return a + b;
	}

	public static int subtract(int a, int b) {
		return a - b;
	}
	
	public static int multiply(int a, int b) {
		device(a, b);
		subtract(a,b);
		return a * b;
	}

	public static int device(int a, int b) {
		return a / b;
	}

}
