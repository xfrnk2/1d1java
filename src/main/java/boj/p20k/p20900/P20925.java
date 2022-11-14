package boj.p20k.p20900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P20925 {
	static int N, T;
	static int[][] timeGraph;
	static int[][] info;

	static int[][] d; // 사냥터 수와 분 단위, 냅색 형태로, 최대 경험치

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		timeGraph = new int[1001][1001];
		info = new int[201][2]; // 입장에 필요한 최소 경험치와 1분 마다 얻는 경험치
		d = new int[1001][201];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				timeGraph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		Arrays.sort(info, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// TODO Auto-generated method stub
//				return o1[0] - o2[0];
//			}
//
//		});

		// d[i][j] = i분에서 j번째 사냥터에 얻을수 있는 최대 경험치

		for (int i = 0; i < T; i++) {

			for (int j = 1; j <= N; j++) {
				if (info[j][0] <= d[i][j])
					d[i + 1][j] = Math.max(d[i + 1][j], d[i][j] + info[j][1]);

				for (int k = 1; k <= N; k++) { // 다음 사냥터
					if (i + timeGraph[j][k] <= T && info[k][0] <= d[i][j]) {
						d[i + timeGraph[j][k]][k] = Math.max(d[i][j], d[i + timeGraph[j][k]][k]);
					}

				}

			}
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, d[T][i]);
		}
		System.out.println(ans);
	}

}
