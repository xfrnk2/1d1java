package boj.p14k.p14400;


import java.util.Scanner;

public class P14489 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (A + B >= (2 * C)) {
			System.out.println((A + B) - (2 * C));
		} else {
			System.out.println(A + B);
		}
	}

}
