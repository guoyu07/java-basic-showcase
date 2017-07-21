package com.youmeek.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	private Calculator calculator = null;

	//======================================================环境准备 start======================================================

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("--------------------------------测试用例初始化前的准备（必须是 static 修饰）");
		System.out.println();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		System.out.println();
		System.out.println("--------------------------------类完成后的收尾（必须是 static 修饰）");
	}

	@Before
	public void before() throws Exception {
		System.out.println("--------------------------------单元测试每个方法开始前的准备，每个测试方法执行之前都要执行一次");

		if (calculator == null) {
			calculator = new Calculator();
		}
	}

	@After
	public void after() throws Exception {
		System.out.println("--------------------------------单元测试每个方法结束前的收尾，每个测试方法执行之后都要执行一次");
		System.out.println();
	}
	//======================================================环境准备 end======================================================

	//======================================================最简单的测试 start======================================================


	@Test
	public void add() throws Exception {
		int result = calculator.add(2, 3);
		System.out.println("--------------------------------加法计算结果：" + result);
		assertEquals("加法计算错误", result, 5);
	}

	@Test
	public void subtract() throws Exception {
		int result = calculator.subtract(3, 2);
		System.out.println("--------------------------------减法计算结果：" + result);
		assertEquals("减法计算错误", result, 1);
	}

	@Test
	public void multiply() throws Exception {
		int result = calculator.multiply(2, 3);
		System.out.println("--------------------------------乘法计算结果：" + result);
		assertEquals("乘法计算错误", result, 6);
	}

	@Test
	public void device() throws Exception {
		int result = calculator.device(3, 2);
		System.out.println("--------------------------------除法计算结果：" + result);
		assertEquals("除法计算错误", result, 1);
	}

	//======================================================最简单的测试 end======================================================


}