package various;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class TestPriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2.compareTo(i1);
			}
		});
		
		Random random = new Random();
		
		for(int i=0; i < 25; i++) {
			int num = random.nextInt(30); 
			pq.add(num);
			System.out.print(num + " ");
		}
		System.out.println();
		while(!pq.isEmpty()) {
			int num = pq.poll();
			
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
