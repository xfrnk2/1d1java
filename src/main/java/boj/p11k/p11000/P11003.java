package boj.p11k.p11000;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P11003 {

	static int N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		L = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(in.readLine());
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while (!dq.isEmpty() && dq.peekLast()[0] > num)
				dq.pollLast();
			dq.offer(new int[] { num, i });
			if (dq.peek()[1] < i - (L - 1))
				dq.poll();
			out.write(dq.peek()[0] + " ");
		}
		out.flush();

	}

}
