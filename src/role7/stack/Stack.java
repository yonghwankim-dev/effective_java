package role7.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.WeakHashMap;

/**
 * title : �پ� ��ü ������ �����϶�
 * �޸� ������ �ֹ� 3����
 * 1. �ڱ� �޸𸮸� ���� �����ϴ� Ŭ���� : Stack, Queue, Array...
 * 2. ĳ��(Cache)
 * 3. ������(Listener) �Ǵ� �ݹ�(callback)
 * 
 * �پ� ������ �����ϴ� ���� ���� ���
 * - ���� ������ ��ȿ����(scope) ������ �о�� ��
 */
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapcity();
		elements[size++] = e;
	}
	
	public Object pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		// ������ Ŀ���ٰ� �پ������� ���ÿ��� ������ ��ü���� ������ �÷��Ͱ� ȸ������ ���� => �޸� ���� �߻�
		Object result = elements[--size];
		// solution : �پ� ������ null ó��
		elements[size] = null;
		
		return result;	
	}
	
	private void ensureCapcity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
