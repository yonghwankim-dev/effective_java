package role06.roman;

import java.util.regex.Pattern;

public class RomanNumberals {
	// 코드 6-1 : 성능을 더 끌어 올릴 수 있음
	// String.matches 메서드는 내부에서 만드는 정규표현식용 Pattern
	// 인스턴스는 한번 사용하고 버려져서 곧바로 가비지 컬렉션 대상이 됨
	// Pattern 인스턴스는 입력받은 정규표현식에 해당하는 유한 상태 머신을
	// 생성하기 때문에 인스턴스 생성 비용이 높음
	public static boolean isRomanNumberalSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	}
	
	// 코드 6-2 : 값비싼 객체를 재사용해 성능을 개선함
	// Pattern 인스턴스를 클래스 초기화(정적 초기화) 과정에서 직접 생성해
	// 캐싱해두고 isRomanNumberalFast 메서드가 호출될때마다 이 인스턴스를
	// 재사용함
	private static final Pattern ROMAN = Pattern.compile(
			"^(?=.)M*(C[MD]|D?C{0,3})"
			+ "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
	
	public static boolean isRomanNumberalFast(String s) {
		return ROMAN.matcher(s).matches();
	}
}
