package Newfeatures;

/**
 * @author hasee
 * 描述：实现
 * @date 2017年10月19日 上午11:44:15
 * AppleFancyFormatter
 */
public class AppleFancyFormatter implements AppleFormatter {
	public String accept(Apple apple){
		return "An apple of" + apple.getKg() + "g";
	}
}
