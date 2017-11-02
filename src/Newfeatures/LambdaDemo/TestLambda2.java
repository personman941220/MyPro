package Newfeatures.LambdaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author hasee 描述：java8内置的四大核心函数式接口
 * @date 2017年10月31日 上午10:42:00 TestLambda2
 */
public class TestLambda2 {
	// Predicate<T> 断言型接口。
	// boolean test(T t);
	@Test
	public void test4() {
		List<String> list = Arrays.asList("Hello", "aaad", "lambda", "weige", "zsknb");
		List<String> strList = filterStr(list, (str) -> str.length() == 5);
		for (String str : strList) {
			System.out.println(str);
		}
	}

	// 将满足条件的字符串放入集合中。
	public List<String> filterStr(List<String> str, Predicate<String> pre) {
		List<String> strlist = new ArrayList<>();

		for (String str1 : str) {
			if (pre.Test(str1)) {
				strlist.add(str1);
			}
		}
		return strlist;
	}

	// Function<T,R> 函数型接口;
	// R apply(T t);
	@Test
	public void test3() {
		String newStr = strHandler("\t\t\t\t 伟哥牛逼！ ", (str) -> str.trim());
		System.out.println(newStr);
		Function<String, String> f = String::trim;// 使用方法引用的方式。
		System.out.println(f.apply("\t\t\t\t 伟哥牛逼！ "));
	}

	// 处理字符串
	public String strHandler(String str, Function<String, String> fun) {
		return fun.apply(str);
	}

	// Supplier<T> 供给型接口
	// T get();
	@Test
	public void test2() {
		List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
		for (Integer num : numList) {
			System.out.println(num);
		}

	}

	// 产生一些整数，并放入集合
	public List<Integer> getNumList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}

	// Consumer<T>消费性接口
	// void accept(T t);
	@Test
	public void test1() {
		happy(10000, (m) -> System.out.println(m + "元"));
	}

	public void happy(double money, Cousumer<Double> con) {
		con.accept(money);
	}
}
