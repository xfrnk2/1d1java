package boj.p2k.p2600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2606 {
	static int[][] edges;
	static int[] visit;
	static int v, e;

	private static void search(int start) {
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		visit[start] = 1;
		q.offer(start);
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i = 0; i < v + 1; i++) {
				if (edges[x][i] == 1 && visit[i] != 1) {
					visit[i] = 1;
					q.offer(i);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		v = sc.nextInt();
		e = sc.nextInt();
		edges = new int[v + 1][v + 1];
		visit = new int[v + 1];

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			edges[a][b] = 1;
			edges[b][a] = 1;
		}
		search(1);
	}
}
