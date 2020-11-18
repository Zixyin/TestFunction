package test;

public class TestNewLine {
	public static void main(String[] args) {
		System.out.println("123\n456\n\n\n789\n".replaceAll("\\n+", "\r"));
//		System.out.println("123\n456".replace("\n", "\\r#"));
	}
}
