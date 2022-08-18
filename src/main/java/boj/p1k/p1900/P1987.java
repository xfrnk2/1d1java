package boj.p1k.p1900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1987 {
	static int R, C, ans;
	static int[][] di = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] field;
	static boolean[] alphabetUsed;
	
	private static boolean checkIsInvalidRange(int x, int y) {
		return x < 0 || y < 0 || R <= x || C <= y;
	}
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] infoArr = br.readLine().split(" ");
		R = Integer.parseInt(infoArr[0]);
		C = Integer.parseInt(infoArr[1]);
		field = new char[R][C];
		alphabetUsed = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				field[i][j] = input.charAt(j);
			}
		}
		alphabetUsed[field[0][0] - 'A'] = true;
		search(0, 0, 0);
		System.out.println(ans);
	}
	
	
	
	public static void search (int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx = x + di[i][0], ny = y + di[i][1];
			if (checkIsInvalidRange(nx, ny)) continue;
			if (alphabetUsed[field[nx][ny] - 'A']) continue;
			
			alphabetUsed[field[nx][ny] - 'A'] = true;
			search(nx, ny, cnt + 1);
			alphabetUsed[field[nx][ny] - 'A'] = false;
			
		}
		ans = Math.max(ans, cnt + 1);
	}

}
