package role01;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static Boolean valueOf(boolean b)
	{
		// b�� true�̸� Boolean.TRUE, b�� false�̸� Boolean.FALSE ��ȯ
		// Boolean.TRUE, Boolean.FALSE�� ��ȯ Ÿ���� Boolean Ŭ���� Ÿ���̴�.
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
		
	public static void main(String[] args) {
		
		/**
		 * ���� �ڵ�� �Ϲ����� �����ڷ� ������ ��ü�̴�.
		 * �Ϲ������� �����ڷ� ������ car1, car2 ��ü��
		 * �������� ����(parameter)������ SM3���� K5����
		 * �� �� ����.
		 */
		Car car1 = new Car(1800);	
		Car car2 = new Car(3500);	
		
		/**
		 * ���� ���� ���丮 �޼��带 Ȱ���Ͽ� ������ ��ü�̴�.
		 * ���ڿ� ������ �Է��� �ʿ���� �ʿ��� ��ü�� �����ϱ�
		 * ���� �޼��带 ȣ���ϸ� �ȴ�.
		 * ������ ���� ���� ���丮 �޼��带 ���Ͽ� �̸�������
		 * ���ϴ� ��ü�� ���������ϴ�.
		 */
		Car SM3 = Car.SM3();		//SM3
		Car K5 = Car.K5();			//K5
		
		Car ganger = Car.of("electric");
		
	}

}

class Car{
	private int price; // ����
//	private static final BigInteger ZERO = new BigInteger();
	
	// ������
	public Car(int price)
	{
		this.price = price;
	}
	
	// ���� ���丮 �޼���
	public static Car SM3()
	{
		return new Car(1800);
	}
	
	// ���� ���丮 �޼���
	public static Car K5()
	{
		return new Car(3500);
	}

	// ���� �ڷ��� ��ü ��ȯ
	public static Car of(String energy) {
		if(energy.equals("eletric")){
			return new Granger(4600);
		}
		if(energy.equals("gasoline")) {
			return new Twosan(2000);
		}
		return null;
	}
}

class Granger extends Car{

	public Granger(int price) {
		super(price);
	}
}
class Twosan extends Car{

	public Twosan(int price) {
		super(price);
	}
}

/**
 *���� ���丮 �޼ҵ� ���� : ���� �ڷ� �� ��ü�� ��ȯ�Ҽ� �ִ�.
 *������ ��� ���� ���ͳ� ���θ����� �ڵ带 ó���ϴ� ���� ���丮 �޼ҵ��̴�.
 *���� �ڵ��� ��Ģ�� ���� Coupon�� Point ��ü�� ���������� �����ϰ� �ִ�.
 *createDiscountItem�� ��ȯ Ÿ���� Discount�� Coupon�� Point Ŭ������ ���� Ŭ�����̴�.
 *���� ���������� ��ü�� ��ȯ�ϱ� ���ؼ��� �� ���� Ŭ������ ���� �������̽��� �����ϰų�, ���� �θ� Ŭ������ ������ �ϸ� �ȴ�.
 */
class Discount{
	
}

class Coupon extends Discount{
	int price;
	Coupon(int price)
	{
		this.price = price;
	}
}
class Point extends Discount{
	int price;
	Point(int price)
	{
		this.price = price;
	}
}

class OrderUtil{
	public static Discount createDiscountItem(String discountCode) throws Exception
	{
		if(!isValidCode(discountCode))
		{
			throw new Exception("�߸��� ���� �ڵ�");
		}
		
		// ���� or ����Ʈ?
		if(isUsableCoupon(discountCode))
		{
			return new Coupon(1000);
		}
		else if(isUsablePoint(discountCode))
		{
			return new Point(500);
		}
		throw new Exception("�̹� ����� �ڵ�");
	}
	public static boolean isValidCode(String discountCode)
	{
		System.out.println("�ڵ尡 ��ȿ���� Ȯ��");
		return false;
	}
	public static boolean isUsableCoupon(String discountCode)
	{
		System.out.println("������ ��ȿ���� Ȯ��");
		return false;
	}
	public static boolean isUsablePoint(String discountCode)
	{
		System.out.println("����Ʈ�� ��ȿ���� Ȯ��");
		return false;
	}
}

/**
 * ���� ���丮 �޼ҵ� ���� : ������ �ڷ��� ��ü�� ������ ���ϴ�
*/
class map_test{
	Map<String, List<String>> list = new HashMap<String, List<String>>(); // ���� �ڷ��� ��ü ����
	Map<String, List<String>> list2 = newInstance();	// ���� ���丮 �޼���
	Map<String, List<String>> list3 = new HashMap<>(); // java 1.7 ���� ����
	
	// ���� ���丮 �޼��� : type inference�� �̿��Ѵ�.
	public static <K,V> HashMap<K, V> newInstance()
	{
		return new HashMap<K, V>();
	}
}

/**
 * ����� �Ϸ��� �θ� Ŭ������ public�̳� protected �����ڰ�
 * �ʿ���
 * ������ ���� ���� ���丮 �޼��常 �����ϸ� ���� Ŭ������ ����� ����
 */
//class A extends Collections{
//	
//}