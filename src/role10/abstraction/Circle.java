package role10.abstraction;

import java.util.HashSet;
import java.util.Set;

import role10.Point;

public class Circle extends Shape{			
	private static final double PI = 3.14;
	private final int r;
	
	public Circle(int r) {
		this.r = r;
	}
	
	@Override
	public double getArea() {
		return PI * r * r;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle) {
			Circle c = (Circle) o;
			return c.r == r;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Shape s1 = new Circle(5);
		Shape s2 = new Circle(5);
		Shape s3 = new Circle(5);
		
		// 대칭성 만족
		System.out.println(s1.equals(s2));	// true
		System.out.println(s2.equals(s1));  // true
		
		// 추이성 만족
		System.out.println(s1.equals(s2));  // true
		System.out.println(s2.equals(s3));  // true
		System.out.println(s1.equals(s3));  // true
	}
}
