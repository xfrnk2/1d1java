package baekjun.BOJ2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ2745 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		while (st.hasMoreTokens()) {
			ans += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		System.out.println(ans % 10);

	}

}