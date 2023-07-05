package zadZaVjb4;

public class Student extends Person {
	

	@Override
	public boolean equals(Object obj) {
		//provjere?
		if (getStudentId()==((Student)obj).getStudentId()) return true;
		else return false;
	}
	
	
	@Override
	public String toString() {
		return getName()+ " " + getSurname() + ", age=" + getAge() + ", studentId=" + studentId + ", academicYear=" + academicYear + "]";
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}
	public Student(String name, String surname, int age, String studentId, int academicYear) {
		super(name, surname, age);
		this.studentId = studentId;
		this.academicYear = academicYear;
	}
	private String studentId;
	private int academicYear;

}
