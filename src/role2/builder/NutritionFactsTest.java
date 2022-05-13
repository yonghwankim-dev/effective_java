package role2.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class NutritionFactsTest {

	@Test
	void builderPatternTest() {
		NutritionFacts nutri = new NutritionFacts.Builder(300, 1)
												   .calories(200)
												   .fat(20)
												   .sodium(10)
												   .carbohydrate(5)
												   .build();
		
		Assert.assertEquals("NutritionFacts [servingSize=300, servings=1, calories=200, fat=20, sodium=10, carbohydrate=5]", nutri.toString());
	}
}
