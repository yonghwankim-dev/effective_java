package role10.liskov;

public class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		// o�� null�̰ų� o�� Point Ŭ���� ��ü�� �ƴ� ���
		if(o == null || o.getClass() != getClass()) {
			return false;
		}
		Point p = (Point) o;
		return this.x == p.x && this.y == p.y;
	}
}
