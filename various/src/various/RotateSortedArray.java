package various;

public class RotateSortedArray {
	
	// Time O(N*d) Space O(1)
	public static int[] rotateBrutForce(int[] arr, int d) {
		int len = arr.length;
		for(int j = 0; j < d; j++) {
			int temp = arr[len-1];
			for(int i= len-1; i > 0; i--) {
				arr[i] = arr[i-1];
			}
			arr[0] = temp;
		}
		
		return arr;
	}
	
	// Time O(N) Space O(N)
	public static int[] rotateExtraSpace(int[] arr, int d) {
		int[] b = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			b[(i+d)%arr.length] = arr[i];
		}
		
		return b;
	}
	// Time O(N) Space O(1)
	public static int[] rotate(int[] arr, int d) {
		
		reverse(arr, 0, arr.length-1);
		
		reverse(arr, 0, d-1);
		
		reverse(arr, d, arr.length-1);
		
		return arr;
		
	}
	
	private static void reverse(int[] arr, int st, int end) {
		
		while(st < end) {
			int temp = arr[st];
			arr[st] = arr[end];
			arr[end] = temp;
			
			st++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5,  6,  7, 8, 9, 12, 14};
		
		arr = rotateBrutForce(arr, 4);
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		arr = new int[] {1, 2, 3, 4, 5,  6,  7, 8, 9, 12, 14};
		
		arr = rotateExtraSpace(arr, 4);
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
		System.out.println();
		arr = new int[] {1, 2, 3, 4, 5,  6,  7, 8, 9, 12, 14};
		
		arr = rotate(arr, 4);
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
	}

}
