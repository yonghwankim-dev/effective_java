package role02.builder;


/**
 * 세번째 대안 : 빌더(builder) 패턴
 * 설명 : 빌더 패턴은 인자가 많은 생성자나 정적 팩터리가 필요한 클래스를 설계 시, 
 * 특히 대부분의 인자가 선택적 인자인 상황에 유용하다.
 * 		
 * 장점 : 작성이 쉬움, 가독성이 좋음.
 * 단점 : 빌더 생성 비용이 크지는 않지만 성능에 민감한 상황에서는 문제가 될 수 있음
 */
class NutritionFacts {
	private int servingSize;	
	private int servings;		
	private int calories;	
	private int fat;		
	private int sodium;		
	private int carbohydrate;

	public static class Builder{
		//필수 인자
		private int servingSize;
		private int servings;
		
		//선택적 인자 - 기본값으로 초기화
		private int calories = 0;	
		private int fat = 0;		
		private int sodium = 0;		
		private int carbohydrate = 0;
		
		public Builder(int servingSize, int servings)
		{
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val)
		{
			calories = val;
			return this;
		}
		
		public Builder fat(int val)
		{
			fat = val;
			return this;
		}
		
		public Builder sodium(int val)
		{
			sodium = val;
			return this;
		}
		
		public Builder carbohydrate(int val)
		{
			carbohydrate = val;
			return this;
		}
		
		public NutritionFacts build()
		{
			return new NutritionFacts(this); //NutritionFacts3 클래스 생성자에 builder 객체를 인자로 넣음
		}
		
	}
	
	public NutritionFacts(Builder builder)
	{
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}	
}