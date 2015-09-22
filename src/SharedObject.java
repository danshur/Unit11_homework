
public class SharedObject {
	private String name = null;
	//private Boolean keeprunning=true;
	
	public synchronized void sayHello() throws InterruptedException {
		
		while (name == null) {
			System.out.println("Waiting for new customer");
			Thread.sleep(100);
			wait();
		}
		
		
			System.out.println("Hello " + name);
		name = null;
		wait();
		
		//notifyAll();
		//wait();
	}

	public synchronized void setName(String name) throws InterruptedException {
		this.name = name;
		notify();
		System.out.println("Just set the name to " + name + " and notified the thread.");
		//wait();
	}
}
