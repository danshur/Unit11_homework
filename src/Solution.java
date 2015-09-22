/*
 * THis program loops through waiting for names
 * Needs to wait for input first
 */
public class Solution implements Runnable {
	private SharedObject obj;

	public Solution(SharedObject obj) {
		this.obj = obj;
	}

	public void run() {
		try {
			obj.sayHello();
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SharedObject obj = new SharedObject();
		Solution s = new Solution(obj);
		Thread t1 = new Thread(s);
		t1.setName("thread1");
		t1.start();
		
		Thread.sleep(100);
		String[] names = { "Tobias", "John", "Kate" };
		for (String name : names) {
			System.out.println("Solution says: about to set name to " + name);
			
			obj.setName(name);
			System.out.println("Solution says: thread named " +t1.getName() + " is alive = " + t1.isAlive() );
			// notify();
		}
	}
}
