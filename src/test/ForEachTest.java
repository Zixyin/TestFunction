package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("A B C".split(" ")));
		for(String s : list) {
			if(s.equals("A"))
				list.remove(0);
		}
	}
}
