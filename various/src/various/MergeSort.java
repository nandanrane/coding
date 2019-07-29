package various;

import java.util.Random;

public class MergeSort {
	
	public static int[] mergeSort(int[] nums) {
		
		if(nums == null || nums.length <= 1) return nums;
		
		int[] left = new int[nums.length /2];
		int[] right = new int[nums.length - (nums.length/2)];
		int i = 0;
		for(; i < nums.length/2; i++) {
			left[i] = nums[i];
		}
		int offset = nums.length/2;
		for(; i < nums.length; i++) {
			right[i - offset] = nums[i];
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}
	
	private static int[] merge(int[] num1, int[] num2) {
		int[] result = new int[num1.length + num2.length];
		int i = 0;
		int j= 0;
		int k = 0;
		while( i < num1.length && j < num2.length) {
			if(num1[i] < num2[j]) {
				result[k] = num1[i];
				i++;
			} else {
				result[k] = num2[j];
				j++;
			}
			k++;
		}
		
		while(i < num1.length) {
			result[k++] = num1[i++];
		}
		
		while(j < num2.length) {
			result[k++] = num2[j++];
		}
		
		return result;
	}

	public static void main(String[] args) {

		int[] nums = mergeSort(new int[] {6, 2, 9, 10, 45, 32, 1, 7, 22});
		
		for(int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		nums = mergeSort(new int[] {1});

		for(int num : nums) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		nums = mergeSort(new int[] {});

		for(int num : nums) {
			System.out.print(num + " ");
		}

		System.out.println();
		nums = new int[10000];
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			nums[i] = random.nextInt(10000);
		}
		nums = mergeSort(nums);

		System.out.println("now printing large array " + nums.length);
		
		for(int num : nums) {
			System.out.println(num + " ");
		}

		System.out.println("done printing");
	}

}
