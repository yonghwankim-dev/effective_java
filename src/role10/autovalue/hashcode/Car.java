package role10.autovalue.hashcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * title : equals�� hashCode�� �� ���� �������ؾ� �ұ�?
 * - hash ���� ����ϴ� Collection(HashSet, HashMap, HashTable)�� ����� �� ������ �߻��Ѵ�.
 * - hash ���� ����ϴ� Collection�� ��ü�� �������� ������ ���Ҷ� ���� ������ ��Ĩ�ϴ�.
 * step1. hashCode() ���ϰ� ������ ��, ���ٸ� step2�� �ٸ��ٸ� �ٸ���ü
 * step2. equals() ���ϰ� ������ ��, ���ٸ� ���ü �ٸ��ٸ� �ٸ���ü 
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
        
        // ���ο� �䱸���� : �÷��ǿ� �ߺ����� �ʴ� Car ��ü�� �����ÿ�
        Set<Car> cars_set = new HashSet<Car>();
        cars_set.add(new Car("foo"));
        cars_set.add(new Car("foo"));
        
        // ���� : 1, ���� : 2 (�ؽ��ڵ� ������ ��)
        // ���� : 1, ���� : 1 (�ؽ��ڵ� ������ ��)
        // hashcode�� equals�� �Բ� ���������� ������ �ڵ尡 ����� �ٸ���
        // �۵��մϴ�. ��Ȯ�� ���ϸ� hash ���� ����ϴ� Collection(HashSset,
        // HashMap, HashTable)�� ����Ҷ� ������ �߻��մϴ�.
        System.out.println(cars_set.size());
    }
}
