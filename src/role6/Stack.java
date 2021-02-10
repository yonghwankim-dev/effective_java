package role6;

import java.util.Arrays;
import java.util.EmptyStackException;
/**
 * 메모리 누수 문제
 * 문제가 되는 부분은 33Line으로 스택이 pop하는 과정에서
 * pop한 객체를 null로 하지 않앗기 때문에 참조하지 않은 객체를 보유하는
 * 만기 참조문제가 발생한다.
 */
public class Stack {
	private Object[] elements;
	private int size=0;
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
	public Stack()
	{
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e)
	{
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop()
	{
		if(size==0)
		{
			throw new EmptyStackException();
		}
		return elements[--size];
	}
	
	public Object pop2()
	{
		if(size==0)
		{
			throw new EmptyStackException();
		}
		Object results = elements[--size];
		elements[size] = null;
		return results;
	}
	
	/**
	 * 적어도 하나 이상의 원소를 다음 공간을 보관한다.
	 * 배열의 길이를 늘려야 할 때마다 대략 두 배씩 늘인다.
	 */
	private void ensureCapacity()
	{
		if(elements.length==size)
		{
			elements = Arrays.copyOf(elements,  2*size+1);
		}
	}
}
