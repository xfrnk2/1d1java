package sw_expert_academy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int z = 0; z < t; z++) {

			int n, m;

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			int[][] array = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int exclusive = n - m + 1;
			int answer = 0;

			for (int i = 0; i < exclusive; i++) {
				for (int j = 0; j < exclusive; j++) {
					int sum = 0;
					for (int r = 0; r < m; r++) {
						for (int c = 0; c < m; c++) {
							sum += array[i + r][j + c];
						}
					}
					answer = Math.max(answer, sum);
				}
			}
			System.out.printf("#%d %d%n", z + 1, answer);
		}

	}
}
