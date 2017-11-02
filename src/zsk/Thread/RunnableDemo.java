package zsk.Thread;

public class RunnableDemo {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world");
			}
		}).start(); // 匿名内部类实现run方法
		new Thread(() -> System.out.print("hello world")).start();// lambda表达式实现run方法。
	}
}
