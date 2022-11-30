package boj.p1k.p1700;

import java.util.Arrays;
import java.util.Scanner;

public class P1720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] d = new int[31];
		d[1] = 1;
		d[2] = 3;


		for (int i = 3; i < 31; i++) {
			d[i] = d[i - 2] * 2 + d[i - 1];
		}
		System.out.println(
				N < 3 ? d[N] :
				
				N % 2 == 1 ?
						//완전히 좌우가 대칭인 것을 구하고 더하여 2로 나눈다.
					(d[N] + d[(N - 1) / 2]) / 2	
					:
					(d[N] + d[N / 2] + d[(N - 2) / 2] * 2) / 2
				);
		
	}

}
