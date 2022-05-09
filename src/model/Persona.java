package model;

import java.io.Serializable;

public class Persona<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private T name;
	private T lastName;
	private T fullName;
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
		this.fullName = (T) (name.toString() + lastName.toString());
		this.birthDay = birthDay;
		this.country = country;
		this.photo = photo;
		this.code = code;
		this.gender=gender;
		this.age=age;
		this.heith=heith;
	}
	
	

	public T getFullName() {
		return fullName;
	}



	public void setFullName(T fullName) {
		this.fullName = fullName;
	}



	public T getCountry() {
		return country;
	}



	public void setCountry(T country) {
		this.country = country;
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

	@Override
	public String toString() {
		return  name + "," + lastName + "," + fullName + ","+ birthDay
				+ "," + country + "," + photo + "," + code + "," + gender + "," + age
				+ "," + heith + "\n";
	}
	
	public void editPerson(Persona p,T name, T lastName, T country,T age,T heith,T photo) {
		p.setName(name);
		p.setAge(age);
		p.setLastName(lastName);
		p.setCountry(country);
		p.setPhoto(photo);
		p.setHeith(heith);
		
	}
	
}
