package boj.p11k.p11500;


import java.util.Scanner;

public class P11539 {

	public static void main(String[] args) {		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();

		}
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == T) {

				cnt++;

			}

		}

		System.out.println(cnt);

	}

}
