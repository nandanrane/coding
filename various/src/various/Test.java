package various;

import java.util.Iterator;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		LinkedList<String> mylinkedlist = new LinkedList<String>();
		mylinkedlist.addFirst("one");
		mylinkedlist.add("two");
		Iterator<String> iter = mylinkedlist.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		LinkedList<ListNode> newLL = new LinkedList<>();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		
		newLL.add(n1);
		newLL.addFirst(n2);
		
		Iterator<ListNode> iter1 = newLL.iterator();
		while (iter1.hasNext()) {
			ListNode ln = iter1.next();
			System.out.println(ln.val + " " + ln.next);
		}
		
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread started once .");
			}
		});
		t1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
