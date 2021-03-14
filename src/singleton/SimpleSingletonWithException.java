package singleton;

public class SimpleSingletonWithException {

	private SimpleSingletonWithException() throws Exception {
	}

	/**
	 * private final static SimpleSingletonWithException INSTANCE = new
	 * SimpleSingletonWithException();
	 **/ // wrong can't be done must use static block.

	private static SimpleSingletonWithException instance;
	// this is thread safe.
	// only one instance at any given time.
	// not immune against serialization.

	static {
		try {
			instance = new SimpleSingletonWithException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SimpleSingletonWithException getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		Thread r1 = new Thread(() -> {
			SimpleSingletonWithException simpleSingletonWithException = SimpleSingletonWithException.getInstance();
			System.out.println(simpleSingletonWithException);
		});
		r1.run();

		Thread r2 = new Thread(() -> {
			SimpleSingletonWithException simpleSingletonWithException = SimpleSingletonWithException.getInstance();
			System.out.println(simpleSingletonWithException);
		});
		r2.run();
	}

}
