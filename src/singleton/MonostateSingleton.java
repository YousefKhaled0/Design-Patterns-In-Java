package singleton;

public class MonostateSingleton {
	private static String data = "Some data!"; 
	// this stays the same for all instance

	public String getData() {
		return data;
	}

	public void setData(String data) {
		MonostateSingleton.data = data;
	}
}
