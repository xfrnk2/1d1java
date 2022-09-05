package boj.p16k.p16900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P16946 {

	static int N, M, groupCnt, initGroupCnt;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map, ans;
	static boolean[][] visited;
	static Map<Character, Integer> groupMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		solve(N, M, map);
	}
	
	

	public static void solve(int n, int m, char[][] _map) {
		N = n;
		M = m;
		map = _map;
		visited = new boolean[N][M];
		ans = new char[N][M];
		groupMap = new HashMap<>();
		groupCnt = 2;
		initGroupCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != '0')
					continue;
				char key = (char) (groupCnt++ + '0');
				initGroup(key, i, j);
				groupMap.put(key, initGroupCnt);
				initGroupCnt = 0;
			}
			Arrays.fill(ans[i], '0');
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '1') {
					int nx, ny, res = 1;
					Set<Character> groupNumSet = new HashSet<>();

					for (int k = 0; k < 4; k++) {
						nx = i + di[k][0];
						ny = j + di[k][1];
						if (isOut(nx, ny) || map[nx][ny] == '1')
							continue;
						groupNumSet.add(map[nx][ny]);
					}

					for (Character character : groupNumSet) {
						res += groupMap.get(character);
					}
					ans[i][j] = (char) ((res % 10) + '0');
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}
	

	public static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}

	public static void initGroup(char gc, int x, int y) {
		map[x][y] = gc;
		initGroupCnt++;
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + di[i][0];
			ny = y + di[i][1];
			if (isOut(nx, ny) || map[nx][ny] != '0')
				continue;

			initGroup(gc, nx, ny);

		}
	}

}
