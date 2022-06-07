package role03.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.management.RuntimeErrorException;

import org.junit.Assert;

import role03.field.Elvis;

/**
 * private 생성자를 활용하여 싱글턴 객체를 생성 시 주의할점
 * AccessibleObject.setAccessible 메서드의 도움을 받아 권한을 흭득한 클라이언트는
 * 리플렉션 기능을 통해 private 생성자를 호출할수 있다는 것.
 * 이러한 문제점을 해결하기 위해서는 두번째 객체를 생성하라는 요청을 받아오면 예외를 던지도록
 * 생성자를 고쳐야한다.
 *
 */
public class PrivateInvoker {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		Private p = Private.INSTANCE;
		
		Constructor<? extends Private> con = p.getClass().getDeclaredConstructor();
		con.setAccessible(true);	// 해당 생성자의 접근을 허용함
		
		Private p2 = con.newInstance();	// private 생성자 호출하여, 제2의 인스턴스가 생성됨
		
		System.out.println(p.equals(p));	// Expected Output : true
		System.out.println(p.equals(p2));	// Expected Output : false
	}
}

class Private{
	public static final Private INSTANCE = new Private();
	
	// 일반적인 싱글턴 클래스의 private 생성자
	private Private()
	{
		System.out.println("hello!");
	}
	
	// 리플렉션 API의 공격을 막기 위한 예방 : 두번째 객체를 생성하려 할때 예외를 던짐
//	private Private()
//	{
//		if(INSTANCE != null) {
//			throw new RuntimeException("생성자를 호출할 수 없습니다.");
//		}
//	}
}
