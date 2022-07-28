package boj.p2k.p2900;

import java.util.Arrays;

public class P2920 {

	public static void main(Integer[] arr) {
		Integer[] copy = Arrays.copyOf(arr, arr.length);

		if (arr[0] == 1) {
			Arrays.sort(copy);
			if (Arrays.equals(arr, copy)) {
				System.out.print("ascending");
			} else {
				System.out.print("mixed");
			}
		} else if (arr[0] == 8) {
			Arrays.sort(copy, (a, b) -> b - a);
			if (Arrays.equals(arr, copy)) {
				System.out.print("descending");
			} else {
				System.out.print("mixed");
			}
		} else {
			System.out.print("mixed");
		}
	}
}
