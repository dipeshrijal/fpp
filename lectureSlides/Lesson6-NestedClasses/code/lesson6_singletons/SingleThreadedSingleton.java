 package lesson6_singletons;

/**
 * Not a thread-safe implementation.
 * Lazy initialization
 */
public class SingleThreadedSingleton {
	public static int count = 0;
	private static SingleThreadedSingleton instance;
	private SingleThreadedSingleton() {
		count++;
	}
	
	public static SingleThreadedSingleton getInstance() {
		if(instance == null) {
			instance = new SingleThreadedSingleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		SingleThreadedSingleton singleton = 
			SingleThreadedSingleton.getInstance();
	}

}
