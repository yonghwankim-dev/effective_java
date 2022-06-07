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
		// o가 null이거나 o가 Point 클래스 자체가 아닌 경우
		if(o == null || o.getClass() != getClass()) {
			return false;
		}
		Point p = (Point) o;
		return this.x == p.x && this.y == p.y;
	}
}
