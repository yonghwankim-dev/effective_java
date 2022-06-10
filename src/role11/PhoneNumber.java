package role11;

import java.util.HashMap;
import java.util.Map;
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
	
	// hashcode���̴� ����� �������� ����. ���� �� �� �ϳ��� �����ؾ���
	
	// �ڵ� 11-2 �������� hashCode �޼��� (70p)
	@Override
	public int hashCode() {
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);
		return result;
	}
	
	// �ڵ� 11-3 ����¥�� hashCode �޼��� - ������ ��¦ �ƽ��� (p71)
//	@Override
//	public int hashCode() {
//		return Objects.hash(areaCode, prefix, lineNum);
//	}
	
	// �ڵ� 11-4 �ؽ��ڵ带 ���� �ʱ�ȭ�ϴ� hashCode �޼��� - ������ ���������� ����ؾ��� (71p)
//	private int hashCode; // �ڵ����� 0���� �ʱ�ȭ��
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
		m.put(new PhoneNumber(707, 867, 123), "����");
		System.out.println(m.get(new PhoneNumber(707, 867, 123)));
	}
}
