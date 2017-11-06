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
				.filter(d -> d.getCalories() > 300)// �ҵ���·�����300�Ķ���
				.map(Dish::getName)// ���������������Ķ�������ƻ��
				.limit(3)// ����ֻѡ����ǰ�������
				.collect(toList());// ��������ظ����ϡ�
		System.out.println(threeHighCaloricDishNames);
	}
}
