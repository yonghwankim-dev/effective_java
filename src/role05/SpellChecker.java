package role05;

import java.util.List;

/**
 * title : ���� ��ƿ��Ƽ�� �߸� ����� �� - �������� �ʰ� �׽�Ʈ�ϱⰡ �����
 * 1. ������ ���� ���� �ְ� Ư�� ���ֿ� ������ ������ �δ� ��쵵 ����
 * 2. ���� �ϳ��� ��� ���ӿ� ������ ���� ����
 * 3. �ʵ忡�� final �����ڸ� �����ϰ� �ٸ� �������� ��ü�ϴ� �޼��带 ��ü�� �� ������
 * �� ����� ������ ���� ����� ��Ƽ������ ȯ�濡���� ����� �� ����
 * 4. ����ϴ� �ڿ��� ���� ������ �޶����� Ŭ�������� ���� ��ƿ��Ƽ Ŭ������ �������� ����  
 */
public class SpellChecker {
	private static final Lexicon dictionary = new Lexicon();
	
	// ��ü ���� ����
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
