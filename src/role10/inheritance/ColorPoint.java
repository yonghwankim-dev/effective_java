package role10.inheritance;


import role10.Color;
import role10.Point;

// Point�� �� ������Ʈ(color) �߰� (56p)
public class ColorPoint extends Point{
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	// �ڵ� 10-2 �߸��� �ڵ� - ��Ī�� ���� (57p)
//	@Override
//	public boolean equals(Object o) {
//		
//		if(!(o instanceof ColorPoint)) {
//			return false;
//		}
//		
//		return super.equals(o) && ((ColorPoint) o).color == color;
//	}
	
	// �ڵ� 10-3 �߸��� �ڵ� : ���̼� ���� (57p)
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Point)) {
			return false;
		}
		
		// o�� �Ϲ� Point�̸� ������ �����ϰ� ��
		if(!(o instanceof ColorPoint)) {
			return o.equals(this);
		}
	
		// o�� ColorPoint�̸� ������� ���Ѵ�
		return super.equals(o) && ((ColorPoint) o).color == color;
	}
	
	public static void main(String[] args) {
		// �� ColorPoint �ν��Ͻ��� ��
		ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
		ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);
		
		// ColorPoint equals�� ���������� ������ true
		// Point.equals �����
		System.out.println(cp1.equals(cp2));  
		
		// ù��° equals �޼���(�ڵ� 10-2)�� ��Ī���� �����Ѵ�
		Point p = new Point(1, 2);
		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
		
		System.out.println("p.equals(cp) : " + p.equals(cp));	// true
		System.out.println("cp.equals(p) : " + cp.equals(p));	// false
		
		// �ι�° equals �޼���(�ڵ� 10-3)�� ���̼��� �����Ѵ�
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));	// true
		System.out.println("p2.equals(p3) : " + p2.equals(p3));  // true
		System.out.println("p1.equals(p3) : " + p1.equals(p3));  // false
		
		
	}
	
}
