package model;

public class Persona<T> {
	
	private T name;
	private T lastName;
	private T birthDay;
	private T country;
	private T photo;
	private T code;
	private T gender;
	private T age;
	private T heith;
	
	
	public Persona(T name, T lastName, T birthDay, T country, T photo, T code,T gender,T age,T heith) {
		this.name = name;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.country = country;
		this.photo = photo;
		this.code = code;
		this.gender=gender;
		this.age=age;
		this.heith=heith;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public T getLastName() {
		return lastName;
	}

	public void setLastName(T lastName) {
		this.lastName = lastName;
	}

	public T getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(T birthDay) {
		this.birthDay = birthDay;
	}

	public T getYear() {
		return country;
	}

	public void setYear(T year) {
		this.country = year;
	}

	public T getPhoto() {
		return photo;
	}

	public void setPhoto(T photo) {
		this.photo = photo;
	}

	public T getCode() {
		return code;
	}

	public void setCode(T code) {
		this.code = code;
	}

	public T getGender() {
		return gender;
	}

	public void setGender(T gender) {
		this.gender = gender;
	}
	
	public void printInfo() {
		System.out.print(name+" "+lastName+" "+age+" "+" "+country+" "+birthDay+" "+code+" "+photo+" "+gender+" "+heith+"-- ");
		System.out.println("_____________________________________________________________________________");
	}

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}

	public T getHeith() {
		return heith;
	}

	public void setHeith(T heith) {
		this.heith = heith;
	}
	
	
}
