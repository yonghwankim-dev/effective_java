package role3.staticfactory;


// �ڵ� 3-2 : ���� ���丮�� �̿��� �̱��� 
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