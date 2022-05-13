package role2.javabeans;

/**
 * �ι�° ��� : �ڹٺ� ����
 * ���� : ���� ���� �����ڸ� ȣ���Ͽ� ��ü���� ���� ����, ���� �޼���(setter methods)���� ȣ���Ͽ� �ʼ� �ʵ� �Ӹ� �ƴ϶� ������ �ʵ��� �������
 * 		ä���� ��
 * 
 * ���� : ��ü ���� ����, ������ ����(�ش� ���ڰ� � �ʵ尪���� ���� ����), �ʵ��� ���� �þ�� ��������
 * 
 * ������ : 1ȸ�� �Լ� ȣ��� ��ü ������ ���� �� �����Ƿ�, ��ü �ϰ���(consistency)�� �Ͻ������� ������ ����.
 * 		�ڹٺ� �������δ� ���� �Ұ���(immutable) Ŭ������ ������ �� ����.
 */
class NutritionFacts {
	private int servingSize = -1;	// �ʼ�: �⺻�� ����
	private int servings = -1;		// �ʼ�: �⺻�� ����
	private int calories = 0;	
	private int fat = 0;		
	private int sodium = 0;		
	private int carbohydrate = 0;
	
	
	public NutritionFacts() {
	}
	
	// ������(Setter)
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

	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}
}
