package role10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// �ڵ� 10-1 �߸��� �ڵ� - ��Ī�� ���� (54-55p)
public class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		this.s = Objects.requireNonNull(s);
	}

	// ��Ī�� ����
	@Override
	public boolean equals(Object o) {
		if(o instanceof CaseInsensitiveString) {
			return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
		}
		if(o instanceof String) {	// �ѹ������θ� �۵���
			return s.equalsIgnoreCase((String) o);
		}
		return false;
	}
	
	// ���� �ÿ� (55p)	
	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        
        System.out.println("cis.equals(s) : " + cis.equals(s));	// true
        System.out.println("s.equals(cis) : " + s.equals(cis)); // false
        
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println("list.contains(s) : " + list.contains(s)); // false
	}
	
	// ������ equals �޼��� (56p)
//	@Override
//	public boolean equals(Object o) {
//		return o instanceof CaseInsensitiveString 
//				&& ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
//	}	
}
