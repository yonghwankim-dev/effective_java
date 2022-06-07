package role10.autovalue.hashcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * title : equals와 hashCode는 왜 같이 재정의해야 할까?
 * - hash 값을 사용하는 Collection(HashSet, HashMap, HashTable)을 사용할 때 문제가 발생한다.
 * - hash 값을 사용하는 Collection은 객체가 논리적으로 같은지 비교할때 다음 과정을 거칩니다.
 * step1. hashCode() 리턴값 같은지 비교, 같다면 step2로 다르다면 다른객체
 * step2. equals() 리턴값 같은지 비교, 같다면 동등객체 다르다면 다른객체 
 */
public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(name, other.name);
	}    

	public static void main(String[] args) {
        Car car1 = new Car("foo");
        Car car2 = new Car("foo");
        
        System.out.println(car1.equals(car2)); // true
        
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("foo"));
        cars.add(new Car("foo"));

        System.out.println(cars.size());	// 2
        
        // 새로운 요구사항 : 컬렉션에 중복되지 않는 Car 객체만 넣으시오
        Set<Car> cars_set = new HashSet<Car>();
        cars_set.add(new Car("foo"));
        cars_set.add(new Car("foo"));
        
        // 예상 : 1, 실제 : 2 (해시코드 재정의 전)
        // 예상 : 1, 실제 : 1 (해시코드 재정의 후)
        // hashcode를 equals와 함께 재정의하지 않으면 코드가 예상과 다르게
        // 작동합니다. 정확히 말하면 hash 값을 사용하는 Collection(HashSset,
        // HashMap, HashTable)을 사용할때 문제가 발생합니다.
        System.out.println(cars_set.size());
    }
}
