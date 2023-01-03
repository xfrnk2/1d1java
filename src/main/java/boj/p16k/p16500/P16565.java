package boj.p16k.p16500;

import java.util.Scanner;

public class P16565 {
	static int MOD = 10007;

	public static void main(String[] args) {

		/*
		 *
		 * 2018 Sogang Programming Contest - Master
		 * 포카드를 i개 생성 : 13Ci, n장을 뽑을때, 4i개의 카드를
		 * 뽑은 상태에서 52-4iCn-4i개의 카드를 뽑는다. 13Ci * 52-4iCn-4i 를 구한 뒤, 중복되는 값을 뺴준다. 포함 배제의
		 * 원리의 집합의 경우에서 착안하여 이니..
		 */

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] comb = new int[53][53];
		comb[0][0] = comb[1][0] = comb[1][1] = 1;
		for (int i = 2; i < 53; i++) {
			comb[i][0] = 1;
			comb[i][i] = 1;
			for (int j = 1; j < i; j++) {
				comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;

			}

		}
		int ans = 0;
		for (int i = 4; i <= N; i += 4) {
			ans = (ans + ((i / 4) % 2 == 1 ? 1 : -1) * (comb[13][i / 4] * comb[52 - i][N - i]) % MOD) % MOD;
		}

		System.out.println(ans < 0 ? ans + MOD : ans);

	}

}
