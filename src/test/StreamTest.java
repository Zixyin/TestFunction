package test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
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
		
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> reduce = list2.stream().reduce((x, y) -> x + y);
		Integer integer = reduce.get();
//		System.out.println(integer);
		Integer reduce2 = list2.stream().reduce(10, (x, y) -> x + y);
//		System.out.println(reduce2);
		Integer reduce3 = list2.stream().reduce(0, (x, y) -> {
//			System.out.println(x - y);
			return x - y;
		}, (x, y) -> {
//			System.out.println(x * y);
			return x * y;
		});
//		System.out.println(reduce3);
	//经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
	//第二个方法是每个元素分别跟第一个值做操作
	//第三个方法是第二个方法的值之间做操作
		Integer reduce4 = list2.parallelStream().reduce(0, (x, y) -> {
//			System.out.println("parallelStream accumulator: " + (x + y));
			return x + y;
		}, (x, y) -> {
//			System.out.println("parallelStream combiner: " + (x * y));
			return x * y;
		});
//		System.out.println(reduce4);
		class Student{
			int id;
			int age;
			String name;
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getId() {
				return id;
			}
			public Student(String name, int age, int id) {
				this.name = name;
				this.age = age;
				this.id = id;
			}
		}
		Student s1 = new Student("aa", 10, 1);
		Student s2 = new Student("bb", 20, 2);
		Student s3 = new Student("cc", 10, 3);
		List<Student> list3 = Arrays.asList(s1, s2, s3);
		 
		//转成list

		Stream<Integer> streamToList = list3.stream().map(Student::getAge);
		List<Integer> ageList = streamToList.collect(Collectors.toList()); // [10, 20, 10]
//		 System.out.println(ageList);
		//转成set
		Stream<Integer> streamToSet = list3.stream().map(Student::getAge);
		Set<Integer> ageSet = streamToSet.collect(Collectors.toSet()); // [20, 10]
//		System.out.println(ageSet);
		//转成map,注:key不能相同，否则报错
		Map<String, Integer> studentMap = 
				list3.stream()
				.collect(Collectors.toMap(Student::getName, Student::getAge)); // {cc=10, bb=20, aa=10}
//		System.out.println(studentMap.toString());
		//字符串分隔符连接
		String joinName = list3.stream()
				.map(Student::getName).collect(Collectors.joining(",", "(", ")")); // (aa,bb,cc)
//		System.out.println(joinName);
	//聚合操作
		//1.学生总数
		Long count = list3.stream()
				.collect(Collectors.counting()); // 3
		//2.最大年龄 (最小的minBy同理)
		Integer maxAge = list3.stream()
				.map(Student::getAge)
				.collect(Collectors.maxBy(Integer::compare)).get(); // 20
		//3.所有人的年龄
		Integer sumAge = list3.stream()
				.collect(Collectors.summingInt(Student::getAge)); // 40
		//4.平均年龄
		Double averageAge = list3.stream()
				.collect(Collectors.averagingDouble(Student::getAge)); // 13.333333333333334
		// 带上以上所有方法
		DoubleSummaryStatistics statistics = list3.stream()
				.collect(Collectors.summarizingDouble(Student::getAge));
//		System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());
		//分组
		Map<Integer, List<Student>> ageMap = list3.stream()
				.collect(Collectors.groupingBy(Student::getAge));
		//多重分组,先根据类型分再根据年龄分
		Map<Integer, Map<Integer, List<Student>>> typeAgeMap = list3.stream()
				.collect(Collectors.groupingBy(Student::getId, Collectors.groupingBy(Student::getAge)));
		 
		//分区
		//分成两部分，一部分大于10岁，一部分小于等于10岁
		Map<Boolean, List<Student>> partMap = list3.stream()
				.collect(Collectors.partitioningBy(v -> v.getAge() > 10));
		 
		//规约
		Integer allAge = list3.stream().map(Student::getAge)
				.collect(Collectors.reducing(Integer::sum)).get(); //40
		
		
	}
}