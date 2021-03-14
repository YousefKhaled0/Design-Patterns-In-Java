package singleton;

public class LazySingletonWithInnerStaticClass {

	private LazySingletonWithInnerStaticClass() throws Exception {
	}

	private static class Holder {
		private static LazySingletonWithInnerStaticClass instacne;
		static {
			try {
				instacne = new LazySingletonWithInnerStaticClass();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static LazySingletonWithInnerStaticClass getInstance() {
		return Holder.instacne;
	}

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				LazySingletonWithInnerStaticClass z = LazySingletonWithInnerStaticClass.getInstance();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				LazySingletonWithInnerStaticClass z = LazySingletonWithInnerStaticClass.getInstance();
			}
		});
		
		t.run();
		t2.run();
	}

}
