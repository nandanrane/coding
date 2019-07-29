package various;

public class FindPivotSortedArray {
	
	// find pivot of sorted ascending rotated array
	public static int findPivot(int[] arr) {
		int low = 0;
		int hi = arr.length -1;
		int mid = 0;
		int next = 0;
		//int count = 0;
		while(low <= hi) {
			//System.out.println("count " + ++count);
			if(arr[low] <= arr[hi]) { // array is sorted and not rotated lowest will be pivot
				return arr[low];
			}
			
			mid = low + ((hi - low)/2);
			next = (mid +1) % arr.length;
			
			System.out.println("mid " + mid + ", next " + next);
			
			// if element at mid is greater than it's next element. 
			// that next element is minimum and is the pivot
			if(arr[mid] > arr[next]) {
				return next;
			}
			
			// find if end half is sorted array, then pivot won't exist in 2nd half
			if(arr[mid] <= arr[hi]) {
				hi = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {8, 9, 12, 14, 1, 2, 3, 4, 5, 6, 7};
		
		System.out.println(findPivot(arr));

		arr = new int[] {15, 1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 14};
		
		System.out.println(findPivot(arr));

		arr = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 12, 14, 15, 1};
		
		System.out.println(findPivot(arr));
	}

}
