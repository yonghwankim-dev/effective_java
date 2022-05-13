package role2.telescopingconstructor;

/**
 * 규칙02 생성자 인자가 많을때는 Builder 패턴 적용을 고려하라.
 * 
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
	private int calories;			// (cal)				선택
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

	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}
}
