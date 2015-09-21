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
			//obj.setRea
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SharedObject obj = new SharedObject();
		Solution s = new Solution(obj);
		Thread t1 = new Thread(s);
		//Thread t2 = new Thread(s);
		t1.start();
		//t2.start();
		Thread.sleep(100);
		//obj.setReady();
		String[] names = { "Tobias", "John", "Kate" };
		for (String name : names) {
			obj.setName(name);
			
		}
	}
}
