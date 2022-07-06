package role14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {
	/**
	 * title : String Comparable
	 * String Ŭ������ Comparable �������̽��� ������ ���п�
	 * �÷��ǿ� �ְ� ����Ҷ� ���ĺ������� ����մϴ�.
	 */
	public static void main(String[] args) {
		String[] words = {"apple", "banana", "strawberry", "durian", "lemon"};
		Set<String> s = new TreeSet<String>();
		Collections.addAll(s, words);
		System.out.println(s); // [apple, banana, durian, lemon, strawberry]	
	}
}
