package various;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class CountDownWithPhaser {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(4);
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		System.out.println(Thread.currentThread().getName() + " started");
		for(int i = 1; i <= 12; i++ ) {
			service.submit(new PassengerThreadPhaser(1000, "p"+i, phaser));
		}
		
		phaser.awaitAdvance(1);
		
		System.out.println(Thread.currentThread().getName() + "is finished");
		
	}

}

class CountDownThreads implements Runnable {
	
	Phaser phaser;
	String name;
	int duration;
	
	public CountDownThreads(int duration, String name, Phaser phaser) {
		this.name = name;
		this.duration = duration;
		this.phaser = phaser;
	}
	
	public void run() {
		System.out.println(this.name + " has started.");
		
		phaser.arrive();
		
		System.out.println(this.name + " continues its tasks.");
		
	}
}
