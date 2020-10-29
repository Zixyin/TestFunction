import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestLambda {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person());
	}
}

class Person implements Comparable<Person>{
	private int id;
	private String name;
	private LocalDate birthDay;
	public Person(){}
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Person o) {
		return id < o.id ? -1 : id == o.id ? 0 : 1;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthDay=" + birthDay + "]";
	}
	
}