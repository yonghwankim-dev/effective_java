package role18.incorrect_inheritance_solution;

import org.junit.Test;

public class CarTest {
    @Test
    public void move(){
        Car car1 = new Car();
        Car car2 = new Avante();

        car1.move();
        car2.move();
    }

}