package various;

import java.util.HashSet;
import java.util.Set;

public class Celebrity {
	
	/* everyone knows celebrity, celebrity don't know anyone, no-one knows themselves
	   A  B  C
	A  f  f  t         
	B  t  f  t
	C  f  f  f
	
	here A knows C; and B knows C and C does not know any one. So C is the celebrity 
	*/
	public static void identifyCelebrity(boolean[][] matrix) {
		int ROWS = matrix.length;
		int COLS = matrix[0].length;
		Set<Integer> setOfCelebs = new HashSet<>();
		for(int i = 0; i < ROWS; i++) {
			setOfCelebs.add(i);
		}
		for(int r = 0; r < ROWS && !setOfCelebs.isEmpty(); r++) {
			System.out.println("Row " + r);
			for(int c = 0; c < COLS && !setOfCelebs.isEmpty(); c++) {
				System.out.println("column " + c);
				if(r == c) {
					System.out.println("Row is same as column or " + c + " is not a celeb. so next column.");
					continue;
				}
				if(matrix[r][c]) {// person at row r knows person at column c, so person at row r is not celeb
					
					System.out.println(r + " knows " + c + ", so " + r + " is not a celebrity.");
					if(setOfCelebs.contains(r)) {
						setOfCelebs.remove(r);
					}
				} else { // person at row r doesn't know person at column c, so person at row c is not celeb
					System.out.println(r + " doesn't know " + c + ", so " + c + " is not a celebrity.");
					setOfCelebs.remove(c);
				}
			}
		}
		
		System.out.println(String.valueOf(setOfCelebs));
	}

	public static void main(String[] args) {
		boolean[][] matrix = new boolean[][] {{false, false, true}, {true, false, true}, {false, false, false}};
		identifyCelebrity(matrix);
		System.out.println("----------------------");
		matrix = new boolean[][] {{false, false, false}, {true, false, true}, {true, false, false}};
		identifyCelebrity(matrix);
		System.out.println("----------------------");
		
		matrix = new boolean[][] {{false, false, false, true, true, false, false}, 
		{true, false, true, true, false, false, false},
		{true, false, false, true, false, true, false},
		{true, true, false, false, false, false, false},
		{false, false, true, true, false, true, false},
		{false, true, false, true, false, false, false},
		{false, true, false, true, true, false, false}};
		identifyCelebrity(matrix);
		System.out.println("----------------------");
	}

}
