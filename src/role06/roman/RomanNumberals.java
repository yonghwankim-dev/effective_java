package role06.roman;

import java.util.regex.Pattern;

public class RomanNumberals {
	// �ڵ� 6-1 : ������ �� ���� �ø� �� ����
	// String.matches �޼���� ���ο��� ����� ����ǥ���Ŀ� Pattern
	// �ν��Ͻ��� �ѹ� ����ϰ� �������� ��ٷ� ������ �÷��� ����� ��
	// Pattern �ν��Ͻ��� �Է¹��� ����ǥ���Ŀ� �ش��ϴ� ���� ���� �ӽ���
	// �����ϱ� ������ �ν��Ͻ� ���� ����� ����
	public static boolean isRomanNumberalSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}
	
	// �ڵ� 6-2 : ����� ��ü�� ������ ������ ������
	// Pattern �ν��Ͻ��� Ŭ���� �ʱ�ȭ(���� �ʱ�ȭ) �������� ���� ������
	// ĳ���صΰ� isRomanNumberalFast �޼��尡 ȣ��ɶ����� �� �ν��Ͻ���
	// ������
	private static final Pattern ROMAN = Pattern.compile(
			"^(?=.)M*(C[MD]|D?C{0,3})"
			+ "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	
	public static boolean isRomanNumberalFast(String s) {
		return ROMAN.matcher(s).matches();
	}
}
