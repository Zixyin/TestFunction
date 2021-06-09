package test;
public class DecodeTest {
	public static void main(String[] args) {
		String o = "016", 
		d = "16", 
		h1 = "0x16",h2 = "0X16";
		System.out.println(Integer.decode(o));
		System.out.println(Integer.decode(d));
		System.out.println(Integer.decode(h1));
		System.out.println(Integer.decode(h2));

	}
}
class F{
	
}
class S extends F{
	
}