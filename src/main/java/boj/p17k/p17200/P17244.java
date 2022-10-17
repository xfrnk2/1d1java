package boj.p17k.p17200;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17244 {
	static int N, M;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][][] visited;
	static Point[] keys = new Point[6];
	static Map<Point, Integer> idxMap = new HashMap<>();

	public static class Status {
		int x, y, time, bit;

		public Status(int x, int y, int time, int bit) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.bit = bit;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		int startX = 0, startY = 0;
		int total = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'S') {
					startX = i;
					startY = j;
					continue;
				}
				if (map[i][j] == 'X') {

					Point p = new Point(i, j);
					keys[total] = p;
					idxMap.put(p, total);
					total++;
					continue;
				}

			}
		}

		visited = new boolean[N][M][((1 << total) - 1) * 2 + 1];

		Queue<Status> q = new LinkedList<>();
		q.offer(new Status(startX, startY, 0, 0));

		while (!q.isEmpty()) {
			Status cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + di[i][0], ny = cur.y + di[i][1];

				if (nx < 0 || ny < 0 || N <= nx || M <= ny)
					continue;
				if (visited[nx][ny][cur.bit])
					continue;
				if (map[nx][ny] == '#')
					continue;

				if (map[nx][ny] == 'E') {
					if (cur.bit == ((1 << total) - 1) * 2) {

						System.out.println(cur.time + 1);
						return;
					}
					continue;
				}

				if (map[nx][ny] == 'X') {
					int keyIdx = idxMap.get(new Point(nx, ny));

					visited[nx][ny][cur.bit | 1 << keyIdx + 1] = true;

					if ((cur.bit & 1 << keyIdx + 1) == 0) { // 물건이 없으면 줍자.
						q.offer(new Status(nx, ny, cur.time + 1, cur.bit | 1 << keyIdx + 1));
						continue;
					} else {
						q.offer(new Status(nx, ny, cur.time + 1, cur.bit));
						continue;
					}

				}

				visited[nx][ny][cur.bit] = true;
				q.offer(new Status(nx, ny, cur.time + 1, cur.bit));

			}
		}

	}

}
