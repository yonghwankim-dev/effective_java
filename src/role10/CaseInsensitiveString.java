package role10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 코드 10-1 잘못된 코드 - 대칭성 위배 (54-55p)
public class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		this.s = Objects.requireNonNull(s);
	}

	// 대칭성 위배
	@Override
	public boolean equals(Object o) {
		if(o instanceof CaseInsensitiveString) {
			return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
		}
		if(o instanceof String) {	// 한방향으로만 작동함
			return s.equalsIgnoreCase((String) o);
		}
		return false;
	}
	
	// 문제 시연 (55p)	
	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        
        System.out.println("cis.equals(s) : " + cis.equals(s));	// true
        System.out.println("s.equals(cis) : " + s.equals(cis)); // false
        
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println("list.contains(s) : " + list.contains(s)); // false
	}
	
	// 수정한 equals 메서드 (56p)
//	@Override
//	public boolean equals(Object o) {
//		return o instanceof CaseInsensitiveString 
//				&& ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
//	}	
}
