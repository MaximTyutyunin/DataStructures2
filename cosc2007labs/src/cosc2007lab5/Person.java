package cosc2007lab5;

public class Person{

	private String firstName, lastName;
	private int age, year;
	private char gender;
	
	public Person(String firstName, String lastName, int age, int year, char gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.year = year;
		this.gender = gender;
		
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}


	public String toString() {
		return "PERSON: " + firstName + " " + lastName + (gender=='M'?" (Male)": " (Female)") 
				+ ", age = " + age + ", birth year = " + year;
	}
	
}
