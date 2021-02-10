package role6;

public class CallbackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SomeClass sc = new SomeClass();
		
		SomeClass.CB callback = new SomeClass.CB() {
			
			@Override
			public void cbMethod() {
				// TODO Auto-generated method stub
				System.out.println("i'm callback function !");
			}
		};
		
		sc.someMethod(callback);
		
		/**
		 *	명시적 제거(callback=null)를 하지 않을 경우 메모리 누수 발생
		 *	따라서 callback을 담을 WeakHashMap을 생성하고 callback을 담는다.
		 *	이때 키에 해당하는 값은 변수에 담고 someMethod의 사용이 끝나면 키를 제거한다. 
		 */
		 
		
	}

}

class SomeClass
{
	interface CB{
		void cbMethod();
	}
	public void someMethod(CB callback) // 인자로 callback 메서드를 인자로 받는다.
	{
		callback.cbMethod();
	}
}
