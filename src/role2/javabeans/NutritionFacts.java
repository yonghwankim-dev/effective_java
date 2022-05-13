package role2.javabeans;

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
class NutritionFacts {
	private int servingSize = -1;	// 필수: 기본값 없음
	private int servings = -1;		// 필수: 기본값 없음
	private int calories = 0;	
	private int fat = 0;		
	private int sodium = 0;		
	private int carbohydrate = 0;
	
	
	public NutritionFacts() {
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

	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}
}
