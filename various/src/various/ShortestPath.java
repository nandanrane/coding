package various;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
	
	public static void shortestPath(int[][] mat) {
		int ROWS = mat.length;
		int COLS = mat[0].length;
		boolean[][] visited = new boolean[ROWS][COLS];
		Queue<Node> q = new LinkedList<Node>();
		
		// 0 means the cell is off limits, 9 means destination
		for(int r = 0; r < ROWS; r++) {
			for(int c = 0; c < COLS; c++) {
				if(mat[r][c] == 0) {
					visited[r][c] = true;
				}
			}
		}
		q.add(new Node(0, 0, 1));
		visited[0][0] = true;
		int result = 0;
		
		while(!q.isEmpty()) {
			Node curr = q.remove();
			if(mat[curr.row][curr.col] == 9) {
				result = curr.distFromSrc;
				break;
			}
			
			// go right
			if(curr.col + 1 < COLS && !visited[curr.row][curr.col +1]) {
				q.add(new Node(curr.row, curr.col+1, curr.distFromSrc +1));
				visited[curr.row][curr.col+1] = true;;
			}
			
			// go left
			if(curr.col - 1 >= 0 && !visited[curr.row][curr.col -1]) {
				q.add(new Node(curr.row, curr.col-1, curr.distFromSrc +1));
				visited[curr.row][curr.col-1] = true;;
			}
			
			// go up
			if(curr.row - 1 >= 0 && !visited[curr.row -1][curr.col]) {
				q.add(new Node(curr.row-1, curr.col, curr.distFromSrc +1));
				visited[curr.row-1][curr.col] = true;;
			}
			
			// go down
			if(curr.row + 1 < ROWS && !visited[curr.row+1][curr.col]) {
				q.add(new Node(curr.row+1, curr.col, curr.distFromSrc +1));
				visited[curr.row+1][curr.col] = true;;
			}
		}
		System.out.println("shortest path is " + result);
	}
	

	public static void main(String[] args) {
		int[][] mat = new int[][] {{1, 1, 1},{1,9,0},{0, 0, 0}};
		shortestPath(mat);
		
		mat = new int[][] {{1, 1, 0, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 9, 1}};
		shortestPath(mat);
		
		mat = new int[][] {{1, 1, 0, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}, {1, 9, 1, 1}};
		shortestPath(mat);
		
	}

}

class Node {
	int row;
	int col;
	int distFromSrc;
	Node(int row, int col, int distFromSrc) {
		this.row = row;
		this.col = col;
		this.distFromSrc = distFromSrc;
	}
}
