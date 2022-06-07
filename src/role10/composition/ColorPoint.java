package role10.composition;

import java.util.Objects;

import role10.Color;
import role10.Point;

// 코드 10-5 equals 규약을 지키면서 값 추가하기 (60p)
public class ColorPoint {
	private final Point point;
	private final Color color;
	
	public ColorPoint(int x, int y, Color color) {
		point = new Point(x, y);
		this.color = Objects.requireNonNull(color);
	}
	
	// 이 ColorPoint의 Point 뷰를 반환한다.
	public Point asPoint() {
		return point;
	}

	@Override
	public boolean equals(Object o) {		
		if(o instanceof ColorPoint) {
			ColorPoint cp = (ColorPoint) o;
			return cp.point.equals(point) && cp.color.equals(color);
		}
		return false;
	}
}
