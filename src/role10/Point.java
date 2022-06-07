package role10;

public class Point {
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Point) {
			Point p = (Point) o;
			return this.x == p.x && this.y == p.y;
		}
		return false;
	}
}
