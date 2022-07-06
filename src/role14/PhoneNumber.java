package role14;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneNumber implements Comparable<PhoneNumber>{
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "�����ڵ�");
		this.prefix = rangeCheck(prefix, 999, "�����Ƚ�");
		this.lineNum = rangeCheck(lineNum, 9999, "�����ڹ�ȣ");
	}

	
	
	// �⺻ Ÿ�� �ʵ尡 ������ ���� ����, ��� 1
//	@Override
//	public int compareTo(PhoneNumber pn) {
//		int result = Short.compare(areaCode, pn.areaCode);   // ���� �߿��� �ʵ�
//		if(result == 0) {
//			result = Short.compare(prefix, pn.prefix);       // �� ��°�� �߿��� �ʵ�
//			if(result == 0) {
//				result = Short.compare(lineNum, pn.lineNum); // �� ��°�� �߿��� �ʵ�
//			}
//		}
//		return result;
//	}
	
	// ���� ���� �޼��带 �̿��� ���, ��� 2
	// ���� ���� �޼��� Comparator.comparingInt, Comparator.thenComparing
	private static final Comparator<PhoneNumber> COMPARATOR =
			Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
					  .thenComparing(pn -> pn.prefix)
					  .thenComparing(pn -> pn.lineNum);
	@Override
	public int compareTo(PhoneNumber pn) {
		return COMPARATOR.compare(this, pn);
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
	
	@Override
	public int hashCode() {
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
	}

	public static void main(String[] args) {
        PhoneNumber jenny = new PhoneNumber(707, 867, 5309);
        System.out.println("������ ��ȣ: " + jenny);
	}
}
