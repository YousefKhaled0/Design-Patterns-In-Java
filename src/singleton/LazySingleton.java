package singleton;

public class LazySingleton {

	// this is not thread-safe.
	private LazySingleton() throws Exception {
	}

	private static LazySingleton lazySingleton;

	public static LazySingleton getInstance() throws Exception {
		if (lazySingleton == null)
			lazySingleton = new LazySingleton();
		return lazySingleton;
	}

	public static void main(String[] args) throws Exception {
		LazySingleton l = LazySingleton.getInstance();
		LazySingleton l2 = LazySingleton.getInstance();
		System.out.println(l == l2);
	}

}
