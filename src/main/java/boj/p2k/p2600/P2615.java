import java.util.Arrays;
import java.util.Scanner;


public class P2615{

	final static int[] dx = { 0, 0, 1, 1, 1 };
	final static int[] dy = { -1, 1, -1, 0, 1 };
	static int[][] field;

	private static boolean isInValidRange(int x, int y) {
		return x < 1 || 19 < x || y < 1 || 19 < y;
	}

	private static boolean search(int x, int y, int color) {
		for (int i = 0; i < 5; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			int count = 1;

			int answerX = x;
			int answerY = y; 
			
			while (!isInValidRange(nx, ny) && field[nx][ny] == color) {
				if (ny < answerY) {
					answerX = nx;
					answerY = ny;
				}
				
				count++;
				nx += dx[i];
				ny += dy[i];
				
			}
			if (count == 5) {
				if (!isInValidRange(x -dx[i], y-dy[i]) && field[x-dx[i]][y-dy[i]] == color) {
					continue;
				}
				
				
				System.out.println(color);
				
				System.out.printf("%d %d", answerX, answerY);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		field = new int[20][20];

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				field[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (field[i][j] == 0)
					continue;
				if (search(i, j, field[i][j])) {
					return;
				}
			}
		}
		System.out.println(0);

	}

}
