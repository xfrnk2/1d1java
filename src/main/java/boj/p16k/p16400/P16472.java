package boj.p16k.p16400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P16472 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		int len = str.length();
		if (len == 1) {
			System.out.println(1);
		} else if (N == 1) {
			System.out.println(1);
		} else {
			int max = 0;
			int left = 0, right = 1;
			Set<Character> set = new HashSet<>();
			set.add(str.charAt(left));
			while (left < len - 1) {

				if (len <= right) {
					max = Math.max(max, right - left);
					break;
				}
				set.add(str.charAt(right));
				if (set.size() == N) {
					max = Math.max(max, 1 + right - left);
					right++;
					continue;
				}
				if (N < set.size()) {
					set.clear();
					left++;
					set.add(str.charAt(left));
					right = left + 1;
					continue;
				}
				right++;

			}

			System.out.println(max);

		}
	}

}
