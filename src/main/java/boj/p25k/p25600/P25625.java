package boj.p25k.p25600;


import java.io.*;
import java.util.*;



public class P25625 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		if (x > y) {
			System.out.println(x+y);
		} else {
			System.out.println(y-x);
		}
	}
}
