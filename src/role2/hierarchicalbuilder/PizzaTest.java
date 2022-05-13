package role2.hierarchicalbuilder;

import org.junit.jupiter.api.Test;

import static role2.hierarchicalbuilder.Pizza.Topping.*;
import static role2.hierarchicalbuilder.NyPizza.Size.*;

class PizzaTest {

	@Test
	void pizzaTest() {
		NyPizza nyPizza = new NyPizza.Builder(SMALL)
									 .addTopping(SAUSAGE)
									 .addTopping(ONION)
									 .build();
		
		Calzone calzone = new Calzone.Builder()
									 .addTopping(HAM)
									 .sauceInside()
									 .build();

		System.out.println(nyPizza);
		System.out.println(calzone);
		
	}

}
