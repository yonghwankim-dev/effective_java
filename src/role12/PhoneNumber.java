package role12;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneNumber {
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "�����ڵ�");
		this.prefix = rangeCheck(prefix, 999, "�����Ƚ�");
		this.lineNum = rangeCheck(lineNum, 9999, "�����ڹ�ȣ");
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
	
	// hashcode���̴� ����� �������� ����. ���� �� �� �ϳ��� �����ؾ���
	
	// �ڵ� 11-2 �������� hashCode �޼��� (70p)
	@Override
	public int hashCode() {
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);
		return result;
	}
	
	
	/*
	 * �� ��ȭ��ȣ�� ���ڿ� ǥ���� ��ȯ�Ѵ�
	 * �� ���ڿ��� 'XXX-YYY-ZZZZ' ������ 12���ڷ� �����ȴ�
	 * XXX�� ���� �ڵ�, YYY�� �����Ƚ�, ZZZZ�� ������ ��ȣ�Դϴ�.
	 * ������ �빮�ڴ� 10���� ���� �ϳ��� ��Ÿ���ϴ�.
	 * 
	 * ��ȭ��ȣ�� �� �κ��� ���� �ʹ� �۾Ƽ� �ڸ����� ä�� �� ���ٸ�,
	 * �տ������� 0���� ä��������. ������� ������ ��ȣ�� 123�̶��
	 * ��ȭ��ȣ�� ������ �� ���ڴ� "0123"�� �˴ϴ�.
	 */
	@Override
	public String toString() {
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
	}

	public static void main(String[] args) {
        PhoneNumber jenny = new PhoneNumber(707, 867, 5309);
        System.out.println("������ ��ȣ: " + jenny);
	}
}
