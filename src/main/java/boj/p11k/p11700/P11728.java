package boj.p11k.p11700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11728 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int arr1Length = Integer.parseInt(st.nextToken());
		int arr2Length = Integer.parseInt(st.nextToken());

		int[] arr1 = new int[arr1Length];
		int[] arr2 = new int[arr2Length];
		int[] answer = new int[arr1Length + arr2Length];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr1Length; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr2Length; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		int p1 = 0, p2 = 0;
		for (int i = 0; i < arr1Length + arr2Length; i++) {
			if (p1 >= arr1Length) {
				answer[i] = arr2[p2];
				p2++;
				continue;
			}

			if (p2 >= arr2Length) {
				answer[i] = arr1[p1];
				p1++;
				continue;
			}

			if (arr1[p1] > arr2[p2]) {
				answer[i] = arr2[p2];
				p2++;
			} else {
				answer[i] = arr1[p1];
				p1++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int el : answer) {
			sb.append(el).append(" ");
		}
		System.out.println(sb.toString().trim());

	}

}
