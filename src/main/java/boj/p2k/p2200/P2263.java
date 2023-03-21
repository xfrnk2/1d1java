package boj.p2k.p2200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2263 {

	static int N;
	static int[] inorder, postorder, inorderIdx;
	static StringBuilder sb = new StringBuilder();

	public static void search(int inStart, int inEnd, int postStart, int postEnd) {

		if (inStart > inEnd || postStart > postEnd) {
			return;
		}

		int root = postorder[postEnd];
		sb.append(root + " ");

		search(inStart, inorderIdx[root] - 1, postStart, postStart + inorderIdx[root] - inStart - 1);
		search(inorderIdx[root] + 1, inEnd, postStart + inorderIdx[root] - inStart, postEnd - 1);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.valueOf(in.readLine());
		inorder = new int[N + 1];
		postorder = new int[N + 1];
		inorderIdx = new int[N + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			inorder[i] = Integer.valueOf(st.nextToken());
			inorderIdx[inorder[i]] = i;
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			postorder[i] = Integer.valueOf(st.nextToken());
		}

		search(1, N, 1, N);
		System.out.println(sb.toString());

	}

}
