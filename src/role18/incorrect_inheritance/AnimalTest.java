package role18.incorrect_inheritance;


import org.junit.Test;

public class AnimalTest {
    @Test
    public void move(){
        Animal snake = new Reptile("��");

        snake.move(); // Expected Output : �ٸ��� �̿��Ͽ� �̵��Ѵ�
    }
}