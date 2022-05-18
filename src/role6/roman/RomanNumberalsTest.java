package role6.roman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class RomanNumberalsTest {
	int numReps = 1000000;
	
	// ����ӵ� : 3.419s
	@Test
	void isRomanNumberalSlowTest() {
		String s = "MCMLXXVI";
		boolean b = false;
		for(int j = 0; j < numReps; j++) {
			b ^= RomanNumberals.isRomanNumberalSlow(s); 
		}
	}
	
	// ����ӵ� : 0.530s
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
		
		// map.keySet()�� ȣ���Ҵ븶�� ���ο� Set<> �ν��Ͻ��� �������� �ʰ�
		// ���� ������ �ν��Ͻ��� ��ȯ�մϴ�.
		assertTrue(s1 == s2); 		
	}

}
