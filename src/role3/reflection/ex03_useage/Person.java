package role3.reflection.ex03_useage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object obj = new Person("김용환", 20); // Object 클래스는 Person 클래스의 조상 클래스여서
											 // obj 참조변수는 Person 인스턴스를 가리킬 수 있음 (다형성)
//		obj.getName(); // obj 인스턴스는 Object 타입이기 때문에 
					   // Object 클래스에 존재하는 멤버(필드멤버, 메서드)만을 참조할 수 있음
		
		Class<Person> person = Person.class;
		Method getName = person.getMethod("getName");
		
		// Method.invoke(Object obj, Object... args)
		// Method.invoke(메서드를 실행시킬 인스턴스, 해당 메서드에 넘길 인자)
		String name = (String) getName.invoke(obj, null);
		System.out.println(name);	// Expected Output : 김용환
	}
}
