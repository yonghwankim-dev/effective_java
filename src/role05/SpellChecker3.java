package role05;

import java.util.List;
import java.util.function.Supplier;

/**
 * title : 의존 객체 주입은 유연성과 테스트 용이성을 높여줌
 * 1. 의존 객체 주입 패턴은 인스턴스를 생성할때 생성자에 필요한 자원을 넘겨주는 방식
 * 2. 불변 클래스(final)를 보장하여 여러 클라이언트가 의존 객체(Lexicon)들을 안심하고 공유할 수 있음
 * 3. 의존 객체 주입은 생성자, 정적 팩토리, 빌더 모두에 똑같이 응용할 수 있음
 * 4. 팩토리란 호출 할때마다 특정 타입의 인스턴스를 반복해서 만들어주는 객체
 * 5. 클래스가 내부적으로 하나 이상의 자원에 의존하고, 그 자원이 클래스 동작에 영향을 준다면
 * 싱글턴과 정적 유틸리티 클래스는 사용하지 않는 것이 좋다.  
 */
public class SpellChecker3 {
	private final Lexicon dictionary;

	// 생성자를 이용해서 의존성 주입 수행
	public SpellChecker3(Lexicon dictionary) {
		this.dictionary = dictionary;
	}
	
	// 생성자에 자원 팩토리를 전달하여 의존 주입 수행
	// 한정적 와일드카드 타입을 사용해 팩토리의 타입 매개변수를 제한함
	// 예제의 팩토리의 타입 매개변수는 팩토리 타입이 Lexicon 또는 Lexicon의 하위 클래스만을 받음
	public SpellChecker3(Supplier<? extends Lexicon> lexiconFactory) {
		this.dictionary = lexiconFactory.get();
	}
	
	public boolean isValid(String word) {
		System.out.println("call is Valid");
		return false;
	}
	
	public List<String> suggestions(String type){
		System.out.println("call suggestions");
		return null;
	}
	
	public static void main(String[] args) {
		Lexicon koreaLexicon = new KoreanDictionary();
		Lexicon englishLexicon = new EnglishDictionary();
		String lang = "eng";
		
		SpellChecker3 sc1 = new SpellChecker3(koreaLexicon);
		SpellChecker3 sc2 = new SpellChecker3(new Supplier<Lexicon>() {
			@Override
			public Lexicon get() {
				if(lang.equals("kor")) {
					return koreaLexicon;
				}
				else {
					return englishLexicon;
				}
				
			}
		});
		SpellChecker3 sc3 = new SpellChecker3(() -> koreaLexicon);	// 람다 표현식
	
		
	}
}
