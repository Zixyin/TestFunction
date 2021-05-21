package test;

public class TestExtendPrivateFields {
	public static void main(String[] args) {
		SubClass sub = new SubClass();
		sub.setId(1);
		sub.setName("рСвсом");
		System.out.println(sub.getId() + sub.getName());
	}
}

class SuperClass {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
class SubClass extends SuperClass{
	private String subName;

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}
	
}