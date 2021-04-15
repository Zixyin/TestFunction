package test.annotaitonTest;

public class UseCaseUtil {
	
	@UseCase(id = 1, description = "A")
	public void CaseA(String s) {
		System.out.println(s.equals("A"));
	}
	
	@UseCase(id = 2, description = "B")
	public void CaseB(String s) {
		System.out.println(s.equals("B"));
	}
}
