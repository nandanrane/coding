package various;
import java.util.Arrays;
import java.util.List;

public class TwoFacedCards {

	public static void main(String[] args) {
		
		
		List<TwoFacedCard> inputList = Arrays.asList(new TwoFacedCard[] {
			//new TwoFacedCard('s', 'b'),
			new TwoFacedCard('s', 'a'),
			//new TwoFacedCard('c', 'f'),
			new TwoFacedCard('m', 'd'),
			new TwoFacedCard('l', 'a'),
			new TwoFacedCard('g', 't'),
			new TwoFacedCard('i', 'f'),
			new TwoFacedCard('g', 'l'),
			new TwoFacedCard('r', 'e')
		});
		
		String word;
		word = "safe";
		System.out.println(word + isWordPossible(inputList, word));

		word = "mate";
		System.out.println(word + isWordPossible(inputList, word));
		word = "sam";
		System.out.println(word + isWordPossible(inputList, word));
		word = "gate";
		System.out.println(word + isWordPossible(inputList, word));
		word = "fair";
		System.out.println(word + isWordPossible(inputList, word));
		word = "fairs";
		System.out.println(word + isWordPossible(inputList, word));
	}
	
	public static boolean isWordPossible(List<TwoFacedCard> inputList, String word) {
		boolean[] used = new boolean[inputList.size()];
		return helper(inputList, word, 0, used);
	}
	
	private static boolean helper(List<TwoFacedCard> inputList, String word, int currIndex, boolean[] used) {
		if(currIndex >= word.length()) return true;
		
		int len = inputList.size();
		char c = word.charAt(currIndex);
		TwoFacedCard currCard;

		for(int i = 0; i < len; i++) {
			currCard = inputList.get(i);
			if(!used[i] && (c == currCard.c1 || c == currCard.c2)) {
				used[i] = true;
				
				if(helper(inputList, word, currIndex + 1, used)) {
					return true;
				}
				
				used[i] = false;
			}
		}
		
		return false;
		
	}
	
	

}

class TwoFacedCard {
	char c1;
	char c2;
	
	TwoFacedCard(char c1, char c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
}
