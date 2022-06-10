package role11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneNumber {
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "지역코드");
		this.prefix = rangeCheck(prefix, 999, "프리픽스");
		this.lineNum = rangeCheck(lineNum, 999, "가입자번호");
	}
	
	private static short rangeCheck(int val, int max, String arg) {
		if(val < 0 || val > max) {
			throw new IllegalArgumentException(arg + ": " + val);
		}
		return (short) val;
	}

	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		
		if(!(o instanceof PhoneNumber)) {
			return false;
		}
		
		PhoneNumber pn = (PhoneNumber) o;
		return pn.lineNum == lineNum &&
			   pn.prefix == prefix &&
			   pn.areaCode == areaCode;
	}
	
	// hashcode없이는 제대로 동작하지 않음. 다음 셋 중 하나를 선택해야함
	
	// 코드 11-2 전형적인 hashCode 메서드 (70p)
	@Override
	public int hashCode() {
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);
		return result;
	}
	
	// 코드 11-3 한줄짜리 hashCode 메서드 - 성능이 살짝 아쉬움 (p71)
//	@Override
//	public int hashCode() {
//		return Objects.hash(areaCode, prefix, lineNum);
//	}
	
	// 코드 11-4 해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야함 (71p)
//	private int hashCode; // 자동으로 0으로 초기화됨
//
//	@Override
//	public int hashCode() {
//		int result = this.hashCode;
//		if(result == 0) {
//			result = Short.hashCode(areaCode);
//			result = 31 * result + Short.hashCode(prefix);
//			result = 31 * result + Short.hashCode(lineNum);
//			this.hashCode = result;
//		}
//		return result;
//	}

	public static void main(String[] args) {
		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		m.put(new PhoneNumber(707, 867, 123), "제니");
		System.out.println(m.get(new PhoneNumber(707, 867, 123)));
	}
}
