package various;

public class SAPDistanceWithCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = distanceFromCharacter("Nandann", 'a');
		
		for(int num : a) {
			System.out.print(num + " ");
		}
	}
	
	public static int[] distanceFromCharacter(String s, char c) {
		if(s == null || s.length() == 0 || c == ' ') {
			return new int[] {};
		}
		
		int[] result = new int[s.length()];
		
		for(int i = 0; i < s.length(); i++) {
			int min = Integer.MAX_VALUE;
			
			if(c == s.charAt(i)) {
				result[i] = 0;
				continue;
			}
			boolean foundMin = false;
			for(int j=0; !foundMin && j< s.length(); j++) {
				if(i != j && c == s.charAt(j)) {
					min = Math.min(min, Math.abs(j-i));
				
					if(i < j) {
						foundMin = true;
					}
				}
				
			}
			result[i] = min;
		}
		
		return result;
	}

}
