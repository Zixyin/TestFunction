package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestToArray {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("1 2 3 A B C".split(" ")));
		System.out.println(list);
		Object[] array = list.toArray();
		System.out.println(Arrays.toString(array));
		String[] array2 = new String[list.size()];
		list.toArray(array2);
		System.out.println(array2);
		System.out.println(Arrays.toString(array2));
		String[] array3 = list.toArray(new String[list.size()]);
	}
}
