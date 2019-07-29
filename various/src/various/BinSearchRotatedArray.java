package various;

public class BinSearchRotatedArray {
	
	// search in sorted ascending array which is rotated 

	public static int searchRotatedArray(int[] arr, int n) {
		 
		return helper(arr, 0, arr.length-1, n);
	}
	
	private static int helper(int[] arr, int low, int high, int n) {
		int mid = low + (( high -low)/2);
		
		if(n == arr[mid]) return arr[mid];
		
		// find out if 2nd half is sorted
		if(arr[mid] <= arr[high]) {
			if(n > arr[mid] && n <= arr[high]) {
				System.out.println("2nd half sorted - change low to " + (mid+1));
				low = mid+1;
			} else {
				System.out.println("2nd half sorted - change high to " + (mid-1));
				high = mid -1;
			}
		} else { // 1st half is sorted i.e. if arr[mid] >= arr[low]
			if(n >= arr[low] && n < arr[mid]) {
				System.out.println("1st half - change high to " + (mid-1));
				high = mid -1;
			} else {
				System.out.println("1st half - change low to " + (mid+1));
				low = mid + 1;
			}
		}
		
		return helper(arr, low, high, n);
		
	}
	public static void main(String[] args) {
		System.out.println(searchRotatedArray(new int[] {8, 9, 12, 14, 1, 2, 3, 4, 5,  6,  7}, 1));
	}

}
