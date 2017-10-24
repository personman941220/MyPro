package zsk.newIdea;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hasee
 * 描述： 当集合中使用数组对象时，如何调用所有对象中的值，并将其抽象出来。
 * @date 2017年10月23日 上午8:46:12
 * ListTestImpl
 */
public class ListTestImpl {
	public static void main(String[] args){
		List<ListTest> list = new ArrayList<>();
		ListTest lt = new ListTest();
		String[] name = {"sdaji","dsaijgf","dajig"};
		lt.setName(name);
		list.add(lt);
//			String[] names = list.get(0).getName();
//			for(String s:names){
//				System.out.println(s);
//			}
		for(int i = 0;i<list.size();i++){
//			if(list.get(i).getName()){
			for(String s:list.get(i).getName()){
				System.out.println(s);
			}
			//			}
		}
			
	}
}
