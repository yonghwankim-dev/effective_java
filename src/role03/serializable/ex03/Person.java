package role03.serializable.ex03;

import java.io.Serializable;

public class Person implements Serializable{
	private int age;
	private String name;
	private Address country;	// Address Ŭ���� ���� Serializable �ؾ���
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public Address getCountry() {
		return country;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCountry(Address country) {
		this.country = country;
	}

	
}
