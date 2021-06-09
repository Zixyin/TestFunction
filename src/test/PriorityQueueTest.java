package test;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		Queue<Data> priorityQueue = 
				new PriorityQueue<Data>((d1,d2) -> d1.getId() - d2.getId());
	}
}

class Data {
	private int id;
	private String name;
	private Date birth;
	
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data(int id, String name, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
	}
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}