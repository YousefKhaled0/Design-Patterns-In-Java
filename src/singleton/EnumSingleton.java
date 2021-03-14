package singleton;

public enum EnumSingleton {

	INSTANCE;

	private Integer value = 0;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	// Don't work well with serialization.
	
}
