package model;

public class Persona<T> {
	
	private T name;
	private T lastName;
	private T birthDay;
	private T year;
	private T photo;
	private T code;
	
	public Persona(T name, T lastName, T birthDay, T year, T photo, T code) {
		this.name = name;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.year = year;
		this.photo = photo;
		this.code = code;
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
		return year;
	}

	public void setYear(T year) {
		this.year = year;
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
	
	
	
	
}
