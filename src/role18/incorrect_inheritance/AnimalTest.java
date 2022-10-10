package role18.incorrect_inheritance;


import org.junit.Test;

public class AnimalTest {
    @Test
    public void move(){
        Animal snake = new Reptile("뱀");

        snake.move(); // Expected Output : 다리를 이용하여 이동한다
    }
}