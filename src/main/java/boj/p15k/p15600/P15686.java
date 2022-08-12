package boj.p15k.p15600;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pos {
	int x, y;
	Pos (int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class P15686 {
	static int N, M, C, H, total = Integer.MAX_VALUE;
	static Pos[] inputs;
	static Pos[] numbers;
	static int[][] arr, di = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static Queue<Pos> store = new LinkedList<Pos>();

	private static boolean checkIsInvalidRange(int x, int y) {
		return x < 0 || y < 0 || N <= x || N <= y;
	}

	public static void combination(int cnt, int r) {
		if (r == 0) {
			dfs();
			return;
		}
		if (cnt < r)
			return;

		numbers[r - 1] = inputs[cnt - 1];
		combination(cnt - 1, r - 1);
		combination(cnt - 1, r);
	}

	private static void dfs() {

		for (int c = 0; c < C; c++) {

			int[][] weight = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(weight[i], Integer.MAX_VALUE);
			}

			Queue<Pos> queue = new LinkedList<Pos>();
			for (Pos pos : numbers) {
				queue.offer(pos);
				weight[pos.x][pos.y] = 0;
			}

			int hCount = 0;
			int sum = 0;

			while (!queue.isEmpty() && hCount < H) {

				Pos pos = queue.poll();
				int x = pos.x, y = pos.y;

				for (int j = 0; j < 4; j++) {
					int nx = x + di[j][0], ny = y + di[j][1];
					if (checkIsInvalidRange(nx, ny))
						continue;
					if (weight[nx][ny] > weight[x][y] + 1) {
						weight[nx][ny] = weight[x][y] + 1;
						if (arr[nx][ny] == 1) {
							hCount++;
							sum += weight[nx][ny];
						}
						queue.offer(new Pos(nx, ny));
					}

				}

			}

			total = Math.min(total, sum);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		numbers = new Pos[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if (cur == 1)
					H++;
				if (cur == 2) {
					store.offer(new Pos(i, j));
					C++;
				}
				arr[i][j] = cur;
			}
		}

		inputs = store.toArray(new Pos[C]);
		combination(C, M);
		System.out.print(total);

	}

}
