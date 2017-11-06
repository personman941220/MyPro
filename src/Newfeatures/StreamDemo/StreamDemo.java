package Newfeatures.StreamDemo;

import java.util.Arrays;
import java.util.List;

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
}
