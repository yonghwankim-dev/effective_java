package role01;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static Boolean valueOf(boolean b)
	{
		// b가 true이면 Boolean.TRUE, b가 false이면 Boolean.FALSE 반환
		// Boolean.TRUE, Boolean.FALSE의 반환 타입은 Boolean 클래스 타입이다.
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
		
	public static void main(String[] args) {
		
		/**
		 * 다음 코드는 일반적인 생성자로 생성한 객체이다.
		 * 일반적으로 생성자로 생성한 car1, car2 객체는
		 * 생성자의 인자(parameter)만으로 SM3인지 K5인지
		 * 알 수 없다.
		 */
		Car car1 = new Car(1800);	
		Car car2 = new Car(3500);	
		
		/**
		 * 다음 정적 팩토리 메서드를 활용하여 생성한 객체이다.
		 * 인자에 가격을 입력할 필요없이 필요한 객체를 생성하기
		 * 위한 메서드를 호출하면 된다.
		 * 다음과 같은 정적 팩토리 메서드를 통하여 이름만으로
		 * 원하는 객체를 생성가능하다.
		 */
		Car SM3 = Car.SM3();		//SM3
		Car K5 = Car.K5();			//K5
		
		Car ganger = Car.of("electric");
		
	}

}

class Car{
	private int price; // 가격
//	private static final BigInteger ZERO = new BigInteger();
	
	// 생성자
	public Car(int price)
	{
		this.price = price;
	}
	
	// 정적 팩토리 메서드
	public static Car SM3()
	{
		return new Car(1800);
	}
	
	// 정적 팩토리 메서드
	public static Car K5()
	{
		return new Car(3500);
	}

	// 하위 자료형 객체 반환
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
 *정적 팩토리 메소드 장점 : 하위 자료 형 객체를 반환할수 있다.
 *다음은 어느 가상 인터넷 쇼핑몰에서 코드를 처리하는 정적 팩토리 메소드이다.
 *할인 코드의 규칙에 따라 Coupon과 Point 객체를 선택적으로 리턴하고 있다.
 *createDiscountItem의 반환 타입은 Discount로 Coupon과 Point 클래스의 상위 클래스이다.
 *따라서 선택적으로 객체를 반환하기 위해서는 두 하위 클래스가 같은 인터페이스를 구현하거나, 같은 부모 클래스를 갖도록 하면 된다.
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
			throw new Exception("잘못된 할인 코드");
		}
		
		// 쿠폰 or 포이트?
		if(isUsableCoupon(discountCode))
		{
			return new Coupon(1000);
		}
		else if(isUsablePoint(discountCode))
		{
			return new Point(500);
		}
		throw new Exception("이미 사용한 코드");
	}
	public static boolean isValidCode(String discountCode)
	{
		System.out.println("코드가 유효한지 확인");
		return false;
	}
	public static boolean isUsableCoupon(String discountCode)
	{
		System.out.println("쿠폰가 유효한지 확인");
		return false;
	}
	public static boolean isUsablePoint(String discountCode)
	{
		System.out.println("포인트가 유효한지 확인");
		return false;
	}
}

/**
 * 정적 팩토리 메소드 장점 : 형인자 자료형 객체를 생성시 편하다
*/
class map_test{
	Map<String, List<String>> list = new HashMap<String, List<String>>(); // 기존 자료형 객체 생성
	Map<String, List<String>> list2 = newInstance();	// 정적 팩토리 메서드
	Map<String, List<String>> list3 = new HashMap<>(); // java 1.7 이후 개선
	
	// 정적 팩토리 메서드 : type inference를 이용한다.
	public static <K,V> HashMap<K, V> newInstance()
	{
		return new HashMap<K, V>();
	}
}

/**
 * 상속을 하려면 부모 클래스가 public이나 protected 생성자가
 * 필요함
 * 생성자 없이 정적 팩토리 메서드만 제공하면 하위 클래스를 만들수 없음
 */
//class A extends Collections{
//	
//}