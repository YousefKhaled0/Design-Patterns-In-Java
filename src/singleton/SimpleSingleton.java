package singleton;

public class SimpleSingleton {

	// This is thread safe but has some problems. if the object construction
	// throws exceptions. not immune against serialization.

	private int value = 10;

	private SimpleSingleton() {
	}

	private final static SimpleSingleton INSTANCE = new SimpleSingleton();

	public static SimpleSingleton getInstance() {
		return INSTANCE;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SimpleSingleton [value=" + value + "]";
	}
	
	public static void main(String[] args) {
		SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
		SimpleSingleton simpleSingleton2 = SimpleSingleton.getInstance();
		System.out.println(simpleSingleton);
		simpleSingleton.setValue(22);
		System.out.println(simpleSingleton2);
	}
}