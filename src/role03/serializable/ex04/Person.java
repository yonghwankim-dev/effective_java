package role03.serializable.ex04;

import java.io.Serializable;

public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    public static String country = "ITALY";
    private int age;
    private String name;
    public transient int height;
    
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static String getCountry() {
		return country;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public int getHeight() {
		return height;
	}
	public static void setCountry(String country) {
		Person.country = country;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(int height) {
		this.height = height;
	}
    
    
}
