package role18.incorrect_design;


import org.assertj.core.api.Assertions;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InstrumentedHashSetTest {
    // HashSet�� addAll ȣ��� add �޼��带 ���ؼ� ȣ���ϱ� ������ ���� �ϳ��� 2�� �þ�Ե�
    @Test
    public void addAll(){
        //given
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        //when
        s.addAll(List.of("ƽ", "ŹŹ", "��"));
        int actual = s.getAddCount();
        //then
        System.out.println(actual);
    }
}