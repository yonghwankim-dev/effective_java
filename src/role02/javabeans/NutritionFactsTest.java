package role02.javabeans;



import org.junit.Assert;
import org.junit.Test;


class NutritionFactsTest {

	@Test
	void javaBeansPatternTest() {
		NutritionFacts nutri = new NutritionFacts();
		nutri.setServingSize(300);
		nutri.setServings(1);
		nutri.setCalories(200);
		nutri.setFat(20);
		nutri.setSodium(10);
		nutri.setCarbohydrate(5);
		
		Assert.assertEquals("NutritionFacts [servingSize=300, servings=1, calories=200, fat=20, sodium=10, carbohydrate=5]", nutri.toString());
	}

}
