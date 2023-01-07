package boj.p20k.p20500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20543 {
	static int N, M;
	static long[][] map;
	static long[][] prefixSum, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new long[N + 2][N + 2];
		prefixSum = new long[N + 2][N + 2];
		ans = new long[N + 1001][N + 1001];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = -1 * Long.valueOf(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		if (M == 1) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
				int nx = i - M < 0 ? 0 : i - M;
				int ny = j - M < 0 ? 0 : j - M;
				long sum = prefixSum[i][j] - prefixSum[i][ny] - prefixSum[nx][j] + prefixSum[nx][ny];
				long difference = map[i][j] - sum;
				if (difference > 0) { // M칸만큼의 사각형 내부의 합이 현재 위치의 높이의 절댓값보다 작으면
					// 폭탄이 위치할 수 있다. ( greedy )
					prefixSum[i][j] += difference;
					ans[i + M / 2][j + M / 2] += difference;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(ans[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
