package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ImmuneSingleton implements Serializable {

	// this is thread-safe.
	// immune against serialization.

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private ImmuneSingleton() throws Exception {
	}

	private static ImmuneSingleton immuneSingleton;

	static {
		try {
			immuneSingleton = new ImmuneSingleton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ImmuneSingleton getInstance() {
		return immuneSingleton;
	}

	// This override the behavior of serialization
	private Object readResolve() {
		return ImmuneSingleton.getInstance();
	}

	public static void saveToAFile(String filename, ImmuneSingleton immuneSingleton)
			throws FileNotFoundException, IOException {
		try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(immuneSingleton);
		}

	}

	public static ImmuneSingleton ReadFromAFile(String filename)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		try (FileInputStream fileOutputStream = new FileInputStream(filename);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream)) {
			return (ImmuneSingleton) objectInputStream.readObject();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ImmuneSingleton immuneSingleton = ImmuneSingleton.getInstance();
		ImmuneSingleton.saveToAFile("blo", immuneSingleton);
		ImmuneSingleton immuneSingleton2 = ImmuneSingleton.ReadFromAFile("blo");
		System.out.println(immuneSingleton);
		System.out.println(immuneSingleton2);
		System.out.println(immuneSingleton == immuneSingleton2); //the same object.
	}

}
