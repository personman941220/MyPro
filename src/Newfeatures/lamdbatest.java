package Newfeatures;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author hasee
 * 描述：Lamdbtest用来学习行为参数化
 * @date 2017年10月19日 上午11:30:28
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
