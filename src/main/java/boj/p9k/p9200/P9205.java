package boj.p9k.p9200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9205 {
	static final int MAX_DISTANCE = 1000;

	static class Pos {
		short x, y;

		Pos(short x, short y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static int getDis(Pos a, Pos b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		byte T = Byte.parseByte(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			Integer n = Integer.parseInt(in.readLine()) + 2;
			Pos[] spot = new Pos[n];
			boolean[][] visit = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());

				short x = Short.parseShort(st.nextToken());
				short y = Short.parseShort(st.nextToken());
				spot[i] = new Pos(x, y);
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (getDis(spot[i], spot[j]) <= MAX_DISTANCE) {
						visit[i][j] = true;
					}
				}
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (visit[i][k] & visit[k][j]) {
							visit[i][j] = true;
						}
					}
				}
			}
			System.out.println(visit[0][n - 1] ? "happy" : "sad");

		}
	}

}
