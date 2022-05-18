package role6.roman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class RomanNumberalsTest {
	int numReps = 1000000;
	
	// 수행속도 : 3.419s
	@Test
	void isRomanNumberalSlowTest() {
		String s = "MCMLXXVI";
		boolean b = false;
		for(int j = 0; j < numReps; j++) {
			b ^= RomanNumberals.isRomanNumberalSlow(s); 
		}
	}
	
	// 수행속도 : 0.530s
	@Test
	void isRomanNumberalFastTest() {
		String s = "MCMLXXVI";
		boolean b = false;
		for(int j = 0; j < numReps; j++) {
			b ^= RomanNumberals.isRomanNumberalFast(s); 
		}
	}
	
	@Test
	void test() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		
		Set<String> s1 = map.keySet();
		
		map.put("4", "4");
		
		Set<String> s2 = map.keySet();
		
		// map.keySet()을 호출할대마다 새로운 Set<> 인스턴스를 생성하지 않고
		// 기존 생성된 인스턴스를 반환합니다.
		assertTrue(s1 == s2); 		
	}

}
