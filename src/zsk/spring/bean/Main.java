package zsk.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		//һ��ĵ�����һ��������
//		HelloWorld helloworld = new HelloWorld();
//		helloworld.setName("zsk");
//		helloworld.Hello();
		//��ʹ��spring��IOCע����ͬ��
		ApplicationContext atc = new ClassPathXmlApplicationContext("bean.xml");
		//����ʹ��beanע�������Ե�HelloWorld�����У����Ե��õ�Hello�����Ծͷ����˱仯��
		//��Ҫע���ʱ������ע�뷽ʽ��Ҫ����Ҫ�޲ι���������Ȼ�����no default constructor�쳣��
		HelloWorld helloWorld =(HelloWorld) atc.getBean("helloWorld");
		
		helloWorld.Hello();
	}
}
