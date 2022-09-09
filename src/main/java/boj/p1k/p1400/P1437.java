package boj.p1k.p1400;


import java.util.Scanner;

public class P1437 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		search(N);

	}

	public static void search(int n) {
		if (n < 5) {
			System.out.print(n);
			return;
		}

		int[] D = new int[1000001];
		for (int i = 1; i < 5; i++) {
			D[i] = i;
		}

		for (int i = 5; i <= n; i++) {
			D[i] = (D[i - 3] * 3) % 10007;
		}
		System.out.print(D[n]);

	}

}
