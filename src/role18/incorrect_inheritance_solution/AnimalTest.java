package role18.incorrect_inheritance_solution;


import org.junit.Test;

public class AnimalTest {
    @Test
    public void move(){
        Animal snake = new Reptile("¹ì");

        snake.move();
    }
}