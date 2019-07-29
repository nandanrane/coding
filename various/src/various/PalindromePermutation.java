package various;

public class PalindromePermutation {
	
	// is given string permutation of a palindrome e.g. add is permutation of dad so true

	public static boolean isPalindromePermtation(String s) {
		
		if(s == null || s.length() < 2) {
			return true;
		}
		
		boolean[] arr = new boolean[256];
		for(char c : s.toCharArray()) {
			arr[c] = !arr[c];
		}
		int count = 0;
		for(boolean b : arr) {
			if(b) {
				count++;
				if(count > 1) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		System.out.println(isPalindromePermtation("add"));
		System.out.println(isPalindromePermtation("bba"));
		System.out.println(isPalindromePermtation("cdf"));
		System.out.println(isPalindromePermtation("aaa"));
		System.out.println(isPalindromePermtation("aaabbbaa"));
				
	}

}
