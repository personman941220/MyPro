package Newfeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author hasee 描述：Lamdbtest用来学习
 * @date 2017年10月19日 上午11:30:28 lamdbatest
 */
public class lamdbatest {
	List<Person> person = Arrays.asList(new Person(101, "张三", 17, 29310.22), new Person(102, "李四", 34, 2341.22),
			new Person(103, "王五", 127, 5223.22), new Person(104, "自古", 44, 1234567.22));

	@Test
	public void Test1() {
		Collections.sort(person, (e1, e2) -> {
			if (e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			} else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		for (Person per : person) {
			System.out.println(per);
		}
	}
	//用于处理字符串。trim,upper,substring都可以使用。
	public String strHandler(String str,MyFun my){
		return my.getValue(str);
	}
	
	@Test
	public void Test2(){
		String Trimstr = strHandler("可以的，666 ",(str) -> str.trim());
		System.out.println(Trimstr);
	}
}
