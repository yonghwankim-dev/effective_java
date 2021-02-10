package role6;

import java.util.Map;
import java.util.WeakHashMap;

public class Cache {
	public static Map weakMap = new WeakHashMap();
	/**
	 * key값을 "" 리터럴 스트링으로 생성하거나 기본자료형으로 생성하면
	 * 해당 값은 상수풀에 등록이 되어 있게 되고 gc에 의해 지워지지 않기 때문에
	 * WeakHashMap의 만기참조시 삭제하는 전략을 사용할 수 없다.
	 */
	// 외부에서 키를 관리한다고 가정한 변수
	// private static String key = "a";
	private static String key = new String("k");
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Cache test = new Cache();
		
		test.weakMap.put(key, 123);
		
		test.someMethod();
		key = null;
		test.someMethod();	// 키의 참조값이 제거된 후 cache에서 해당 키값을 가진 항목이 제거됨
	}
	
	public static void someMethod() throws InterruptedException
	{
		for(int i=0;i<3;i++)
		{
			Thread.sleep(500);
			System.gc();
			System.out.println(weakMap);
		}
	}

}
