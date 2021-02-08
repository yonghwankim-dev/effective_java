package role3;

// public final 필드를 이용한 싱글턴 객체 생성
public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	private Elvis()
	{
		//...
	}
		
	public void leaveTheBuilding()
	{
		//...
	}
	
	
}

// 정적 팩토리를 이용한 싱글턴
class Elvis2{
	private static final Elvis2 INSTANCE = new Elvis2();
	private Elvis2()
	{
		//...
	}
	
	public static Elvis2 getInstance()
	{
		return INSTANCE;
	}
		
	public void leaveTheBuilding()
	{
		//...
	}
	
	public enum Elvis3{
		INSTANCE;
		public void leaveTheBuilding()
		{
			//...
		}
	}
}

