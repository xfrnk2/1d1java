package boj.p1k.p1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1091 {
	static int N;
	static int[] S;
	static Item[] info;

	static class Item {
		int startIdx, curIdx, goalIdx;

		public Item(int startIdx, int curIdx, int goalIdx) {
			super();
			this.startIdx = startIdx;
			this.curIdx = startIdx;
			this.goalIdx = goalIdx;
		}

		@Override
		public String toString() {
			return String.format("Item [startIdx=%s, goalIdx=%s]", curIdx, goalIdx);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(in.readLine());
		S = new int[N];
		info = new Item[N];

		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			info[i] = new Item(i, i, Integer.valueOf(st.nextToken()));
		}
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.valueOf(st.nextToken());
		}

		// 사이클이 있는지 미리 확인후 있을경우 종료
//		for (int i = 0; i < N; i++) {
//			if (hasCycle(info[i])) {
//				
//				System.out.println(-1);
//				System.exit(0);
//			}
//		}
		System.out.println(shuffle());

	}

	public static int shuffle() {
		int cnt = 0;
		int loopCnt = 0;
		loop: while (true) {
			loopCnt++;
			if (140000 < loopCnt) {
				return -1;
			}
			Item[] infoCopy = new Item[N];
			for (int i = 0; i < N; i++) {
				if (check())
					break loop;
				int next = S[info[i].curIdx];

				info[i].curIdx = next;
				infoCopy[next] = info[i];
			}
			cnt++;
			info = infoCopy;
		}
		return cnt;
	}

	public static boolean hasCycle(Item item) {
		int now = item.curIdx;
		boolean[] visit = new boolean[N];
		visit[now] = true;
		while (now != item.goalIdx) {
			// 도착할떄까지 반복
			int next = S[now];
			if (visit[next])
				return true;

			visit[next] = true;
			now = next;
		}
		return false;

	}

	public static boolean check() {
		for (int i = 0; i < N; i++) {
			if (info[i].goalIdx != i % 3) {
				return false;
			}
		}
		return true; // 모든 사용자에게 갔다면 참을 리턴
	}

}
