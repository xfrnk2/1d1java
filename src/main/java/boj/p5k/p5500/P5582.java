package boj.p5k.p5500;

import java.util.Arrays;
import java.util.Scanner;

public class P5582 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = " " + sc.nextLine();
		String str2 = " " + sc.nextLine();
		int str1Len = str1.length();
		int str2Len = str2.length();

		int[][] dp = new int[str1Len + 1][str2Len + 1];
		int ans = 0;
		for (int i = 1; i < str1Len; i++) {
			for (int j = 1; j < str2Len; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					ans = Math.max(dp[i][j], ans);
				}
			}
		}
		System.out.println(ans);
	}

}
