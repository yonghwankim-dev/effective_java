package role03.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.management.RuntimeErrorException;

import org.junit.Assert;

import role03.field.Elvis;

/**
 * private �����ڸ� Ȱ���Ͽ� �̱��� ��ü�� ���� �� ��������
 * AccessibleObject.setAccessible �޼����� ������ �޾� ������ ŉ���� Ŭ���̾�Ʈ��
 * ���÷��� ����� ���� private �����ڸ� ȣ���Ҽ� �ִٴ� ��.
 * �̷��� �������� �ذ��ϱ� ���ؼ��� �ι�° ��ü�� �����϶�� ��û�� �޾ƿ��� ���ܸ� ��������
 * �����ڸ� ���ľ��Ѵ�.
 *
 */
public class PrivateInvoker {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

		Private p = Private.INSTANCE;
		
		Constructor<? extends Private> con = p.getClass().getDeclaredConstructor();
		con.setAccessible(true);	// �ش� �������� ������ �����
		
		Private p2 = con.newInstance();	// private ������ ȣ���Ͽ�, ��2�� �ν��Ͻ��� ������
		
		System.out.println(p.equals(p));	// Expected Output : true
		System.out.println(p.equals(p2));	// Expected Output : false
	}
}

class Private{
	public static final Private INSTANCE = new Private();
	
	// �Ϲ����� �̱��� Ŭ������ private ������
	private Private()
	{
		System.out.println("hello!");
	}
	
	// ���÷��� API�� ������ ���� ���� ���� : �ι�° ��ü�� �����Ϸ� �Ҷ� ���ܸ� ����
//	private Private()
//	{
//		if(INSTANCE != null) {
//			throw new RuntimeException("�����ڸ� ȣ���� �� �����ϴ�.");
//		}
//	}
}
