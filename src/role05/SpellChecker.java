package role05;

import java.util.List;

/**
 * title : 정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기가 어려움
 * 1. 사전이 언어별로 따로 있고 특수 어휘용 사전을 별도로 두는 경우도 있음
 * 2. 사전 하나로 모든 쓰임에 대응할 수가 없음
 * 3. 필드에서 final 한정자를 제거하고 다른 사전으로 교체하는 메서드를 교체할 수 있지만
 * 이 방식은 오류를 내기 쉬우며 멀티스레드 환경에서는 사용할 수 없음
 * 4. 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스는 적합하지 않음  
 */
public class SpellChecker {
	private static final Lexicon dictionary = new Lexicon();
	
	// 객체 생성 방지
	private SpellChecker() {
		throw new AssertionError();
	}
	
	public static boolean isValid(String word) {
		return false;
	}
	
	public static List<String> suggestions(String type){
		return null;
	}
}
