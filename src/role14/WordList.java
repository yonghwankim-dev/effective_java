package role14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {
	/**
	 * title : String Comparable
	 * String 클래스가 Comparable 인터페이스를 구현한 덕분에
	 * 컬렉션에 넣고 출력할때 알파벳순으로 출력합니다.
	 */
	public static void main(String[] args) {
		String[] words = {"apple", "banana", "strawberry", "durian", "lemon"};
		Set<String> s = new TreeSet<String>();
		Collections.addAll(s, words);
		System.out.println(s); // [apple, banana, durian, lemon, strawberry]	
	}
}
