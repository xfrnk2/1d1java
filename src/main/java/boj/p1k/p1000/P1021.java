package boj.p1k.p1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[m];
		for(int i = 0; i < m; i ++) {
			arr[i] = sc.nextInt();
		}
		solution(n, m, arr);
	}

	public static void solution(int n, int m, int[] arr) {
		List<Integer> deque = new ArrayList<>();
		for (int i = 1; i <= n ; i++) {
			deque.add(i);
		}

		for (int elem: arr) {
			int start = deque.get(0);
			int end = deque.get(0);

			int operation = Math.abs(start - elem) > Math.abs(end - elem) ? 2 : 3;
			if (operation == 2) {
				for (int k = 0; k < Math.abs(end - elem); k ++) {
					deque.remove(0);
				}
			}
		}


	}
}
