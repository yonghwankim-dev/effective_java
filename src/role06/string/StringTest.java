package role06.string;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class StringTest {

	/**
	 * 권장하지 않는 문자열 생성방식
	 * - heap.StringPool에 있는 문자열 "hello"를 가지고 다시 heap 영역에 인스턴스를 생성하는 것
	 * - 인스턴스를 2번 생성하는 것 
	 * String s = new String("hello");
	 * 
	 * 권장하는 문자열 생성방식
	 * - 참조변수 s는 heap.StringPool 영역에 등록된 문자열 "hello"를 가리킴
	 * - 같은 가상 머신 안에서 이와 똑같은 문자열 리터럴을 사용하는 모든 코드가 같은 객체를 재사용함을 보장함
	 * String s = "hello";
	 * 
	 */
	@Test
	void StringTest() {
		String s1 = "hello";	// heap.StringPool에 있는 hello를 가리킴
		String s2 = "hello";	// heap.StringPool에 있는 hello를 가리킴
		String s3 = new String("hello"); // heap 영역에 String 인스턴스를 생성함
		String s4 = new String("hello"); // heap 영역에 String 인스턴스를 생성함
		String s5 = new String("hello").intern(); // heap 영역에 생성한 String 인스턴스를 StringPool에 등록
		
		
		assertTrue(s1 == s2);
		assertFalse(s3 == s4);
		assertFalse(s1 == s3);
		assertTrue(s1 == s5);
		
	}

}
