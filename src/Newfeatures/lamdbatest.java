package Newfeatures;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author hasee
 * ������Lamdbtest����ѧϰ��Ϊ������
 * @date 2017��10��19�� ����11:30:28
 * lamdbatest
 */
public class lamdbatest {
		public static void prettyPrintApple(List<Apple> inventory,AppleFormatter af){
			for(Apple apple:inventory){
				String output = af.accept(apple);
				System.out.println(output);
			}
		}
	public static void main(String[] args){
		lamdbatest l = new lamdbatest();
		List<Apple> inventory= new ArrayList();
		Apple a = new Apple();
		a.setColor("red");
		a.setKg(20);
		inventory.add(a);
		l.prettyPrintApple(inventory, new AppleFancyFormatter());
		
	}
	
}
