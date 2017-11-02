package Newfeatures.LambdaDemo;

/**
 * @author hasee 描述：Lambda延伸，方法引用
 * @date 2017年11月2日 上午8:24:42 MethodDemo
 */
class Person1<T, s1, s2> {
	private String name;
	private int age;

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person1 [name=" + name + ", age=" + age + "]";
	}
}

interface Ipe<T, R> { // 静态调用
	R zhuanhuan(T t);

}

interface Ipe2<R> { // 对象调用
	public R zhuanhuan();
}

interface Ipe3<s, s1, s2> { // 构造方法的引用。
	public s create(s1 s, s2 s2);
}

public class MethodDemo {
	public static void main(String[] args) {
		Ipe<Integer, String> m = String::valueOf; // 静态方法调用
		System.out.println(m.zhuanhuan(1000).length());
		Ipe2<String> m2 = "fuck"::toUpperCase;
		System.out.println(m2.zhuanhuan());
		Ipe3<Person1, String, Integer> m3 = Person1::new;
		System.out.println(m3.create("伟哥", 99));
	}

}
