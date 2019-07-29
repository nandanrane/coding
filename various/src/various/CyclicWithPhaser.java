package various;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class CyclicWithPhaser {

	public static void main(String[] args) {
		
		Phaser phaser = new Phaser(4);
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(int i = 1; i <= 13; i++ ) {
			service.submit(new PassengerThreadPhaser(1000, "p"+i, phaser));
		}
		
		
	}

}

class PassengerThreadPhaser implements Runnable {
	private int duration;
	private Phaser phaser;
	private String name;
	
	public PassengerThreadPhaser(int duration, String name, Phaser phaser) {
		this.name = name;
		this.duration = duration;
		this.phaser = phaser;
	}
	
	public void run() {
		System.out.println(this.name + " has started.");
		
		phaser.arriveAndAwaitAdvance();
		
		System.out.println(this.name + " continues.");
		
	}
}
