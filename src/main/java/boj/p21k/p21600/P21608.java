package boj.p21k.p21600;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P21608 {
	static int N, size;
	static Map<Integer, int[]> info = new HashMap<>();
	static int[][] board;
	static int[] order;
	static int[][] di = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Stu {
		int no, x, y;

		public Stu(int no, int x, int y) {
			super();
			this.no = no;
			this.x = x;
			this.y = y;
		}
	}

	public static boolean isIn(int x, int y) {
		return 0 <= x && 0 <= y && x < N && y < N;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		size = N * N;
		board = new int[N][N];
		order = new int[size];
		List<Stu> record = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(in.readLine());
			int student = Integer.parseInt(st.nextToken());
			order[i] = student;
			info.put(student, new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		for (int i = 0; i < size; i++) {
			if (i == 0) { // 첫번째 학생은 1,1 좌표에 앉음
				board[1][1] = order[i];
				record.add(new Stu(order[i], 1, 1));
				continue;
			}

			Set<Point> blank = new HashSet<>(); // 교실에 있는 학생의 사방에서 빈 칸 찾기
			for (Stu stu : record) {

				for (int j = 0; j < 4; j++) {
					int nx = stu.x + di[j][0], ny = stu.y + di[j][1];
					if (isIn(nx, ny) && board[nx][ny] == 0) {
						blank.add(new Point(nx, ny));
					}
				}
			}

			Point maxScorePos = null;
			int maxScore = -1;
			int maxBlankCnt = -1;
			// 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
			for (Point point : blank) {
				int score = 0;
				int blankCnt = 0;
				for (int j = 0; j < 4; j++) {
					int nx = point.x + di[j][0], ny = point.y + di[j][1];
					if (isIn(nx, ny)) { // 유효 범위라면
						if (board[nx][ny] != 0) {
							int[] targets = info.get(order[i]); // 좋아하는 학생이 있는지 확인
							boolean flag = false;
							for (Integer target : targets) {
								if (board[nx][ny] == target) {
									flag = true;
									break;
								}
							}
							if (flag) { // 좋아하는 학생이 해당 방향에 있다면
								score++;
							}
						} else {
							blankCnt++;
						}
					}
				}
				if (maxScore < score) { // 인접한 좋아하는 학생수가 이전 기록보다 많다면 갱신
					maxScore = score;
					maxBlankCnt = blankCnt;
					maxScorePos = point;
				} else if (maxScore == score) {
					// 좋아하는 학생 수가 같다면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
					if (maxBlankCnt < blankCnt) { // 이전 최대빈칸갯수보다 빈칸갯수가 많다면 갱신
						maxBlankCnt = blankCnt;
						maxScorePos = point;
					} else if (maxBlankCnt == blankCnt) { // 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의
															// 번호가 가장 작은 칸으로 자리를 정한다.
						if (maxScorePos.x > point.x) {

							maxScorePos = point;
						} else if (maxScorePos.x == point.x) {
							if (maxScorePos.y > point.y) {

								maxScorePos = point;
							}
						}
					}
				}

			}

			board[maxScorePos.x][maxScorePos.y] = order[i];
			record.add(new Stu(order[i], maxScorePos.x, maxScorePos.y));

		}


		int ans = 0;
		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < N; j2++) {
				int curOrder = board[j][j2];

				int[] targets = info.get(curOrder);
				boolean[] selected = new boolean[4];
				int score = 0;
				for (int k = 0; k < 4; k++) {
					int nx = j + di[k][0], ny = j2 + di[k][1];
					if (isIn(nx, ny)) {
						for (int tt = 0; tt < 4; tt++) {
							if (!selected[tt] && board[nx][ny] == targets[tt]) {
								selected[tt] = true;
								score++;
								break;
							}
						}
					}
				}
				switch (score) {
				case 0:
					ans += 0;
					break;
				case 1:
					ans += 1;
					break;
				case 2:
					ans += 10;
					break;
				case 3:
					ans += 100;
					break;
				case 4:
					ans += 1000;
					break;
				}

			}
		}

		System.out.println(ans);

	}

}
