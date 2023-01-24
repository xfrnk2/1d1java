package boj.p1k.p1100;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class P1113 {
	static int N, M;
	static int[][] map;
	static int[][] di = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		int ans = 0;
		for (int k = 1; k < 10; k++) {
			int res = search(k);
			ans += res;
		}
		System.out.println(ans);
	}

	public static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}

	public static int search(int height) {
		boolean[][] visit = new boolean[N][M];
		int res = 0;

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {

				if (!visit[i][j] && height == map[i][j]) {

					Set<Point> record = new HashSet<>();
					Queue<Point> q = new LinkedList<>();
					visit[i][j] = true;
					record.add(new Point(i, j));
					q.add(new Point(i, j));

					int max = 9;
					while (!q.isEmpty()) {
						Point cur = q.poll();
						record.add(new Point(cur.x, cur.y));
						for (int k = 0; k < 4; k++) {
							int nx = cur.x + di[k][0], ny = cur.y + di[k][1];

							if (!isOut(nx, ny)) {

								if (map[nx][ny] != height) {
									max = Math.min(max, map[nx][ny]);
									continue;
								}
								if (visit[nx][ny])
									continue;
								visit[nx][ny] = true;
								q.add(new Point(nx, ny));

							} else {
								max = 0;
							}

						}
					}
					if (height < max) {
						int interval = max - height;
						for (Point point : record) {
							map[point.x][point.y] = max;
							visit[point.x][point.y] = false;
							res += interval;
						}
					}

				}
			}
		}
		return res;
	}

}
