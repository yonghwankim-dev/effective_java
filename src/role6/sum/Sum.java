package role6.sum;

public class Sum {
	// 코드 6-3 : 객체가 만들어지는 위치를 탐색
	// 박싱된 기본타입보다는 기본 타입을 사용하고 의도치 않은 오토박싱이 숨어들지 않도록 주의
	public static long sum() {
		Long sum = 0L;	// 기본타입이 아닌 Long 클래스
		
		for(long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;	// sum이 unboxing되어 i와 연산이 되고 연산후에 Autoboxing되어 Long 타입으로 변환됨
						// i = 1; sum = 0L;
						// sum = sum + 1;
						// sum = sum.intValue() + 1;	// unboxing
						// sum = 2;
						// sum = new Long(2); AutoBoxing
		}
		return sum;
	}
	
	public static long sum2() {
		long sum = 0L;	// Long -> long (기본 데이터 타입)
		
		for(long i = 0; i <= Integer.MAX_VALUE; i++) {
			sum += i;	
		}
		return sum;
	}
}
