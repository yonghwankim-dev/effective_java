package role7.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.WeakHashMap;

/**
 * title : 다쓴 객체 참조를 해제하라
 * 메모리 누수의 주범 3가지
 * 1. 자기 메모리를 직접 관리하는 클래스 : Stack, Queue, Array...
 * 2. 캐시(Cache)
 * 3. 리스너(Listener) 또는 콜백(callback)
 * 
 * 다쓴 참조를 해제하는 가장 좋은 방법
 * - 참조 변수를 유효범위(scope) 밖으로 밀어내는 것
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
		// 스택이 커졌다가 줄어들었을때 스택에서 꺼내진 객체들을 가비지 컬렉터가 회수하지 않음 => 메모리 누수 발생
		Object result = elements[--size];
		// solution : 다쓴 참조는 null 처리
		elements[size] = null;
		
		return result;	
	}
	
	private void ensureCapcity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
