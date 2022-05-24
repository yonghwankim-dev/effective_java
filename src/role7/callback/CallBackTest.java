package role7.callback;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class CallBackTest {

	@FunctionalInterface
	public interface Callback{
		public void method();
	}
			
	public static void main(String[] args) throws IOException {
		Object obj = new Object();
		Map<Object, Callback> weakHashMap = new WeakHashMap<Object, Callback>();
		
		CallBackTest.Callback callback = new CallBackTest.Callback() {

			@Override
			public void method() {
				System.out.println("call method");
				
			}
		};
		
		weakHashMap.put(obj, callback);

		obj = null;
		
		// GC가 수거할때까지 대기
		while(true) {
			System.out.println(weakHashMap);
			System.gc();
			if(weakHashMap.size() == 0) {
				break;
			}
		}
	}
}
