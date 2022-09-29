package role02.hierarchicalbuilder;

import org.junit.Test;

import static role02.hierarchicalbuilder.NyPizza.Size.*;
import static role02.hierarchicalbuilder.Pizza.Topping.*;



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
