package boj.p1k.p1600;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P1624 {

	static final int MAX = Integer.MAX_VALUE;;

	static int N;
	static int[] d;
	static List<Integer> origin;
	static List<Integer> filtered;

	static boolean check(int l, int r, int s, int e) {
		if (r - l <= 1)
			return true;
		l = filtered.get(l);
		r = filtered.get(r);
		for (int i = 0; i < N; i++) {
			if (l > origin.get(i) || r < origin.get(i))
				continue;
			if (s < origin.get(i) && origin.get(i) < e)
				return false;
			s = Math.min(s, origin.get(i));
			e = Math.max(e, origin.get(i));
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		origin = new ArrayList<>();
		filtered = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			origin.add(Integer.parseInt(in.readLine()));
		}

		filtered = origin.stream().distinct().sorted().collect(Collectors.toList());
		int filteredCnt = filtered.size();
		d = new int[filteredCnt];

		Arrays.fill(d, MAX);

		for (int i = 0; i < filteredCnt; i++) {
			if (check(0, i, MAX, -MAX)) {
				d[i] = 1;
				continue;
			}
			for (int j = i; j >= 0; j--) {
				if (check(j, i, MAX, -MAX)) {
					d[i] = Math.min(d[i], d[j - 1] + 1);
				}
			}
		}

		System.out.println(d[filteredCnt - 1]);
	}
}
