package boj.p1k.p1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1251 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder(in.readLine());
		String ans = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";

		int size = sb.length();
		for (int i = 1; i < size - 1; i++) {
			for (int j = i; j < size - 1; j++) {

				StringBuilder a = new StringBuilder(sb.substring(0, i));
				StringBuilder b = new StringBuilder(sb.substring(i, j + 1));
				StringBuilder c = new StringBuilder(sb.substring(j + 1, size));

				String s = a.reverse() + "" + b.reverse() + "" + c.reverse();

				if (ans.compareTo(s) > 0) {
					ans = s;
				}

			}
		}
		System.out.println(ans);

	}
}
