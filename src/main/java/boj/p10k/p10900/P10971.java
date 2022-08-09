package boj.p10k.p10900;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10971 {
	static int ans = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		solution(n, matrix);
	}

	public static void solution(int n, int[][] matrix) {
		visited = new boolean[n];
		cycle(n, 0, 0, matrix, 0);
		System.out.print(ans);
	}

	public static void cycle(final int n, int cnt, int cost, int[][] matrix, int pos) {
		if (cnt == n) {
			System.out.println("pos" + "" + pos + " " + cost);
			for (int i = 0; i < n; i++) {
				System.out.println(visited[i]);
			}
			if (pos != 0) return;
			ans = Math.min(ans, cost);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (matrix[pos][i] != 0 && !visited[i]) {
				visited[i] = true;
				cycle(n, cnt + 1, cost + matrix[cnt][i], matrix, i);
				visited[i] = false;
			}
		}
	}

}
