package zsk.Thread;

public class RunnableDemo {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world");
			}
		}).start(); // �����ڲ���ʵ��run����
		new Thread(() -> System.out.print("hello world")).start();// lambda���ʽʵ��run������
	}
}
