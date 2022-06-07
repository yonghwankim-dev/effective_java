package role03.serializable.ex01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class Member2 implements Serializable {
	private String name;
	private String email;
	private int age;
	private String phone; 	//phone 속성을 추가

	public Member2(String name, String email, int age, String phone) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Member2 [name=" + name + ", email=" + email + ", age=" + age + ", phone=" + phone + "]";
	}	
	
	
}