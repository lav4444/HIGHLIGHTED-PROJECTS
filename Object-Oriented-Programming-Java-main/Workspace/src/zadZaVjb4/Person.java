package zadZaVjb4;

public class Person {
	
	public boolean equals(Person osobaDva) {
		if (getName()==osobaDva.getName() && getSurname()==osobaDva.getSurname() && getAge()==osobaDva.getAge()) return true;
		else return false;
	}
	@Override
	public boolean equals(Object obj) {
		//provjere?
		if (getName()==((Person)obj).getName() && getSurname()==((Person)obj).getSurname() && getAge()==((Person)obj).getAge()) return true;
		else return false;
	} 
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	private String name, surname;
	private int age;

}
