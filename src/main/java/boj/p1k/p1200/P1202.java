package boj.p1k.p1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1202 {
	static int N, K;
	static long ans = 0;
	static Jewelry[] jewelies;
	static int[] bag;
	static PriorityQueue<Integer> worth;

	static class Jewelry {
		int weight, value;

		public Jewelry(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		jewelies = new Jewelry[N];
		bag = new int[K];
		worth = new PriorityQueue<Integer>(Comparator.reverseOrder());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			jewelies[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(jewelies, new Comparator<Jewelry>() {

			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				return o2.weight == o1.weight ? o2.value - o1.value : o1.weight - o2.weight;
			}

		});

		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(bag);

		for (int i = 0, jIdx = 0; i < K; i++) {

			while (jIdx < N && jewelies[jIdx].weight <= bag[i]) {
				worth.offer(jewelies[jIdx++].value);
			}

			if (!worth.isEmpty()) {
				ans += worth.poll();
			}

		}

		System.out.println(ans);

	}

}
