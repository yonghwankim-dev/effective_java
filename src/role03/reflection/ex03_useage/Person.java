package role03.reflection.ex03_useage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person {
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
		Object obj = new Person("���ȯ", 20); // Object Ŭ������ Person Ŭ������ ���� Ŭ��������
											 // obj ���������� Person �ν��Ͻ��� ����ų �� ���� (������)
//		obj.getName(); // obj �ν��Ͻ��� Object Ÿ���̱� ������ 
					   // Object Ŭ������ �����ϴ� ���(�ʵ���, �޼���)���� ������ �� ����
		
		Class<Person> person = Person.class;
		Method getName = person.getMethod("getName");
		
		// Method.invoke(Object obj, Object... args)
		// Method.invoke(�޼��带 �����ų �ν��Ͻ�, �ش� �޼��忡 �ѱ� ����)
		String name = (String) getName.invoke(obj, null);
		System.out.println(name);	// Expected Output : ���ȯ
	}
}
