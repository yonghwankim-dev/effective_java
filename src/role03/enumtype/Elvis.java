package role03.enumtype;

//코드 3-3 : 열거 타입 방식의 싱글턴
public enum Elvis{
	INSTANCE;
	
	public void leaveTheBuilding()
	{
		System.out.println("call leaveTheBuilding");
	}
}
