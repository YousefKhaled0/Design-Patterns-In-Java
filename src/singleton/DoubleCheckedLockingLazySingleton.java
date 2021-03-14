package singleton;

public class DoubleCheckedLockingLazySingleton {

	// Instead of using synchronization on the whole get-getInstance function
	// we use double checking locking which is more efficient.
	// this is thread-safe.

	private DoubleCheckedLockingLazySingleton() throws Exception {
	}

	private static volatile DoubleCheckedLockingLazySingleton instance;

	public static DoubleCheckedLockingLazySingleton getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					try {
						instance = new DoubleCheckedLockingLazySingleton();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		return instance;
	}

}
