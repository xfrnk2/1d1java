package boj.p11k.p11600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P11650 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int n = Integer.parseInt(br.readLine());
		int[][] array = new int[n][2]; 
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] el1, int[] el2) {
				if (el1[0] == el2[0]) {
					return el1[1] - el2[1];
				}
				return el1[0] - el2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int[] el : array) {
			sb.append(el[0] + " " + el[1] + "\n");
		}
		System.out.print(sb);
		 
	}

}
