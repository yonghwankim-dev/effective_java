package role05;

import java.util.List;
import java.util.function.Supplier;

/**
 * title : ���� ��ü ������ �������� �׽�Ʈ ���̼��� ������
 * 1. ���� ��ü ���� ������ �ν��Ͻ��� �����Ҷ� �����ڿ� �ʿ��� �ڿ��� �Ѱ��ִ� ���
 * 2. �Һ� Ŭ����(final)�� �����Ͽ� ���� Ŭ���̾�Ʈ�� ���� ��ü(Lexicon)���� �Ƚ��ϰ� ������ �� ����
 * 3. ���� ��ü ������ ������, ���� ���丮, ���� ��ο� �Ȱ��� ������ �� ����
 * 4. ���丮�� ȣ�� �Ҷ����� Ư�� Ÿ���� �ν��Ͻ��� �ݺ��ؼ� ������ִ� ��ü
 * 5. Ŭ������ ���������� �ϳ� �̻��� �ڿ��� �����ϰ�, �� �ڿ��� Ŭ���� ���ۿ� ������ �شٸ�
 * �̱��ϰ� ���� ��ƿ��Ƽ Ŭ������ ������� �ʴ� ���� ����.  
 */
public class SpellChecker3 {
	private final Lexicon dictionary;

	// �����ڸ� �̿��ؼ� ������ ���� ����
	public SpellChecker3(Lexicon dictionary) {
		this.dictionary = dictionary;
	}
	
	// �����ڿ� �ڿ� ���丮�� �����Ͽ� ���� ���� ����
	// ������ ���ϵ�ī�� Ÿ���� ����� ���丮�� Ÿ�� �Ű������� ������
	// ������ ���丮�� Ÿ�� �Ű������� ���丮 Ÿ���� Lexicon �Ǵ� Lexicon�� ���� Ŭ�������� ����
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
		SpellChecker3 sc3 = new SpellChecker3(() -> koreaLexicon);	// ���� ǥ����
	
		
	}
}
