package boj.p2k.p2400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>(N);
		ArrayDeque<Integer> idxStack = new ArrayDeque<>(N);

		st = new StringTokenizer(br.readLine());
		stack.add(Integer.parseInt(st.nextToken()));
		idxStack.add(1);
		StringBuilder sb = new StringBuilder();

		sb.append("0 ");

		for (int i = 2; i <= N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek() > cur) {

					break;
				}
				idxStack.pop();
				stack.pop();
			}
			sb.append(idxStack.isEmpty() ? "0 " : idxStack.peek() + " ");
			idxStack.push(i);
			stack.push(cur);
		}
		System.out.println(sb);

	}
}
