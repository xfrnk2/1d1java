package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pos {

	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class P1249 {

	static int n;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static int[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int k = 1; k < t + 1; k++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}

			visit = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(visit[i], Integer.MAX_VALUE);

			}

			int answer = search();
			System.out.println(String.format("#%d %d", k, answer));
		}

	}

	private static int search() {

		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0, 0));
		visit[0][0] = 0;

		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			int x = p.x, y = p.y;
			int nx, ny;

			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || n <= nx || ny < 0 || n <= ny) {
					continue;
				}
				if (visit[x][y] + map[nx][ny] < visit[nx][ny]) {
					visit[nx][ny] = visit[x][y] + map[nx][ny];
					queue.offer(new Pos(nx, ny));

				}
			}

		}

		return visit[n - 1][n - 1];
	}

}