package role10.composition;

import java.util.Objects;

import role10.Color;
import role10.Point;

// �ڵ� 10-5 equals �Ծ��� ��Ű�鼭 �� �߰��ϱ� (60p)
public class ColorPoint {
	private final Point point;
	private final Color color;
	
	public ColorPoint(int x, int y, Color color) {
		point = new Point(x, y);
		this.color = Objects.requireNonNull(color);
	}
	
	// �� ColorPoint�� Point �並 ��ȯ�Ѵ�.
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
