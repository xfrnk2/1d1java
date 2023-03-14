package boj.p2k.p2200;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2243 {

	static final int MAX = 1000000;
	static int[] tree, arr;

	public static int getIdx(int node, int start, int end, int cnt) {
		if (start == end)
			return start;

		int mid = (start + end) / 2;
		if (tree[node * 2] < cnt) {
			return getIdx(node * 2 + 1, mid + 1, end, cnt - tree[node * 2]);
		} else {
			return getIdx(node * 2, start, mid, cnt);
		}
	}

	public static void update(int node, int start, int end, int idx, int val) {
		if (start > idx || idx > end)
			return;
		if (start == end) {
			tree[node] += val;
			return;
		}
		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, val);
		update(node * 2 + 1, mid + 1, end, idx, val);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		arr = new int[MAX + 1];
		tree = new int[MAX * 4];
		StringTokenizer st;

		while (n-- > 0) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 2) {
				// 사탕을 넣는 경우
				// 인자 2
				int c = Integer.parseInt(st.nextToken()); // b 맛을 c만큼 변경
				arr[b] += c;
				update(1, 1, MAX, b, c);

			} else {
				// 사탕상자에서 사탕을 꺼내는 경우
				// 인자 1

				int i = getIdx(1, 1, MAX, b); // i번째 사탕을 하나 꺼낸다.
				arr[i]--;
				// arr는 사탕을 맛을 기준으로한 순서대로 갯수를 담고있는 컨테이너
				System.out.println(i);
				update(1, 1, MAX, i, -1);

			}

		}
	}

}
