# 单元测试（JUnit） 基础


## 环境

- JDK 版本：JDK 8
- IDE 版本：IntelliJ IDEA 2017.2
- JUnit 版本：JUnit 4（测试方法无需前面写 test）

## Junit 的 Assert 常用方法

- void assertThat(String reason, T actual, Matcher<T> matcher)
	- JUnit 4.4 新特性，使用了 Hamcrest 框架，具体参考资料：[探索 JUnit 4.4 新特性](https://www.ibm.com/developerworks/cn/java/j-lo-junit44/index.html)
- void assertEquals(boolean expected, boolean actual)
	- 检查两个变量或者等式是否平衡
- void assertTrue(boolean expected, boolean actual)
	- 检查条件为真
- void assertFalse(boolean condition)
	- 检查条件为假
- void assertNotNull(Object object)
	- 检查对象不为空
- void assertNull(Object object)
	- 检查对象为空
- void assertSame(boolean condition)
	- 方法检查两个相关对象是否指向同一个对象
- void assertNotSame(boolean condition)
	- 方法检查两个相关对象是否不指向同一个对象
- void assertArrayEquals(expectedArray, resultArray)
	- 方法检查两个数组是否相等
- fail (String message)
	- 意为失败，用来抛出错误。fail 一旦被执行，会立即中止测试，java 虚拟机不再执行任何别的代码。
