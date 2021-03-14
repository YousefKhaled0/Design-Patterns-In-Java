package factory;

public class Person {
	public int id;
	public String name;

	private Person() {

	}

	private Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static class PersonFactory {
		private static Integer id = 1;

		public static Person createPerson(String name) {
			return new Person(id++, name);
		}		
		
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	public static void main(String [] args) {
		Person p = Person.PersonFactory.createPerson("Yousef Khaled");
		System.out.println(p);
		
		Person p2 = Person.PersonFactory.createPerson("Amar Khaled");
		System.out.println(p2);		
	}
	
}