package role6.sum;

public class Sum {
	// �ڵ� 6-3 : ��ü�� ��������� ��ġ�� Ž��
	// �ڽ̵� �⺻Ÿ�Ժ��ٴ� �⺻ Ÿ���� ����ϰ� �ǵ�ġ ���� ����ڽ��� ������� �ʵ��� ����
	public static long sum() {
		Long sum = 0L;	// �⺻Ÿ���� �ƴ� Long Ŭ����
		
		for(long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;	// sum�� unboxing�Ǿ� i�� ������ �ǰ� �����Ŀ� Autoboxing�Ǿ� Long Ÿ������ ��ȯ��
						// i = 1; sum = 0L;
						// sum = sum + 1;
						// sum = sum.intValue() + 1;	// unboxing
						// sum = 2;
						// sum = new Long(2); AutoBoxing
		}
		return sum;
	}
	
	public static long sum2() {
		long sum = 0L;	// Long -> long (�⺻ ������ Ÿ��)
		
		for(long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;	
		}
		return sum;
	}
}
