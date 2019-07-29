package various;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static List<String> permutationsOfString(String s) {
		List<String> results = new ArrayList<>();
		String current = "";
		boolean[] used = new boolean[s.trim().length()];
		
		permStringHelper(s, used, current, results);

		return results;
	}
	
	
	
	private static void permStringHelper(String s, boolean[] used, String current, List<String> results) {
		if(current.length() == s.length()) {
			results.add(current);
			return;
		}
		
		for(int i=0; i < s.length(); i++) {
			if(used[i]) {
				continue;
			}
			used[i] = true;
			permStringHelper(s, used, current + s.charAt(i), results);
			used[i] = false;
		}
		
	}



	public static List<List<Integer>> permutations(int[] arr) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		boolean[] used = new boolean[arr.length];
		
		permHelper(arr, used, current, results);

		return results;
	}
	
	public static void permHelper(int[] arr, boolean[] used, List<Integer> current, List<List<Integer>> results) {
		System.out.println("used " + String.valueOf(used));
		System.out.println("current " + String.valueOf(current));
		System.out.println("results " + String.valueOf(results));
		
		if(current.size() == arr.length) {
			System.out.println("adding current to results");
			results.add(new ArrayList<Integer>(current));
			return;
		}
		
		for(int i=0; i < arr.length; i++) {
			if(used[i]) continue;
			used[i] = true;
			current.add(arr[i]);
			permHelper(arr, used, current, results);
			current.remove(current.size() -1);
			used[i] = false;
		}
		
	}
	
	public static void printListOfList(List<List<Integer>> results) {
		
		System.out.println(String.valueOf(results));
			
	}

	public static void main(String[] args) {
		printListOfList(permutations(new int[]{1,2,3}));
		
		//System.out.println(String.valueOf(permutationsOfString("abc")));
	}

}
