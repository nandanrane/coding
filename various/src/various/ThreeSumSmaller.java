package various;

import java.util.Arrays;

/*
 * Given an int[] find count of triplets, sum of which is lower than given target
 * {-2, 0, 1, 3} target = 2. Output 2. Explanation: because -2, 0, 1 add up to -1 < 2 and -2, 0, 3 add up to 1 < 2
 * there are 2 triplets with sum less than 2.
 */

public class ThreeSumSmaller {
	
	public static void threeSumSmaller(int[] nums, int target) {
		
		System.out.println("bruteForce " + bruteForce(nums, target));
		System.out.println("efficient " + efficient(nums, target));
		
	}
	
	// time complexity O(n square) 
	private static int efficient(int[] nums, int target) {
		int result = 0;
		if(nums == null || nums.length < 3) {
			return result;
		}
		
		Arrays.sort(nums);

		int low = 0;
		int high = nums.length -1;
		int sum = 0;
		for(int i = 0; i < nums.length -2; i++) {
			low = i+1;
			high = nums.length -1;
			while(low < high) {
				sum = nums[i] + nums[low] + nums[high];
				if(sum > target) {
					high--;
				} else {
					result = high - low;
					break;
				}
			}
		}
		
		return result;
		
	}
	
	// time complexity O(n cube)
	private static int bruteForce(int[] nums, int target) {
		int result = 0;
		if(nums == null || nums.length < 3) {
			return result;
		}
		
		for(int i = 0; i < nums.length -2; i++) {
			for(int j = i+1; j < nums.length -1; j++) {
				for(int k = j+1; k < nums.length; k++) {
					if(nums[i] + nums[j] + nums[k] < target) {
						result++;
					}
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-2, 3, 1, 0};
		
		threeSumSmaller(nums, 2);

	}

}
