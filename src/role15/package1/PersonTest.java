package role15.package1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class PersonTest {
    @Test(expected = UnsupportedOperationException.class)
    public void 배열수정방지방법1() throws Exception{

        //when
        Person.VALUES.set(0,2);
        //then
        fail("리스트의 요소가 수정되면 안됩니다.");
    }

    @Test
    public void 배열수정방지방법2() throws Exception{
        //given
        int[] values = Person.values();

        //when
        values[0] = 2;

        //then
        assertThat(values).isEqualTo(new int[]{2,2,3});

    }
}
