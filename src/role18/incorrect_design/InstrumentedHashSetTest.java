package role18.incorrect_design;


import org.assertj.core.api.Assertions;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InstrumentedHashSetTest {
    // HashSet의 addAll 호출시 add 메서드를 통해서 호출하기 때문에 원소 하나당 2씩 늘어나게됨
    @Test
    public void addAll(){
        //given
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        //when
        s.addAll(List.of("틱", "탁탁", "펑"));
        int actual = s.getAddCount();
        //then
        System.out.println(actual);
    }
}