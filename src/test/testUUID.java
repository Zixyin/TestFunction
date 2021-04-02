package test;

import java.util.UUID;

public class testUUID {
	public static void main(String[] args) {
		UUID 
			id1 = UUID.randomUUID(),
			id2 = UUID.randomUUID();
		System.out.println(id1);
		System.out.println(id2);
//		System.out.println(id1.clockSequence());
//		System.out.println(id2.clockSequence());
		System.out.println(id1.compareTo(id2));
		
		
		
	}
}
