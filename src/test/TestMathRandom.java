package test;
import java.util.Random;

public class TestMathRandom {
	public static void main(String[] args) {
		Random rand = new Random(47);
		int i;
		while((i = rand.nextInt(20))!=10)
			System.out.println((int)(Math.random()*10000));
	}
}
