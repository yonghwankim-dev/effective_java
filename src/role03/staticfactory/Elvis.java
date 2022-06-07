package role03.staticfactory;


// 코드 3-2 : 정적 팩토리를 이용한 싱글턴 
public class Elvis{
	private static final Elvis INSTANCE = new Elvis();
	private Elvis()
	{
		
	}
	
	public static Elvis getInstance()
	{
		return INSTANCE;
	}
		
	public void leaveTheBuilding()
	{
		System.out.println("call leaveTheBuilding");
	}
}
