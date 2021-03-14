package singleton;

import java.util.HashMap;

enum Subsystem {
	Simple, Complicated
}

public class Multiton {
	// Not Thread-safe but we can use double check lock.
	private static HashMap<Subsystem, Multiton> instances = new HashMap<>();

	private Multiton() {

	}

	public static Multiton getInstance(Subsystem ss) {
		if (!instances.containsKey(ss))
			instances.put(ss, new Multiton());
		return instances.get(ss);
	}
}
