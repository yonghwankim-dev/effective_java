package role10.liskov;

import java.util.Set;

import role10.Point;

public class CounterPointTest {
	private static final Set<Point> unitCircle = Set.of(
			new Point(1, 0), new Point(0, 1),
			new Point(-1, 0), new Point(0, -1));
	
	public static boolean onUnitCircle(Point p) {
		return unitCircle.contains(p);
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1, 0);
		Point p2 = new CounterPoint(1, 0);	// CounterPoint 클래스 타입
		
		System.out.println(onUnitCircle(p1));	// true
		
		// true를 출력해야 하지만, Point의 equals가
		// getClass를 사용해 작성되었다면 그렇지 않다.
		System.out.println(onUnitCircle(p2));	// false
		
		
	}

}
