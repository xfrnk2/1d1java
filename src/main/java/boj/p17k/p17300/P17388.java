package boj.p17k.P17300;


import java.util.Scanner;

public class P17388 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if (100 <= (a + b + c)) {
			System.out.println("OK");
		} else {
			System.out.println(a < b && a < c ? "Soongsil" : b < a && b < c ? "Korea" : "Hanyang"

			);

		}

	}

}
