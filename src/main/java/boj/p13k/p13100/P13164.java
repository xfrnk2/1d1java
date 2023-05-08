package boj.p13k.p13100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P13164 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		ArrayList<Integer> diffList = new ArrayList();
		int prev = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			diffList.add(cur - prev);
			prev = cur;
		}
		Collections.sort(diffList);
		int ans = 0;
		for (int i = 0; i < N - K; i++) {
			ans += diffList.get(i);
		}
		System.out.println(ans);
	}

}
