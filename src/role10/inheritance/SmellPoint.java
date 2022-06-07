package role10.inheritance;

import role10.Color;
import role10.Point;

public class SmellPoint extends Point{
	private final String smell;

	public SmellPoint(int x, int y, String smell) {
		super(x, y);
		this.smell = smell;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Point)) {
			return false;
		}
		
		if(!(o instanceof SmellPoint)) {
			return o.equals(this);
		}
		
		return super.equals(o) && ((SmellPoint) o).smell.equals(smell);
	}
	
	public static void main(String[] args) {
		ColorPoint myColorPoint = new ColorPoint(1, 2, Color.RED);
		SmellPoint mySmellPoint = new SmellPoint(1, 2, "a");
		
		// stackoverflowError 발생
		// ColorPoint <-> SmellPoint equals 메서드를 무한순환함
		System.out.println(myColorPoint.equals(mySmellPoint));
		
	}
}
