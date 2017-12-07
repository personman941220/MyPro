package Newfeatures.StreamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import static java.util.stream.Collectors.toList;

public class StreamDemo {
	List<Dish> menu = Arrays.asList(new Dish("pook", false, 800, Dish.TYPE.MEAT),
			new Dish("beef", false, 700, Dish.TYPE.MEAT), new Dish("chicken", false, 400, Dish.TYPE.MEAT),
			new Dish("french fries", true, 530, Dish.TYPE.OTHER), new Dish("rice", true, 350, Dish.TYPE.OTHER),
			new Dish("season", true, 120, Dish.TYPE.OTHER), new Dish("pizza", true, 550, Dish.TYPE.OTHER),
			new Dish("prawns", false, 300, Dish.TYPE.FISH), new Dish("salmon", false, 450, Dish.TYPE.FISH));

	@Test
	public void test1() {
		List<String> threeHighCaloricDishNames = menu.stream()
				.filter(d -> d.getCalories() > 300)// 找到卡路里大于300的对象
				.map(Dish::getName)// 将符合上面条件的对象的名称获得
				.limit(3)// 限制只选择最前面的三个
				.collect(toList());// 将结果返回给集合。
		System.out.println(threeHighCaloricDishNames);
	}
	@Test
	public void test2(){
		/*
		 * java.lang.IllegalStateException: stream has already been operated upon or closed
		 * 流属于遍历操作，即使用一次后就会被销毁，重复的使用将导致报错。
		 */
		List<String> title = Arrays.asList("java8","In","Action");
		Stream<String> s = title.stream();
		s.forEach(System.out::println);
		s.forEach(System.out::println);
	}
	@Test
	public void test3(){
		List<String> names = 
				menu.stream()
					.filter(d -> {
						System.out.println("filtering"+d.getName());
						return d.getCalories() >300;
					})
					.map(d -> {
							System.out.println("mapping"+d.getName());
							return d.getName();
					})
					.limit(3)
					.collect(toList());
		System.out.println(names);
	}
}
