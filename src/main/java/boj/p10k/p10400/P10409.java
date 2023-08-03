package boj.p10k.p10400;


import java.io.*;
import java.util.*;

public class P10409 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		String[] strArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int cnt = 0;
		int t = Integer.parseInt(arr[1]);
		
		
		for (int i = 0; i < N; i++) {
			int j = Integer.parseInt(strArr[i]);
			if (t < j) break;
            t -= j;
			cnt++;
		}
		System.out.println(cnt);
	}
}
