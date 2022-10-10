package role18.incorrect_inheritance;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Stack;

public class StackTest {
    @Test
    public void push_add(){
        //given
        Stack<String> stack = new Stack<>();
        //when
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.add(0, "D"); // Stack의 저장순서는 FILO이기 때문에 0번째에 저장되면 스택의 개념이 망가진다.
        //then
        Assertions.assertThat(stack.toString()).isEqualTo("[D, A, B, C]");
    }
}
