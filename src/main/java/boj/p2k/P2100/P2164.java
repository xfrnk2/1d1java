package boj.p2k.P2100;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		solution(n);
	}

	public static void solution(int n) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (1 < queue.size()) {
			queue.poll();
			queue.offer(queue.poll());
		}
		bw.write(queue.poll() + "");
		bw.flush();
	}
}
