package test;

import static java.util.Comparator.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class MapSortedTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("D", 4);
		map.put("C", 3);
		map.put("E", 5);
		map.put("H", 8);
		map.put("F", 6);
		map.put("G", 7);
		List<String> list = map.keySet()
				.stream()
				.sorted(comparing(map::get).reversed())
				.limit(3)
				.collect(toList());
		System.out.println(list);
	}
}

