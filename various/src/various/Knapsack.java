package various;

public class Knapsack {
	
	public static int knapSack(int[] weights, int[] values, int maxWt) {
		
		int[][] mat = new int[values.length+1][maxWt+1];//initialize a matrix with 1 more than the lengths of weights and items
		
		/*    wt limit ->           0    1    2   3   4    5  
		 *     0                    0    0    0   0   0    0  
		 *    item1(wt=2, val = 2)  0    0    2   2   2    2 
		 *    item2(wt=3, val = 4)  0    0    2   4   4    6
		 *    item3(wt=4, val = 7)  0    0    2   4   7    7
		 * 
		 */
		
		for(int item = 0; item < mat.length; item++) {
			for(int weight = 0; weight <= maxWt; weight++) {
				
				if(item == 0 || weight == 0) {
					mat[item][weight] = 0;
					continue;
				}
				
				if(weight < weights[item-1]) { // item weight is more than max allowed weight, cannot consider current item
					// so take previous items value for same weight limit
					mat[item][weight] = mat[item-1][weight]; 
				} else {
					// if item can be considered, 2 choices : max of (value with item considered, value without the item)
					mat[item][weight] = Math.max(mat[item-1][weight], (values[item-1] + mat[item-1][weight - weights[item-1]]));
				}
			}
		}
		
		
		return mat[values.length][maxWt];
	}
	
	public static void main(String[] args) {
		
		int[] weights = new int[] {2,3,4};
		int[] values = new int[] {2,4,7};

		System.out.println(knapSack(weights, values, 5));
	}
}
