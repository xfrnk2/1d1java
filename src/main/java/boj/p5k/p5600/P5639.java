package boj.p5k.p5600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P5639 {
	static int N;
	static List<Integer> arrList;
	static StringBuilder sb;

	static class Node {
		int num;
		Node left, right;

		public Node(int num, Node left, Node right) {
			super();
			this.num = num;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return String.format("Node [num=%s, left=%s, right=%s]", num, left, right);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = 0;
		arrList = new ArrayList<>();
		String line = null;
		while (true) {
			try {
				line = in.readLine();
				arrList.add(Integer.valueOf(line));
				N++;

			} catch (Exception e) {
				break;
			}
		}

		postOrder(0, N - 1);
		System.out.println(sb.toString());

	}

	public static void postOrder(int start, int end) {
		if (start > end)
			return;
		int right = end + 1;
		for (int i = start + 1; i < end + 1; i++) {
			if (arrList.get(start) < arrList.get(i)) {
				right = i;
				break;
			}
		}
		postOrder(start + 1, right - 1);
		postOrder(right, end);
		sb.append(arrList.get(start) + "\n");

	}

}
