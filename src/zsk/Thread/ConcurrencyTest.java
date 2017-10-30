package zsk.Thread;

/**
 * @author hasee
 * 描述：并发并非比串行快的实例,当数据操作低于10W行时，两种方式速度差不多。
 * @date 2017年10月25日 下午4:01:24
 * ConcurrencyTest
 */
public class ConcurrencyTest {
	private static final long count = 900000;
	public static void main(String[] args)throws InterruptedException{
		concurrency();
		serial();
	}
	private static void concurrency()throws InterruptedException{
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run(){
				int a = 0;
				for(long i=0;i<count;i++){
					a += 5;
				}
			}
		});
		thread.start();
		int b =0;
		for(long i=0;i<count;i++){
			b--;
		}
		long time = System.currentTimeMillis() - start;
		thread.join();
		System.out.println("concurrency:"+time+"ms,b="+b);
	}
	private static void serial(){
		long start = System.currentTimeMillis();
		int a = 0;
		for(long i =0;i<count;i++){
			a +=5;
		}
		int b = 0;
		for(long i = 0;i<count;i++){
			b--;
		}
		long time =System.currentTimeMillis() -start;
		System.out.println("concurrency:"+time+"ms,b="+b+",a="+a);
	}
}
