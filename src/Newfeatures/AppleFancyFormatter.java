package Newfeatures;

/**
 * @author hasee
 * ������ʵ��
 * @date 2017��10��19�� ����11:44:15
 * AppleFancyFormatter
 */
public class AppleFancyFormatter implements AppleFormatter {
	public String accept(Apple apple){
		return "An apple of" + apple.getKg() + "g";
	}
}
