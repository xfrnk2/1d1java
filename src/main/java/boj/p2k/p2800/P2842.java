package boj.p2k.p2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P2842 {
	static char[][] map;
	static int[][] height;
	static int N;
	static int totalK;
	static int pX, pY;
	static int[][] di = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }, { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static Set<Integer> set;

	static class Stat {
		int x, y;

		public Stat(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static boolean isOut(int x, int y) {
		return x <= 0 || y <= 0 || N < x || N < y;
	}

	public static boolean checkIsReachableToAll(int start, int end) {
		if (height[pX][pY] < start || end < height[pX][pY])
			return false;
		boolean[][] visit = new boolean[N + 1][N + 1];
		ArrayDeque<Stat> dq = new ArrayDeque<>();
		dq.add(new Stat(pX, pY));
		int cnt = 0;
		visit[pX][pY] = true;
		while (!dq.isEmpty()) {
			Stat cur = dq.poll();

			for (int i = 0; i < 8; i++) {
				int nx = cur.x + di[i][0], ny = cur.y + di[i][1];
				if (isOut(nx, ny) || visit[nx][ny] || height[nx][ny] < start || end < height[nx][ny])
					continue;
				if (map[nx][ny] == 'K') {
					if (++cnt == totalK) {
						return true;
					}
				}
				visit[nx][ny] = true;
				dq.add(new Stat(nx, ny));
			}

		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new char[N + 1][N + 1];
		height = new int[N + 1][N + 1];
		set = new TreeSet<>();

		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			String row = in.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = row.charAt(j - 1);

				if (map[i][j] == 'K')
					totalK++;
				else if (map[i][j] == 'P') {
					pX = i;
					pY = j;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				set.add(height[i][j] = Integer.parseInt(st.nextToken()));
			}
		}
		Integer[] heights = set.toArray(new Integer[set.size()]);

		int start = 0, end = 0, size = set.size(), ans = Integer.MAX_VALUE;
		while (start <= end && end < size) {
			if (checkIsReachableToAll(heights[start], heights[end])) {
				ans = Math.min(heights[end] - heights[start], ans);
				start++;
			} else {
				end++;
			}
		}
		System.out.println(ans);
	}
}
