package role02.telescopingconstructor;

import org.junit.Assert;
import org.junit.Test;


public class NutritionFactsTest {

	@Test
	void telescopingConstructorPatternTest() {
		NutritionFacts nutri1 = new NutritionFacts(300, 1);
		NutritionFacts nutri2 = new NutritionFacts(300, 1, 200);
		NutritionFacts nutri3 = new NutritionFacts(300, 1, 200, 20);
		NutritionFacts nutri4 = new NutritionFacts(300, 1, 200, 20, 10);
		NutritionFacts nutri5 = new NutritionFacts(300, 1, 200, 20, 10, 5);
		
		Assert.assertEquals("NutritionFacts [servingSize=300, servings=1, calories=0, fat=0, sodium=0, carbohydrate=0]", nutri1.toString());
		Assert.assertEquals("NutritionFacts [servingSize=300, servings=1, calories=200, fat=0, sodium=0, carbohydrate=0]", nutri2.toString());
		Assert.assertEquals("NutritionFacts [servingSize=300, servings=1, calories=200, fat=20, sodium=0, carbohydrate=0]", nutri3.toString());
		Assert.assertEquals("NutritionFacts [servingSize=300, servings=1, calories=200, fat=20, sodium=10, carbohydrate=0]", nutri4.toString());
		Assert.assertEquals("NutritionFacts [servingSize=300, servings=1, calories=200, fat=20, sodium=10, carbohydrate=5]", nutri5.toString());
	}

}
