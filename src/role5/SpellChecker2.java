package role5;

import java.util.List;

/**
 * title : �̱����� �߸� ����� �� - �������� �ʰ� �׽�Ʈ�ϱ� �����
 * 1. ������ ���� ���� �ְ� Ư�� ���ֿ� ������ ������ �δ� ��쵵 ����
 * 2. ���� �ϳ��� ��� ���ӿ� ������ ���� ����
 * 3. �ʵ忡�� final �����ڸ� �����ϰ� �ٸ� �������� ��ü�ϴ� �޼��带 ��ü�� �� ������
 * �� ����� ������ ���� ����� ��Ƽ������ ȯ�濡���� ����� �� ����
 * 4. ����ϴ� �ڿ��� ���� ������ �޶����� Ŭ�������� ���� ��ƿ��Ƽ Ŭ������ �������� ����  
 */
public class SpellChecker2 {
	private final Lexicon dictionary = new Lexicon();
	public static SpellChecker2 INSTANCE = new SpellChecker2();
	
	// ��ü ���� ����
	private SpellChecker2() {
		
	}
	
	public boolean isValid(String word) {
		return false;
	}
	
	public List<String> suggestions(String type){
		return null;
	}
	
	public static void main(String[] args) {
		SpellChecker2 spellChecker2 = SpellChecker2.INSTANCE;
		spellChecker2.isValid("test");
	}
}
