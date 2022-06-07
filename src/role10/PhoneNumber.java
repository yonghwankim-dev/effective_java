package role10;

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

	// equals 재정의시 hashCode도 재정의 해주어야 한다.
	@Override
	public int hashCode() {
		return Objects.hash(areaCode, prefix, lineNum);
	}	
}
