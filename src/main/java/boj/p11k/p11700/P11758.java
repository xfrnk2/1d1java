package boj.p11k.p11700;

import java.awt.Point;
import java.util.Scanner;

public class P11758 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point p1 = new Point(sc.nextInt(), sc.nextInt());
		Point p2 = new Point(sc.nextInt(), sc.nextInt());
		Point p3 = new Point(sc.nextInt(), sc.nextInt());
		
		int ccw = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
		System.out.println(ccw < 0 ? -1 : ccw > 0 ? 1 : 0);
		// https://degurii.tistory.com/47
	}

}
