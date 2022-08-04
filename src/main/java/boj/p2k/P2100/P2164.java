package boj.p2k.P2100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solution(n);
	}

	public static void solution(int n) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (1 < queue.size()) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.print(queue.poll());
	}
}
