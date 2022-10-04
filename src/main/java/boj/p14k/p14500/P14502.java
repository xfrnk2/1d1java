package boj.p14k.p14500;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502 {

	static int N, M;
	static int[][] map;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static Point[] select;
	static boolean[][] visit;
	static List<Point> virusQ = new ArrayList<>();
	static int zeroCnt = 0;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		select = new Point[3];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusQ.add(new Point(i, j));
				}
				if (map[i][j] == 0) {
					zeroCnt++;
				} else {
					visit[i][j] = true;
				}
			}

		}
		zeroCnt -= 3;

		permu(0, 0, 0);
		System.out.println(ans);

	}

	public static void copyMap(int[][] from, int[][] to) {
		for (int i = 0; i < N; i++) {
			System.arraycopy(from[i], 0, to[i], 0, M);
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				from[i][j] = to[i][j];
//			}
//		}
	}

	public static void permu(int cnt, int startX, int startY) {
		if (cnt == 3) {

			int[][] newMap = new int[N][M];
			copyMap(map, newMap);

			for (Point p : select) {
				newMap[p.x][p.y] = 1;
			}

			ans = Math.max(spread(zeroCnt, newMap), ans);

			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (visit[i][j])
					continue;
				select[cnt] = new Point(i, j);
				visit[i][j] = true;
				permu(cnt + 1, i, j + 1);
				visit[i][j] = false;

			}
		}

	}

	public static int spread(int cnt, int[][] cMap) {
		Queue<Point> q = new LinkedList<>();
		for (Point v : virusQ) {
			q.offer(v);
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + di[i][0], ny = cur.y + di[i][1];
				if (nx < 0 || ny < 0 || N <= nx || M <= ny)
					continue;
				if (cMap[nx][ny] != 0)
					continue;

				cMap[nx][ny] = 2;
				cnt--;
				q.offer(new Point(nx, ny));

			}
		}

		return cnt;

	}

}
