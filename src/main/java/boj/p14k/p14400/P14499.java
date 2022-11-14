package boj.p14k.p14400;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P14499 {
	static int N, M;
	static byte[][] map;
	static int[][] di = new int[][] { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	static class Dice {
		private static volatile Dice instance;
		static int x, y;

		static byte[] horizontal;
		static byte[] vertical;

		private Dice(int x, int y, byte north, byte south, byte west, byte east, byte up, byte down) {
			super();
			this.x = x;
			this.y = y;
			// up에서부터 시작, 하 방향으로,
			vertical = new byte[] { up, south, down, north };
			// up에서부터 시작, 우 방향으로
			horizontal = new byte[] { up, east, down, west };
		}

		public static Dice getInstance(int x, int y) {
			if (instance == null) {
				synchronized (Dice.class) {
					if (instance == null) {
						instance = new Dice(x, y, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0);
						return instance;
					}
				}
			}
			return instance;
		}

		public static void move(int dir) {

			// 동서북남
			byte lastest;
			byte[] temp = new byte[4];
			switch (dir) {
			case 1:

				lastest = horizontal[3];

				System.arraycopy(horizontal, 0, temp, 1, 3); // horizontal을 우방향으로 1칸씩 밀기
				temp[0] = lastest; // 임시로 보관하였던 마지막 원소 값을 0번 idx 위치에 주입하기
				horizontal = temp;

				break;

			case 2:

				lastest = horizontal[0];

				System.arraycopy(horizontal, 1, temp, 0, 3); // horizontal을 좌방향으로 1칸씩 밀기
				temp[3] = lastest;
				horizontal = temp;

				break;

			case 3:

				lastest = vertical[0];

				System.arraycopy(vertical, 1, temp, 0, 3); // vertical을 하방향으로 1칸씩 밀기
				temp[3] = lastest;
				vertical = temp;

				break;
			case 4:

				lastest = vertical[3];

				System.arraycopy(vertical, 0, temp, 1, 3); // vertical을 상방향으로 1칸씩 밀기
				temp[0] = lastest;
				vertical = temp;

				break;
			}

			if (dir <= 2) { // 동, 서 방향이라면 수평 면의 상하를 수직면의 상하면과 동기화
				vertical[0] = horizontal[0];
				vertical[2] = horizontal[2];
			} else { // 북, 남 방향이라면 수직 면의 상하를 수평면의 상하면과 동기화

				horizontal[0] = vertical[0];
				horizontal[2] = vertical[2];
			}

		}


	}

	private static boolean isOut(int x, int y) {
		return x < 0 || y < 0 || N <= x || M <= y;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		byte x = Byte.parseByte(st.nextToken());
		byte y = Byte.parseByte(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new byte[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Byte.parseByte(st.nextToken());
			}
		}

		Dice dice = Dice.getInstance(x, y);
		// 주사위 초기화

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			int next = Integer.parseInt(st.nextToken());
			int nx = dice.x + di[next][0], ny = dice.y + di[next][1];
			// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4로
			if (isOut(nx, ny))
				continue; // 범위를 벗어나면 무시
			Dice.move(next);
			
			
			// 주사위 이동 후 해당 map상의 위치가 0이라면
			
			// * vertical[0], horizontal[0]은 늘 up
			// * vertical[2], horizontal[2]은 늘 down
			if (map[nx][ny] == 0) { 		
				map[nx][ny] = Dice.vertical[2]; 
			} else {
				Dice.vertical[2] = map[nx][ny];
				Dice.horizontal[2] = map[nx][ny];
				map[nx][ny] = 0;
			}

			dice.x = nx;
			dice.y = ny;

			out.write(Dice.vertical[0] + "\n"); // horizontal[0]을 써도 무방하다.

		}
		out.flush();
	}

}
