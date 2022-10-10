package role18.incorrect_inheritance;

import org.junit.Test;

public class CarTest {
    @Test
    public void move(){
        Car car1 = new Car();
        Car car2 = new Avante();

        car1.move();
        car2.move(); // car2.move()는 Avante.move()를 가리킴으로써 하위 클래스(Avante)를 노출시킴
    }

}