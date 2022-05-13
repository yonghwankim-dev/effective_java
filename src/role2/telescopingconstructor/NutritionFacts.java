package role2.telescopingconstructor;

/**
 * ��Ģ02 ������ ���ڰ� �������� Builder ���� ������ ����϶�.
 * 
 * ù��° ��� : ������ ������ ����(telescoping constructor pattern)
 * ���� : �Ʒ��� ���� servingsSize�� servings �ʵ带 ������ ������ �ʵ�� �������� �ʵ��̴�. 
 * 		������ ���� �������ڰ� ���� ��Ȳ������ ������ ������ ����(telescoping constructor pattern)�� �����Ѵ�.
 * 		������ ���ڸ� ��� �߰��Ͽ� ȣ���ϴ� �����̴�.
 * 
 * ������
 * => �ʵ���� �þ�� �þ���� Ŭ���̾�Ʈ �ڵ带 �ۼ��ϱ� ��������� �������� ���ص�
 * => ������ ���ڷ� ���� ���� � ������ �� �� ���Ե�
 * => �� ���� ������ ������ �ٲپ �����Ϸ��� ��� �� �� ���� ���α׷� �����߿� ������ ����Ե�
 */
public class NutritionFacts {
	private int servingSize;		// (mL)					�ʼ�
	private int servings;			// (per container)		�ʼ�
	private int calories;			// (cal)				����
	private int fat;				// (g)					����
	private int sodium;				// (mg)					����
	private int carbohydrate;		// (g)					����
	
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
