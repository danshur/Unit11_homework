
public class SharedObject {
	private String name = null;

	public synchronized void sayHello() throws InterruptedException {
		while (name == null) {
			System.out.println("Waiting for new customer");
			Thread.sleep(100);
			wait();
		}
		System.out.println("Hello " + name);
		//notifyAll();
		name = null;
		
	}

	public synchronized void setName(String name) throws InterruptedException {
		this.name = name;
		notify();
		//wait();
	}
}
