package role15.package1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class PersonTest {
    @Test(expected = UnsupportedOperationException.class)
    public void �迭�����������1() throws Exception{

        //when
        Person.VALUES.set(0,2);
        //then
        fail("����Ʈ�� ��Ұ� �����Ǹ� �ȵ˴ϴ�.");
    }

    @Test
    public void �迭�����������2() throws Exception{
        //given
        int[] values = Person.values();

        //when
        values[0] = 2;

        //then
        assertThat(values).isEqualTo(new int[]{2,2,3});

    }
}
