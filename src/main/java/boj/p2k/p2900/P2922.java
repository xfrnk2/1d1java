package boj.p2k.p2900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P2922 {


	static Set<Character> moSet;

	public static void main(String[] args) throws IOException {
		moSet = new HashSet<>();
		moSet.add('A');
		moSet.add('E');
		moSet.add('I');
		moSet.add('O');
		moSet.add('U');

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		int len = input.length();
		long ans = dfs(input, 0, len, 0, 0, 0);
		System.out.println(ans);
	}

	public static long dfs(String str, int idx, int len, int ja, int mo, int hasL) {
		if (mo >= 3 || ja >= 3)
			return 0;
		if (idx == len)
			return hasL;
		long res = 0;
		if (str.charAt(idx) == '_') {
			res += dfs(str, idx + 1, len, ja + 1, 0, hasL) * 20;
			res += dfs(str, idx + 1, len, ja + 1, 0, 1);
			res += dfs(str, idx + 1, len, 0, mo + 1, hasL) * 5;
		} else {
			if (moSet.contains(str.charAt(idx))) {
				res += dfs(str, idx + 1, len, 0, mo + 1, hasL);
			} else {
				if (str.charAt(idx) == 'L')
					res += dfs(str, idx + 1, len, ja + 1, 0, 1);
				else
					res += dfs(str, idx + 1, len, ja + 1, 0, hasL);
			}
		}
		return res;
	}

}
