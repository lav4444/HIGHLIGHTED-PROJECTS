package zadZaVjb4;

public class Teacher extends Person {
	
	@Override
	public String toString() {
		return getName() +" "+ getSurname() + ", age=" + getAge() +", email=" + email + ", subject=" + subject + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object obj) {
		//provjere?
		if (getEmail()==((Teacher)obj).getEmail() ) return true;
		else return false;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Teacher(String name, String surname, int age, String email, String subject, double salary) {
		super(name, surname, age);
		this.email = email;
		this.subject = subject;
		this.salary = salary;
	}
	private String email, subject;
	private double salary;
	
	public void increaseSalary(int povisica) {
		double x = (povisica*1.0)/100.0;
		setSalary(getSalary()*x);
	}
	static void increaseSalary(int post, Teacher...sirotinja) {
		double x = (post*1.0)/100.0;
		for (int i = 0; i<sirotinja.length; i++) {
			sirotinja[i].setSalary(sirotinja[i].getSalary()*x);
		}
		
	}
	

}
