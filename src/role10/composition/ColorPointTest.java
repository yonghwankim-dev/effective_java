package role10.composition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import role10.Color;
import role10.Point;


class ColorPointTest {

	@Test
	void test() {
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));			  // false
		System.out.println("p2.equals(p1) : " + p2.equals(p1)); 		  // false
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));			   // false
		System.out.println("p2.equals(p3) : " + p2.equals(p3));  		   // false
		System.out.println("p1.equals(p3) : " + p1.equals(p3));            // false
	}
}
