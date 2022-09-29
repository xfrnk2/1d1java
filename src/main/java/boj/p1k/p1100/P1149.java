package boj.p1k.p1100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		int pr, pg, pb;
		int r, g, b;

		StringTokenizer st = new StringTokenizer(in.readLine());
		r = pr = Integer.valueOf(st.nextToken());
		g = pg = Integer.valueOf(st.nextToken());
		b = pb = Integer.valueOf(st.nextToken());

		while (--n > 0) {
			st = new StringTokenizer(in.readLine());
			r = pr;
			g = pg;
			b = pb;
			pr = Math.min(g, b) + Integer.valueOf(st.nextToken());
			pg = Math.min(r, b) + Integer.valueOf(st.nextToken());
			pb = Math.min(r, g) + Integer.valueOf(st.nextToken());

		}

		System.out.println(Math.min(Math.min(pg, pr), pb));
	}

}
