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
		Person p1 = new Person("홍길동");
		Person p2 = new Person("강감찬");
		
		// key가 String 타입이면 key를 null 처리해도 삭제가 되지 않음
		// Constant Pool에 저장되기 때문에 가리키는 참조가 존재함
		weakHashMap.put(p1, "1");
		weakHashMap.put(p2, "2");
		
		p2 = null;

		// GC가 weakHashMap에서 p2를 제거할때까지 대기
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
