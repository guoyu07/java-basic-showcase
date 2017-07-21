package com.youmeek.java;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JUnitBasicDemo {


	//======================================================JUnit 其他知识点 start======================================================

	@Ignore("该方法被忽略测试，忽略的时候当前这句话被控制台打印出来，但是方法不会被执行。这里可以用来告诉测试者为什么这里要被忽略。Ignore 也可以用来注解在类上。")
	@Test
	public void testIgnoreAnnotation() {
		System.out.println("--------------------------------对整个类进行做单元测试的时候，有 @Ignore 会被忽略，所以当前这句话是不会被执行，控制台也看不到。");
	}

	/**
	 * timeout （毫秒） 如果测试方法在制定的时间之内没有运行完，也算测试也失败
	 *
	 * @throws Exception
	 */
	@Test(timeout = 15)
	public void testTimeoutAnnotation() throws Exception {
		System.out.println("--------------------------------超时测试");
	}

	@Test(expected = ArithmeticException.class)
	public void testExpectedAnnotation() {
		int a = 0;
		int b = 1 / a;
		assertEquals("捕获特定异常，如果测试用例有抛出注解上的异常或是此异常的父类，则表示测试通过。", b, 0);
	}

	//======================================================JUnit 其他知识点 end======================================================

	//======================================================新特性 assertThat 讲解 start======================================================


	/**
	 * 需要额外引入：import static org.hamcrest.Matchers.*;
	 *
	 * @throws Exception
	 */
	@Ignore
	@Test
	public void testNewFeatureByAssertThat() throws Exception {
		String tempString = "GitNavi.com 是一个可以自定义的网址导航";

		// anyOf 表示任何一个条件满足则成立，类似于逻辑或 "||"， 匹配符 containsString 表示是否含有参数子字符串
		assertThat("该字符串没有包含 '自定义' 或 '导航' 等字眼", tempString, anyOf(containsString("自定义"), containsString("导航")));

		// allOf: 所有条件都必须满足，相当于 &&  
		assertThat("该字符串没有以 'Git' 开头 并且包含 '网址导航'", tempString, allOf(startsWith("Git"), containsString("网址导航")));
		// both: &&  
		assertThat(tempString, both(containsString("自定义")).and(containsString("导航")));

		// either: 两者之一  
		assertThat(tempString, either(containsString("自定义")).or(containsString("导航")));

		// everyItem: 每个元素都需满足特定条件  
		assertThat(Arrays.asList("my", "mine"), everyItem(startsWith("m")));

		// hasItem: 是否有这个元素  
		assertThat(Arrays.asList("my", "mine"), hasItem("my"));

		// hasItems: 包含多个元素  
		assertThat(Arrays.asList("my", "mine", "your"), hasItems("your", "my"));

		// is: 默认是 is(equalTo(x)) 的简写，equalTo 可以断言数值之间，字符串之间和对象之间是否相等，相当于 Object 的equals方法 
		assertThat(tempString, is(tempString));
		assertThat(tempString, is(equalTo(tempString)));
		assertThat(tempString, is(instanceOf(String.class)));


		// not: 否为真，相当于！，
		assertThat(tempString, is(not("you")));

		// anything(): 任何情况下，都匹配正确  
		assertThat(tempString, anything());

		// nullValue(): 值为空  
		String str = null;
		assertThat(str, is(nullValue()));

		// notNullValue(): 值不为空  
		String str2 = "123";
		assertThat(str2, is(notNullValue()));

		// 字符串匹配  
		// containsString：包含字符串  
		assertThat(tempString, containsString("na"));

		// stringContainsInOrder: 顺序包含，“my”必须在“me”前面  
		assertThat(tempString, stringContainsInOrder(Arrays.asList("my", "me")));

		// endsWith: 后缀  
		assertThat(tempString, endsWith("me"));

		// startsWith: 前缀  
		assertThat(tempString, startsWith("my"));

		// isEmptyString(): 空字符串  
		assertThat("", isEmptyString());

		// equalTo: 值相等， Object.equals(Object)  
		assertThat(tempString, equalTo(tempString));
		assertThat(new String[]{"a", "b"}, equalTo(new String[]{"a", "b"}));

		// equalToIgnoringCase: 比较时，忽略大小写  
		assertThat(tempString, equalToIgnoringCase(tempString));

		// equalToIgnoringWhiteSpace: 比较时， 首尾空格忽略， 比较时中间用单个空格  
		assertThat(" my \t name ", equalToIgnoringWhiteSpace(" my name "));

		// isOneOf: 是否为其中之一  
		assertThat(tempString, isOneOf(tempString, "yourname"));

		// isIn: 是否为其成员  
		assertThat(tempString, isIn(new String[]{tempString, "yourname"}));

		// toString() 返回值校验  
		assertThat(333, hasToString(equalTo("333")));


		// 数值之间范围区间匹配
		// 以下面为例，closeTo 匹配符被测的浮点型数 3.14 与 3 之间相差区间绝对值值，相差的这个值在 0.5 范围之内，则断言正确，不然就是错误。要求参数数字是 Double 或 BigDecimal 类型
		assertThat(3.14, closeTo(3, 0.2));
		assertThat(new BigDecimal("3.14"), is(closeTo(new BigDecimal("3"), new BigDecimal("0.5"))));

		// comparesEqualTo: compareTo比较值  
		assertThat(2, comparesEqualTo(2));

		// greaterThan： 大于  
		assertThat(2, greaterThan(0));

		// greaterThanOrEqualTo: 大于等于
		assertThat(2, greaterThanOrEqualTo(2));

		// lessThan: 小于  
		assertThat(0, lessThan(2));

		// lessThanOrEqualTo: 小于等于  
		assertThat(0, lessThanOrEqualTo(0));


		// 集合匹配  
		// array: 数组长度相等且对应元素也相等  
		assertThat(new Integer[]{1, 2, 3}, is(array(equalTo(1), equalTo(2), equalTo(3))));

		// hasItemInArray: 数组是否包含特定元素  
		assertThat(new String[]{"my", "you"}, hasItemInArray(startsWith("y")));

		// arrayContainingInAnyOrder， 顺序无关，长度要一致  
		assertThat(new String[]{"my", "you"}, arrayContainingInAnyOrder("you", "my"));

		// arrayContaining:  顺序，长度一致  
		assertThat(new String[]{"my", "you"}, arrayContaining("my", "you"));

		// arrayWithSize: 数组长度  
		assertThat(new String[]{"my", "you"}, arrayWithSize(2));

		// emptyArray: 空数组  
		assertThat(new String[0], emptyArray());

		// hasSize: 集合大小  
		assertThat(Arrays.asList("my", "you"), hasSize(equalTo(2)));

		// empty: 空集合  
		assertThat(new ArrayList<String>(), is(empty()));

		// isIn: 是否为集合成员  
		assertThat(tempString, isIn(Arrays.asList(tempString, "yourname")));

		// Map匹配  
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("name", "john");
		// hasEntry: key && value匹配  
		assertThat(myMap, hasEntry("name", "john"));

		// hasKey: key匹配  
		assertThat(myMap, hasKey(equalTo("name")));

		// hasValue: value匹配  
		assertThat(myMap, hasValue(equalTo("john")));

	}


	//======================================================新特性 assertThat 讲解 end======================================================

}
