package various;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " has started ");
		
		CyclicBarrier barrier = new CyclicBarrier(4);
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		for(int i=1; i<= 8; i++) {
			service.submit(new PassengerThread(1000, "p"+i, barrier));
		}
		
		service.shutdown();
		
		try {
			service.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		Thread p1 = new Thread(new PassengerThread(1000, "p1", barrier));
		Thread p2 = new Thread(new PassengerThread(2000, "p2", barrier));
		Thread p3 = new Thread(new PassengerThread(3000, "p3", barrier));
		Thread p4 = new Thread(new PassengerThread(4000, "p4", barrier));

		Thread p5 = new Thread(new PassengerThread(1000, "p5", barrier));
		Thread p6 = new Thread(new PassengerThread(3000, "p6", barrier));
		Thread p7 = new Thread(new PassengerThread(5000, "p7", barrier));
		Thread p8 = new Thread(new PassengerThread(7000, "p8", barrier));
		
		p1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p3.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p4.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p5.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p6.start();
		p7.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p8.start();
*/
			
		System.out.println(Thread.currentThread().getName() + " has finished ");
	}

}

class PassengerThread implements Runnable {
	private int sleepDuration;
	private String name;
	private CyclicBarrier barrier;
	
	public PassengerThread(int duration, String name, CyclicBarrier barrier) {
		this.sleepDuration = duration;
		this.name = name;
		this.barrier = barrier;
	}
	
	public void run() {
		System.out.println("Passenger " + name + " has arrived ");
		
		try {
			Thread.sleep(sleepDuration);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println("Executing " + this.name + " since all parties arrived");
	}
	
}
