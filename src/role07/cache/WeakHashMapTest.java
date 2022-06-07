package role07.cache;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	static class Person{
		String name;

		public Person(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}	
	}
	public static void main(String[] args) throws InterruptedException {
		WeakHashMap<Person, String> weakHashMap = new WeakHashMap<>();
		Person p1 = new Person("ȫ�浿");
		Person p2 = new Person("������");
		
		// key�� String Ÿ���̸� key�� null ó���ص� ������ ���� ����
		// Constant Pool�� ����Ǳ� ������ ����Ű�� ������ ������
		weakHashMap.put(p1, "1");
		weakHashMap.put(p2, "2");
		
		p2 = null;

		// GC�� weakHashMap���� p2�� �����Ҷ����� ���
		while (true) {
			System.out.println(weakHashMap);
			System.gc();
			if (weakHashMap.size() == 1) {
				break;
			}
		}

		System.out.println("End");
	}

}
