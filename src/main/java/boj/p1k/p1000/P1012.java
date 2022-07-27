import java.util.*;

class Pos {
	int x, y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, M, K;
	static int[][][] map;

	private static boolean checkIsInvalidRange(int x, int y) {
		return x < 0 || N <= x || y < 0 || M <= y;
	}

	private static void search(int a, int b) {

		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(a, b));

		while (!q.isEmpty()) {
			Pos pos = q.poll();
			int x = pos.x, y = pos.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (checkIsInvalidRange(nx, ny))
					continue;
				if (map[nx][ny][0] == 0)
					continue;
				if (map[nx][ny][1] == 1)
					continue;
				else {
					map[nx][ny][1] = 1;
					q.offer(new Pos(nx, ny));
				}
			}

		}

	}

	public static void main(String[] args) {

		int T = sc.nextInt();

		for (int tk = 1; tk < T + 1; tk++) {
			int cnt = 0;

			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][M][2]; // 0 idx는 배추인지 아닌지, 1 idx는 visit인지 아닌지

			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y][0] = 1; // 0 idx는 배추인지 아닌지, 1 idx는 visit인지 아닌지
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][0] == 1 && map[i][j][1] == 0) {
						map[i][j][1] = 1;
						search(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);

		}
	}

}