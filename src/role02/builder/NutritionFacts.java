package role02.builder;


/**
 * ����° ��� : ����(builder) ����
 * ���� : ���� ������ ���ڰ� ���� �����ڳ� ���� ���͸��� �ʿ��� Ŭ������ ���� ��, 
 * Ư�� ��κ��� ���ڰ� ������ ������ ��Ȳ�� �����ϴ�.
 * 		
 * ���� : �ۼ��� ����, �������� ����.
 * ���� : ���� ���� ����� ũ���� ������ ���ɿ� �ΰ��� ��Ȳ������ ������ �� �� ����
 */
class NutritionFacts {
	private int servingSize;	
	private int servings;		
	private int calories;	
	private int fat;		
	private int sodium;		
	private int carbohydrate;

	public static class Builder{
		//�ʼ� ����
		private int servingSize;
		private int servings;
		
		//������ ���� - �⺻������ �ʱ�ȭ
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
			return new NutritionFacts(this); //NutritionFacts3 Ŭ���� �����ڿ� builder ��ü�� ���ڷ� ����
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