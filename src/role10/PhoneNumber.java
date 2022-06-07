package role10;

import java.util.Objects;

public class PhoneNumber {
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "�����ڵ�");
		this.prefix = rangeCheck(prefix, 999, "�����Ƚ�");
		this.lineNum = rangeCheck(lineNum, 999, "�����ڹ�ȣ");
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

	// equals �����ǽ� hashCode�� ������ ���־�� �Ѵ�.
	@Override
	public int hashCode() {
		return Objects.hash(areaCode, prefix, lineNum);
	}	
}
