package role3.field;

// �ڵ� 3-1 : public static final �ʵ带 �̿��� �̱��� ��ü ����
public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	private Elvis(){}
		
	public void leaveTheBuilding()
	{
		System.out.println("call leaveTheBuilding");
	}
}



