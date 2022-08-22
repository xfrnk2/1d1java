package boj.p1k.p1900;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1992 {

	
	static char[][] board;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		search(0, 0, N);
		
	}
	
	public static void search(int x, int y, int n) {
		int next = n / 2;
		for (int i = x, xend = x + n; i < xend;i++) {
			for (int j = y, yend= y + n; j < yend; j++) {
				if (board[x][y] == board[i][j]) continue;
				System.out.print("(");
				search(x, y, next);
				search(x, y + next, next);
				search(x + next, y, next);
				search(x + next, y + next, next);
				System.out.print(")");
				return;
			}
			
		}
		System.out.print(board[x][y]);
	}

}
