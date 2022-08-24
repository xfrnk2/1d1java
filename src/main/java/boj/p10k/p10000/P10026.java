package boj.p10k.p10000;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10026 {
	static int N, daltonism = 0, normal = 0;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static char[][] map;

	private static boolean checkIsInvalidRange(int x, int y) {

		return x < 0 || y < 0 || N <= x || N <= y;
	}

	private static boolean checkColor(char color1, char color2, boolean isDaltonism) {
		if (isDaltonism) return (color1 != 'B' && color2 != 'B') || (color1 == color2);
		return color1 == color2;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		boolean[][] dalVisited = new boolean[N][N];
		boolean[][] norVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!dalVisited[i][j]) {
					dfs(i, j, dalVisited, true);
					daltonism++;
				}
				if (!norVisited[i][j]) {
					dfs(i, j, norVisited, false);
					normal++;
				}
			}
		}
		System.out.println(normal + " " + daltonism);

	}

	public static void dfs(int x, int y, boolean[][] visited, boolean flag) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + di[i][0], ny = y + di[i][1];
			if (checkIsInvalidRange(nx, ny) || visited[nx][ny]) continue; 
            if (checkColor(map[x][y], map[nx][ny], flag)) dfs(nx, ny, visited, flag);}
		}
}
