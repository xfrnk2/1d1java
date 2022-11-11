package boj.p2k.p2600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2618 {

	static int N, W;
	static Pos[] carA;
	static Pos[] carB;
	static int[][] d;
	static StringBuilder sb;
	
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}

	private static int getDis(int sx, int sy, int tx, int ty) {
		return Math.abs(sx - tx) + Math.abs(sy - ty);
	}


	private static int go(int cnt, int a, int b) {
		if (W <cnt)
			return 0;

		if (d[a][b] != 0)
			return d[a][b];

		int maxP = Math.max(a, b) + 1;
		int distA = getDis(carA[maxP].x, carA[maxP].y, carA[a].x, carA[a].y);
		int distB = getDis(carB[maxP].x, carB[maxP].y, carB[b].x, carB[b].y);

		int aMax = go(cnt + 1, maxP, b) + distA;
		int bMax = go(cnt + 1, a, maxP) + distB;

		return d[a][b] = Math.min(aMax, bMax);
		
	}

	private static void trace(int cnt, int a, int b) {
		if (cnt > W)
			return;

		int maxP = Math.max(a, b) + 1;
		int distA = getDis(carA[maxP].x, carA[maxP].y, carA[a].x, carA[a].y);
		int distB = getDis(carB[maxP].x, carB[maxP].y, carB[b].x, carB[b].y);

		int aMax = go(cnt + 1, maxP, b) + distA;
		int bMax = go(cnt + 1, a, maxP) + distB;

		if (aMax >= bMax) {
			sb.append(2 + "\n");
			trace(cnt + 1, a, maxP);
		} else {
			sb.append(1 + "\n");
			trace(cnt + 1, maxP, b);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.valueOf(in.readLine());
		W = Integer.valueOf(in.readLine());

		d = new int[1002][1002];
		

		carA = new Pos[1002];
		carB = new Pos[1002];

		carA[0] = new Pos(1, 1);
		carB[0] = new Pos(N, N);

		for (int i = 1; i <= W; i++) {
			st = new StringTokenizer(in.readLine());
			carA[i] = new Pos(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
		}

		System.arraycopy(carA, 1, carB, 1, W);

		sb = new StringBuilder();
		sb.append(go(1, 0, 0) + "\n");
		trace(1, 0, 0);
		System.out.println(sb.toString());
//		System.out.println(Arrays.toString(carA));
		// System.out.println(Arrays.toString(carB));
		/*
		 * d[x][y] 는 경찰차 1이 x, 경찰차 2에 있을때 최소 이동거리의 합 현재 다음의 위치를 P라고 한다면, 다음 위치까지의 최소 합은,
		 * do(P) = min(do(P, y) + distance(x, P), min(do(x, P) + distance(P, y)))
		 */

	}

}