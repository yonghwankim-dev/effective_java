package role2;
/**
 * 규칙02 생성자 인자가 많을때는 Builder 패턴 적용을 고려하라.
 * 첫번째 대안 : 점층적 생성자 패턴(telescoping constructor pattern)
 * 설명 : 아래와 같이 servingsSize와 servings 필드를 제외한 나머지 필드는 선택적인 필드이다. 
 * 		다음과 같이 선택인자가 많은 상황에서는 점층적 생성자 패턴(telescoping constructor pattern)을 적용한다.
 * 		선택적 인자를 계속 추가하여 호출하는 패턴이다.
 * 
 * 문제점
 * => 필드수가 늘어나면 늘어날수록 클라이언트 코드를 작성하기 어려워지고 가독성이 저해됨
 * => 생성자 인자로 들어가는 값이 어떤 값인지 알 수 없게됨
 * => 두 개의 인자의 순서를 바꾸어도 컴파일러는 경고를 줄 수 없고 프로그램 실행중에 문제가 생기게됨
 */
public class NutritionFacts {
	private int servingSize;		// (mL)					필수
	private int servings;			// (per container)		필수
	private int calories;			//						선택
	private int fat;				// (g)					선택
	private int sodium;				// (mg)					선택
	private int carbohydrate;		// (g)					선택
	
	public NutritionFacts(int servingSize, int servings)
	{
		this(servingSize, servings, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories)
	{
		this(servingSize, servings, calories, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories,
							int fat)
	{
		this(servingSize, servings, calories, fat, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories,
							int fat, int sodium)
	{
		this(servingSize, servings, calories, fat, sodium, 0);
	}
	
	public NutritionFacts(int servingSize, int servings, int calories,
			int fat, int sodium, int carbohydrate)
	{
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}
}
/**
 * 두번째 대안 : 자바빈 패턴
 * 설명 : 인자 없는 생성자를 호출하여 객체부터 만든 다음, 설정 메서드(setter methods)들을 호출하여 필수 필드 뿐만 아니라 선택적 필드의 값들까지
 * 		채누는 것
 * 
 * 장점 : 객체 생성 쉬움, 가독성 좋음(해당 인자가 어떤 필드값인지 인지 가능), 필드의 양이 늘어나도 문제없음
 * 
 * 문제점 : 1회의 함수 호출로 객체 생성을 끝낼 수 없으므로, 객체 일관성(consistency)이 일시적으로 깨질수 있음.
 * 		자바빈 패턴으로는 변경 불가능(immutable) 클래스를 생성할 수 없음.
 */
class NutritionFacts2 {
	private int servingSize = -1;	// 필수: 기본값 없음
	private int servings = -1;		// 필수: 기본값 없음
	private int calories = 0;	
	private int fat = 0;		
	private int sodium = 0;		
	private int carbohydrate = 0;
	
	
	public NutritionFacts2() {
		// TODO Auto-generated constructor stub
	}
	
	// 설정자(Setter)
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	
	
}
/**
 * 두번째 대안 : 빌더(builder) 패턴
 * 설명 : 빌더 패턴은 인자가 많은 생성자나 정적 팩터리가 필요한 클래스를 설계 시, 특히 대부분의 인자가 선택적 인자인 상황에 유용하다.
 * 		
 * 장점 : 작성이 쉬움, 가독성이 좋음.
 */
class NutritionFacts3 {
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
		
		public NutritionFacts3 build()
		{
			return new NutritionFacts3(this); //NutritionFacts3 클래스 생성자에 builder 객체를 인자로 넣음
		}
		
	}
	
	public NutritionFacts3(Builder builder)
	{
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
}

class Main{
	public static void main(String args[])
	{
		/**
		 * 첫번재 대안 호출
		 * 객체 생성시 인자 개수에 맞는 생성자를 골라 호출하면 된다. 
		 */
		NutritionFacts cocaCola1 = new NutritionFacts(240, 8, 100, 3, 35, 27);
		
		/**
		 * 두번째 대안 호출
		 */
		NutritionFacts2 cocaCola2 = new NutritionFacts2();
		cocaCola2.setServingSize(240);
		cocaCola2.setServings(8);
		cocaCola2.setCalories(100);
		cocaCola2.setSodium(35);
		cocaCola2.setCarbohydrate(22);
		
		/**
		 * 세번째 대안 호출
		 */
		NutritionFacts3 cocaCola3 = new NutritionFacts3.Builder(240, 8)
										.calories(100).sodium(35).carbohydrate(27)
										.build();
		
	}
}
