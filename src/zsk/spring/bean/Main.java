package zsk.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		//一般的调用是一下三步。
//		HelloWorld helloworld = new HelloWorld();
//		helloworld.setName("zsk");
//		helloworld.Hello();
		//而使用spring的IOC注入则不同。
		ApplicationContext atc = new ClassPathXmlApplicationContext("bean.xml");
		//这里使用bean注入了属性到HelloWorld对象中，所以调用的Hello的属性就发生了变化。
		//需要注意的时，这种注入方式需要类需要无参构造器，不然会出现no default constructor异常。
		HelloWorld helloWorld =(HelloWorld) atc.getBean("helloWorld");
		
		helloWorld.Hello();
	}
}
