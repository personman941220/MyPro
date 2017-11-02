package Newfeatures.LambdaDemo;

//这样操作可以方便接口的调用，但是这是一个为了解决因为子类庞大而解决接口扩充问题的一种方案。直接开发中不建议使用。
interface IDemo {
	public default void say() {// 定义默认方法
		System.out.println("say");
	}

	public static IDemo getINstance() { // 定义静态方法
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
		IDemo i = IDemo.getINstance();// 定义static方法能够直接调用。
		i.cry();
		i.say();
	}

}
