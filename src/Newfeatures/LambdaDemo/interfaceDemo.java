package Newfeatures.LambdaDemo;

//�����������Է���ӿڵĵ��ã���������һ��Ϊ�˽����Ϊ�����Ӵ������ӿ����������һ�ַ�����ֱ�ӿ����в�����ʹ�á�
interface IDemo {
	public default void say() {// ����Ĭ�Ϸ���
		System.out.println("say");
	}

	public static IDemo getINstance() { // ���徲̬����
		return new IdemoImpl();
	}

	public void cry();
}

class IdemoImpl implements IDemo {
	@Override
	public void cry() {
		System.out.println("small");
	}
}

public class interfaceDemo {
	public static void main(String[] args) {
		// IDemo i = new IdemoImpl();
		IDemo i = IDemo.getINstance();// ����static�����ܹ�ֱ�ӵ��á�
		i.cry();
		i.say();
	}

}
