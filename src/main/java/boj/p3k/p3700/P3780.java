package boj.p3k.p3700;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3780 {
	static int N;
	static int[] parent, dis;
	static int MOD = 1000;

	static int update(int a) {
		if (a == parent[a])
			return a;
		int p = update(parent[a]);
		dis[a] += dis[parent[a]];
		return parent[a] = p;
	}

	static void connect(int a, int b) {
		parent[a] = b;

	}

	static void init() {
		dis = new int[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {

			N = Integer.parseInt(in.readLine());
			init();

			while (true) {

				st = new StringTokenizer(in.readLine());
				String cmd = st.nextToken();
				if (cmd.equals("O"))
					break;

				if (cmd.equals("E")) {
					int a = Integer.parseInt(st.nextToken());
					update(a);
					sb.append(dis[a] + "\n");
				}

				if (cmd.equals("I")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					connect(a, b);
					dis[a] = Math.abs(a - b) % MOD;
				}
			}
		}
        System.out.print(sb);
	}

}
