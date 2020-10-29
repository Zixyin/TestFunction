import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Stream<String> listStream = list.stream();
		Stream<String> parallelStream = list.parallelStream();
		Integer[] array = new Integer[10];
		Stream<Integer> arrayStream = Arrays.stream(array);
		Stream<Integer> ofStream = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> iterateStream = Stream.iterate(2, (x)->new Double(Math.pow(x, 2)).intValue()).limit(6);
		Stream<Double> limitStream = Stream.generate(Math::random).limit(6);
//		ofStream.forEach(System.out::println);
//		iterateStream.forEach(System.out::println);
//		limitStream.forEach(System.out::println);
		try {
			FileInputStream in= new FileInputStream("C:\\Users\\yinzixian\\Desktop\\R-B Tree.txt");
			InputStreamReader inReader;
			inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader reader = new BufferedReader(inReader);
			Stream<String> readerStream = reader.lines();
//			readerStream.forEach(System.out::println);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pattern pattern = Pattern.compile(", ");
		Stream<String> splitAsStream = pattern.splitAsStream("a, b, c, d");
//		splitAsStream.forEach(System.out::println);
		String[] words = new String[] {"Hello","World"};
	//map
//		Arrays.asList(words).stream()
//			.map(word -> word.split(""))
//			.distinct()
//			.collect(Collectors.toList())
//			.forEach(System.out::println);
	//分步
		List<String> asList = Arrays.asList(words);
		Stream<String> stream = asList.stream();
		Stream<String[]> mapStream = stream.map(word -> word.split(""));
//		List<String[]> collect = mapStream.collect(Collectors.toList());
//		for(String[] s: collect)
//			System.out.println(Arrays.toString(s));
		Stream<Stream<String>> mapSStream = mapStream.map(s -> Arrays.stream(s));
		List<Stream<String>> collect = mapSStream.collect(Collectors.toList());
	//flatMap
//		Arrays.asList(words).stream()
//			.flatMap(word -> Arrays.stream(word.split("")))
//			.distinct()
//			.collect(Collectors.toList())
//			.forEach(System.out::println);
	//分步

		Stream<String> flatMap = Arrays.asList(words).stream().flatMap(word -> Arrays.stream(word.split("")));
		Stream<String> stream2 = flatMap.distinct();
		List<String> collect2 = stream2.collect(Collectors.toList());
		
	}
}
