package zsk.newIdea;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hasee
 * ������ ��������ʹ���������ʱ����ε������ж����е�ֵ����������������
 * @date 2017��10��23�� ����8:46:12
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
