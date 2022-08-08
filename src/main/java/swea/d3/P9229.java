package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P9229 {
	static int N, M, R = 2;
	static int answer;
	static int[] snackWeightArr;
	static int[] pair;
	private static void combination(int cnt, int r) {
		if (r == 0) {
			int result = pair[0] + pair[1];
			if (result > M)	return;
			answer = Math.max(answer, result);return; }
		if (cnt < r) return;
		pair[r - 1] = snackWeightArr[cnt - 1];
		combination(cnt - 1, r - 1); // 원소 선택한 경우
		combination(cnt - 1, r); // 원소 선택하지 않은 경우
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			pair = new int[R];
			snackWeightArr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snackWeightArr[i] = Integer.parseInt(st.nextToken());
			}
			combination(N, R);
			System.out.printf("#%d %d%n", tc, answer == 0 ? -1 : answer);
		}
	}
}