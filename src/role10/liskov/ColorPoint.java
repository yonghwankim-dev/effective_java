package role10.liskov;

import role10.Color;

public class ColorPoint extends Point{
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || o.getClass() != getClass()) {
			return false;
		}
		
		return super.equals(o) && ((ColorPoint) o).color == color;
	}
	
	public static void main(String[] args) {
		
		ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
		ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);
		ColorPoint cp3 = new ColorPoint(1, 2, Color.RED);
		ColorPoint cp4 = new ColorPoint(1, 2, Color.RED);
		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(1, 2);
		
		// 대칭성 만족 확인
		System.out.println(p1.equals(p2));	// true
		System.out.println(p2.equals(p1));	// true
		
		// 추이성 만족 확인
		System.out.println(cp1.equals(cp2)); // false
		System.out.println(cp2.equals(cp3)); // false
		System.out.println(cp1.equals(cp3)); // true
		
		System.out.println(cp1.equals(cp3)); // true
		System.out.println(cp3.equals(cp4)); // true
		System.out.println(cp1.equals(cp4)); // true		
		
				
	}
	
}
