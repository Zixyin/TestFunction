package test;

import java.util.Random;

/**
 * 
 * @author yinzixian
 *
 */
public class TestNestEnum {
	public static void main(String[] args) {
		int count = 5;
		while(count -- > 0) {
			for(Word word : Word.values()) {
				System.out.print(word.randomSelection());
			}
			System.out.println();
		}
	}
}

enum Word {
	FIRST(Letter.ALetter.class),
	SECOND(Letter.BLetter.class),
	THIRD(Letter.CLetter.class);
	private Letter[] values;
	private Word(Class<? extends Letter> clazz) {
		values = clazz.getEnumConstants();
	}
	
	interface Letter {
		enum ALetter implements Letter {
			A, a;
		};
		enum BLetter implements Letter {
			B, b;
		};
		enum CLetter implements Letter {
			C, c;
		};
	}
	Letter randomSelection() {
		return values[new Random().nextInt(values.length)];
	}
}