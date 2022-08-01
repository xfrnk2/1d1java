package boj.p2k.p2700;

import java.util.Scanner;

public class P2750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		solution(n, arr);

	}

	private static int getMax(int[] arr, int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	private static void countSort(int[] arr, int n, int exp) {
		int[] output = new int[n];
		int[] count = new int[1001];
		for (int i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
		}

		for (int i = 1; i < 1001; i++) {
			count[i] += count[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		System.arraycopy(output, 0, arr, 0, n);
	}

	private static void radixSort(int[] arr, int n) {
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(arr, n, exp);
		}
	}

	private static void print(int[] arr, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(arr[i]).append("\n");
		System.out.print(sb);
	}

	public static void solution(int n, int[] arr) {
		radixSort(arr, n);
		print(arr, n);
	}

}
