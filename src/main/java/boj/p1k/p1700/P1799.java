package boj.p1k.p1700;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1799 {
	static int N, ans;
	static boolean[][] board;
	static boolean[][] isOn;

	
	public static class Pos extends Point {
		boolean status;

		public Pos(int x, int y, boolean status) {
			super(x, y);
			this.status = status;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		board = new boolean[N][N];
		isOn = new boolean[N][N];
		ans = 0;
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = st.nextToken().equals('0') ? false : true;
			}

		}

		check(0, 0, 0);
		System.out.println(ans);

	}
	static int cc = 0;
	public static void check(int cnt, int x, int y) {
//		cc ++;
//		if (20 < cc) System.exit(0); 
//		System.out.println("x,y : " + x + "  " +  y);
//		System.out.println(cnt);
//		for (int i = 0; i < N; i++) {
//	
//			System.out.println(Arrays.toString(isOn[i]));
//		}
//		System.out.println();
		
		if (N - 1 <= x && N <= y) { // 종료조건
//			if (ans < cnt) {
//				
//				System.out.println(cnt);
//				for (int i = 0; i < N; i++) {
//					System.out.println(Arrays.toString(board[i]));
//				}
//				System.out.println();
//			}
			
 			ans = Math.max(ans, cnt);

			return;
		}

		if (N <= y) {
			check(cnt, x + 1, 0);
			return;
		}

		if (board[x][y] == false || isOn[x][y] == true) { // 놓을 수 없는 칸이거나, 다른 말에 의해 놓여질 수 없음
			check(cnt, x, y + 1);
			return;
		}

		boolean prev = isOn[x][y];
		isOn[x][y] = true;
		ArrayList<Boolean> temp = setUnreachablePath(x, y);
		check(cnt + 1, x, y + 1); // 놓고 다음 순회
		isOn[x][y] = false;
		reSetUnreachablePath(x, y, temp);
		check(cnt, x, y + 1); // 놓지 않고 다음 순회

	}

	public static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || N <= y;
	}

	public static ArrayList<Boolean> setUnreachablePath(int x, int y) {
		int lx = x + 1, ly = y - 1;
		int rx = x + 1, ry = y + 1;
		board[x][y] = false;
		ArrayList<Boolean> record = new ArrayList<>(N);
		
		while (!isOut(lx, ly)) {
			record.add(isOn[lx][ly]);
			isOn[lx++][ly--] = true;
		}

		while (!isOut(rx, ry)) {
			record.add(isOn[rx][ry]);
			isOn[rx++][ry++] = true;
		}
		return record;
	}

	public static void reSetUnreachablePath(int x, int y, ArrayList<Boolean> record) {
		board[x][y] = true;
		int idx = 0;
		int lx = x + 1, ly = y - 1, rx = x + 1, ry = y + 1; 
		
		while (!isOut(lx, ly))
		{
			isOn[lx++][ly--] = record.get(idx);
			idx++;
		}
		while (!isOut(rx, ry)) {
			isOn[rx++][ry++] = record.get(idx);
			idx++;
		}
		record.clear();
		

		
//		int lx = x, ly = y;
//		int rx = x, ry = y;
//		board[x][y] = 1;
		
//		
//		
//		while (!isOut(lx, ly)) {
//			isOn[lx++][ly--] = false;
//		}
//
//		while (!isOut(rx, ry)) {
//			isOn[rx++][ry++] = false;
//		}
	}

}
