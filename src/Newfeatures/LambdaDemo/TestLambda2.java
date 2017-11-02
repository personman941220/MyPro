package Newfeatures.LambdaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author hasee ������java8���õ��Ĵ���ĺ���ʽ�ӿ�
 * @date 2017��10��31�� ����10:42:00 TestLambda2
 */
public class TestLambda2 {
	// Predicate<T> �����ͽӿڡ�
	// boolean test(T t);
	@Test
	public void test4() {
		List<String> list = Arrays.asList("Hello", "aaad", "lambda", "weige", "zsknb");
		List<String> strList = filterStr(list, (str) -> str.length() == 5);
		for (String str : strList) {
			System.out.println(str);
		}
	}

	// �������������ַ������뼯���С�
	public List<String> filterStr(List<String> str, Predicate<String> pre) {
		List<String> strlist = new ArrayList<>();

		for (String str1 : str) {
			if (pre.Test(str1)) {
				strlist.add(str1);
			}
		}
		return strlist;
	}

	// Function<T,R> �����ͽӿ�;
	// R apply(T t);
	@Test
	public void test3() {
		String newStr = strHandler("\t\t\t\t ΰ��ţ�ƣ� ", (str) -> str.trim());
		System.out.println(newStr);
		Function<String, String> f = String::trim;// ʹ�÷������õķ�ʽ��
		System.out.println(f.apply("\t\t\t\t ΰ��ţ�ƣ� "));
	}

	// �����ַ���
	public String strHandler(String str, Function<String, String> fun) {
		return fun.apply(str);
	}

	// Supplier<T> �����ͽӿ�
	// T get();
	@Test
	public void test2() {
		List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
		for (Integer num : numList) {
			System.out.println(num);
		}

	}

	// ����һЩ�����������뼯��
	public List<Integer> getNumList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}

	// Consumer<T>�����Խӿ�
	// void accept(T t);
	@Test
	public void test1() {
		happy(10000, (m) -> System.out.println(m + "Ԫ"));
	}

	public void happy(double money, Cousumer<Double> con) {
		con.accept(money);
	}
}
