package role3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class Member implements Serializable {
	private String name;
	private String email;
	private int age;
	
	public Member(String name, String email, int age)
	{
		this.name = name;
		this.email = email;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", age=" + age + "]";
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

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}