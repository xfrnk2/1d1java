package boj.p2k.p2500;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2589 {

	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, ans = 0;
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					visit[i][j] = true;
					search(i, j);
				}
			}
		}
		System.out.println(ans - 1);

	}

	public static boolean isNotValidRange(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y || map[x][y] != 'L';
	}

	public static void search(int x, int y) {

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		int cnt = 0;
		boolean[][] vv = new boolean[N][M];
		vv[x][y] = true;
		while (!q.isEmpty()) {

			int size = q.size();
			while (size-- > 0) {

				Point p = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = p.x + di[i][0], ny = p.y + di[i][1];
					if (isNotValidRange(nx, ny) || vv[nx][ny])
						continue;

					vv[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}

			cnt++;
		}

		ans = Math.max(ans, cnt);

	}

}
