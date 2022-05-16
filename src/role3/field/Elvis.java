package role3.field;

// 코드 3-1 : public static final 필드를 이용한 싱글턴 객체 생성
public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	private Elvis(){}
		
	public void leaveTheBuilding()
	{
		System.out.println("call leaveTheBuilding");
	}
}



