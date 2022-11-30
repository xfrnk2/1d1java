package boj.p9k.p9300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P9376 {
	static int T, N, M;

	static P[] prizoner;
	static int[][] di = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;

	static class P {
		int x, y, cnt;

		public P(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return String.format("P [x=%s, y=%s, crash=%s]", x, y, cnt);
		}

	}

	private static boolean isInvalidArea(int x, int y) {
		return x < 0 || y < 0 || N + 1 < x || M + 1 < y || map[x][y] == '*';
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.valueOf(in.readLine());
		StringTokenizer st;
		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(in.readLine());
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());
			map = new char[N + 2][M + 2];

			prizoner = new P[2];
			int prizonerIdx = 0;

			for (int i = 1; i <= N; i++) {
				String row = in.readLine();
				for (int j = 1; j <= M; j++) {
					map[i][j] = row.charAt(j - 1);
					if (row.charAt(j - 1) == '$') {
						prizoner[prizonerIdx++] = new P(i, j, 0);
					}
				}
			}

			int[][] geun, prizoner1, prizoner2;
			prizoner1 = getData(prizoner[0]);
			prizoner2 = getData(prizoner[1]);
			geun = getData(new P(0, 0, 0));

//			print(prizoner1);
//			print(prizoner2);
//			print(geun);

			sb.append(getMin(geun, prizoner1, prizoner2) + "\n");

		}
		System.out.print(sb.toString());

	}

	public static int getMin(int[][] geun, int[][] prizoner1, int[][] prizoner2) {
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				if (map[i][j] == '*' || geun[i][j] == -1 || prizoner1[i][j] == -1 || prizoner2[i][j] == -1) {
					continue;
				}
				int sum = geun[i][j] + prizoner1[i][j] + prizoner2[i][j];
				if (map[i][j] == '#') {
					sum -= 2;
				}

				res = Math.min(res, sum);
			}
		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public static void dealWithUnvisitedLoc(int[][] record) {
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(record[i], -1);
		}
	}

	public static int[][] getData(P prizoner) {
		boolean[][] visit = new boolean[N + 2][M + 2];
		int[][] record = new int[N + 2][M + 2];
		dealWithUnvisitedLoc(record);

		PriorityQueue<P> q = new PriorityQueue<>(new Comparator<P>() {

			@Override
			public int compare(P o1, P o2) {
				// TODO Auto-generated method stub
				return o1.cnt - o2.cnt;
			}

		});
		q.add(prizoner);
		visit[prizoner.x][prizoner.y] = true;

		while (!q.isEmpty()) {
			P now = q.poll();
			record[now.x][now.y] = now.cnt;
			for (int i = 0; i < 4; i++) {
				int nx = now.x + di[i][0], ny = now.y + di[i][1];
				if (isInvalidArea(nx, ny) || visit[nx][ny])
					continue;
				visit[nx][ny] = true;
				q.add(new P(nx, ny, map[nx][ny] == '#' ? now.cnt + 1 : now.cnt));
			}
		}

		return record;
	}

	public static void print(int[][] data) {
		for (int[] row : data) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}
}
