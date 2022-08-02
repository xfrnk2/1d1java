package swea.d2;

import java.util.Scanner;

public class P1954 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int direction;

	private static void rotate() {
		direction++;
		if (4 <= direction) {
			direction = 0;
		}
	}

	private static boolean checkIsInValidRange(int n, int x, int y) {
		return x < 0 || y < 0 || n <= x || n <= y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i < T + 1; i++) {
			System.out.println("#" + i);
			solution(sc.nextInt());
		}
	}

	public static void solution(int n) {
		direction = 0;
		int[][] arr = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int cnt = n * n;
		int x = 0, y = 0, cur = 0;

		while (cur++ < cnt) {
			arr[x][y] = cur;
			visited[x][y] = true;

			int nx = x + dx[direction];
			int ny = y + dy[direction];
			if (checkIsInValidRange(n, nx, ny) || visited[nx][ny]) {
				rotate();
				nx = x + dx[direction];
				ny = y + dy[direction];
			}
			x = nx;
			y = ny;
		}

		for (int[] row : arr) {
			for (int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}

	}

}
