package role10.inheritance;


import role10.Color;
import role10.Point;

// Point에 값 컴포넌트(color) 추가 (56p)
public class ColorPoint extends Point{
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	// 코드 10-2 잘못된 코드 - 대칭성 위배 (57p)
//	@Override
//	public boolean equals(Object o) {
//		
//		if(!(o instanceof ColorPoint)) {
//			return false;
//		}
//		
//		return super.equals(o) && ((ColorPoint) o).color == color;
//	}
	
	// 코드 10-3 잘못된 코드 : 추이성 위배 (57p)
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Point)) {
			return false;
		}
		
		// o가 일반 Point이면 색상을 무시하고 비교
		if(!(o instanceof ColorPoint)) {
			return o.equals(this);
		}
	
		// o가 ColorPoint이면 색상까지 비교한다
		return super.equals(o) && ((ColorPoint) o).color == color;
	}
	
	public static void main(String[] args) {
		// 두 ColorPoint 인스턴스의 비교
		ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
		ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);
		
		// ColorPoint equals를 재정의하지 않으면 true
		// Point.equals 수행됨
		System.out.println(cp1.equals(cp2));  
		
		// 첫번째 equals 메서드(코드 10-2)는 대칭성을 위배한다
		Point p = new Point(1, 2);
		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
		
		System.out.println("p.equals(cp) : " + p.equals(cp));	// true
		System.out.println("cp.equals(p) : " + cp.equals(p));	// false
		
		// 두번째 equals 메서드(코드 10-3)는 추이성을 위배한다
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));	// true
		System.out.println("p2.equals(p3) : " + p2.equals(p3));  // true
		System.out.println("p1.equals(p3) : " + p1.equals(p3));  // false
		
		
	}
	
}
