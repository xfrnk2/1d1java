package jungol.p1k;

import java.util.Scanner;

public class P1411 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n + 1];
		d[1] = 1;
		d[2] = 3;

		
		for (int i = 3; i <= n; i++) {
			d[i] = (d[i-1] + d[i-2] * 2) % 20100529;
		}
		System.out.println(d[n]);
	}

}
