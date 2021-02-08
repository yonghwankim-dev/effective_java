package role3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * private 생성자를 활용하여 싱글턴 객체를 생성 시 주의할점
 * AccessibleObject, setAccessible 메서드의 도움을 받아 권한을 흭득한 클라이언트는
 * 리플렉션 기능을 통해 private 생성자를 호출할수 있다는 것.
 * 이러한 문제점을 해결하기 위해서는 두번째 객체를 생성하라는 요청을 받아오면 예외를 던지도록
 * 생성자를 고쳐야한다.
 *
 */
public class PrivateInvoker {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Constructor<?> con = Private.class.getDeclaredConstructors()[0];
		con.setAccessible(true);
		Private p = (Private) con.newInstance();
	}

}

class Private{
	private Private()
	{
		System.out.println("hello!");
	}
}
