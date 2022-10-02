package boj.p2k.p2400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2473 {
	static int n;
	static long[] arr;
	static long v = Long.MAX_VALUE;
	static long[] ans = new long[3]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		arr = new long[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int p = 0, end = n - 2; p < end; p++) {
			int p2 = p + 1, p3 = n - 1;
			while (p2 < p3) {
				long cal = arr[p] + arr[p2] + arr[p3]; 
				
				if (Math.abs(cal) < v) {
					v = Math.abs(cal);
					ans[0] = arr[p];
					ans[1] = arr[p2];
					ans[2] = arr[p3];
					
				};
				
				if (cal < 0) {
					p2 ++;
				} else {
					p3 --;
				}
			}
		
		}
		StringBuilder sb = new StringBuilder();
		for (Long i : ans) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());
		
		
		
	}
}
